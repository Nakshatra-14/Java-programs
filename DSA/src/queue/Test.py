# import sys
# import ctypes
# from ctypes import wintypes
# import requests
# import json
# import speech_recognition as sr

# from PyQt5.QtWidgets import QApplication, QMainWindow, QTextEdit, QVBoxLayout, QWidget, QPushButton, QHBoxLayout
# from PyQt5.QtCore import Qt, QThread, pyqtSignal

# # ---------------- WINDOWS: HIDE FROM SCREEN CAPTURE ----------------
# def exclude_window_from_capture(win_id):
#     try:
#         user32 = ctypes.windll.user32
#         WDA_EXCLUDEFROMCAPTURE = 0x11
#         user32.SetWindowDisplayAffinity(
#             wintypes.HWND(win_id),
#             WDA_EXCLUDEFROMCAPTURE
#         )
#     except Exception as e:
#         print("Could not hide window from capture:", e)

# # ---------------- CUSTOM TEXTEDIT ----------------
# class PointerTextEdit(QTextEdit):
#     """A QTextEdit that keeps the cursor as a normal pointer (arrow) always."""
#     def __init__(self, *args, **kwargs):
#         super().__init__(*args, **kwargs)
#         self.setCursor(Qt.ArrowCursor)  
#         self.setTextInteractionFlags(Qt.TextEditorInteraction)  
#         self.viewport().setCursor(Qt.ArrowCursor)  

#     def mouseMoveEvent(self, event):
#         self.viewport().setCursor(Qt.ArrowCursor)  
#         super().mouseMoveEvent(event)

#     def mousePressEvent(self, event):
#         self.viewport().setCursor(Qt.ArrowCursor)  
#         super().mousePressEvent(event)

#     def keyPressEvent(self, event):
#         self.viewport().setCursor(Qt.ArrowCursor)  
#         super().keyPressEvent(event)

#     def focusInEvent(self, event):
#         self.viewport().setCursor(Qt.ArrowCursor)  
#         super().focusInEvent(event)

#     def enterEvent(self, event):
#         self.viewport().setCursor(Qt.ArrowCursor)  
#         super().enterEvent(event)


# # ---------------- VOICE RECOGNITION THREAD ----------------
# class VoiceWorker(QThread):
#     """Runs in the background to listen to audio without freezing the GUI."""
#     transcription_ready = pyqtSignal(str)
#     status_update = pyqtSignal(str)

#     def __init__(self):
#         super().__init__()
#         self._is_running = True

#     def run(self):
#         recognizer = sr.Recognizer()
#         try:
#             with sr.Microphone() as source:
#                 self.status_update.emit("Adjusting for noise...")
#                 recognizer.adjust_for_ambient_noise(source, duration=1)
#                 self.status_update.emit("Listening to Meet...")
                
#                 while self._is_running:
#                     try:
#                         # Listen in short chunks so we can interrupt if the user clicks Stop
#                         audio = recognizer.listen(source, timeout=1, phrase_time_limit=15)
#                         self.status_update.emit("Processing speech...")
#                         text = recognizer.recognize_google(audio)
                        
#                         self.transcription_ready.emit(text)
#                         self.status_update.emit("Ready")
#                         self._is_running = False  # Stop after capturing one phrase
#                         break
                        
#                     except sr.WaitTimeoutError:
#                         continue  # Nobody spoke, loop back and keep listening
#                     except sr.UnknownValueError:
#                         self.status_update.emit("Listening to Meet...")  # Audio not clear, keep trying
#                     except sr.RequestError as e:
#                         self.status_update.emit(f"API Error: {e}")
#                         self._is_running = False
#         except Exception as e:
#             self.status_update.emit(f"Mic Error: {e}")

#     def stop(self):
#         self._is_running = False


# # ---------------- MAIN WINDOW ----------------
# class AIChatWindow(QMainWindow):
#     WINDOW_WIDTH = 800
#     WINDOW_HEIGHT = 600

#     def __init__(self):
#         super().__init__()

#         # ---------- WINDOW ----------
#         self.setWindowTitle("AI Chat")
#         self.setGeometry(1000, 200, self.WINDOW_WIDTH, self.WINDOW_HEIGHT)
#         self.setWindowFlags(
#             Qt.FramelessWindowHint |
#             Qt.WindowStaysOnTopHint |
#             Qt.Tool |
#             Qt.BypassWindowManagerHint
#         )
#         self.setAttribute(Qt.WA_TranslucentBackground)

#         # ---------- CENTRAL WIDGET & LAYOUT ----------
#         central_widget = QWidget(self)
#         self.setCentralWidget(central_widget)
#         layout = QVBoxLayout(central_widget)

#         # ---------- INPUT TEXT EDIT ----------
#         self.input_text_edit = PointerTextEdit(self)
#         self.input_text_edit.setPlaceholderText("Question will appear here...")
#         self.input_text_edit.setStyleSheet("""
#             QTextEdit {
#                 background-color: rgba(25, 25, 35, 220);
#                 color: #e0e0e0;
#                 border-radius: 6px;
#                 padding: 8px;
#                 font-size: 14px;
#             }
#         """)
#         layout.addWidget(self.input_text_edit)

#         # ---------- BUTTONS LAYOUT ----------
#         button_layout = QHBoxLayout()

#         self.listen_button = QPushButton("Listen", self)
#         self.listen_button.clicked.connect(self.toggle_listen)
#         button_layout.addWidget(self.listen_button)

#         self.submit_button = QPushButton("Submit", self)
#         self.submit_button.clicked.connect(self.on_submit)
#         button_layout.addWidget(self.submit_button)

#         layout.addLayout(button_layout)

#         # ---------- OUTPUT TEXT EDIT ----------
#         self.output_text_edit = PointerTextEdit(self)
#         self.output_text_edit.setStyleSheet("""
#             QTextEdit {
#                 background-color: rgba(25, 25, 35, 220);
#                 color: #e0e0e0;
#                 border-radius: 6px;
#                 padding: 8px;
#                 font-size: 14px;
#             }
#         """)
#         layout.addWidget(self.output_text_edit)

#         # ---------- VARIABLES ----------
#         self._drag_active = False
#         self._drag_pos = None
#         self.voice_thread = None

#     # ---------- MOUSE DRAG EVENTS ----------
#     def mousePressEvent(self, event):
#         if event.button() == Qt.LeftButton:
#             self._drag_active = True
#             self._drag_pos = event.globalPos() - self.frameGeometry().topLeft()
#             event.accept()

#     def mouseMoveEvent(self, event):
#         if self._drag_active and event.buttons() == Qt.LeftButton:
#             self.move(event.globalPos() - self._drag_pos)
#             event.accept()

#     def mouseReleaseEvent(self, event):
#         self._drag_active = False

#     # ---------- VOICE LISTENING FUNCTIONS ----------
#     def toggle_listen(self):
#         if self.voice_thread and self.voice_thread.isRunning():
#             # Stop listening
#             self.voice_thread.stop()
#             self.listen_button.setText("Listen")
#             self.listen_button.setStyleSheet("")
#         else:
#             # Start listening
#             self.voice_thread = VoiceWorker()
#             self.voice_thread.transcription_ready.connect(self.on_transcription_ready)
#             self.voice_thread.status_update.connect(self.update_listen_status)
#             self.voice_thread.finished.connect(self.on_listen_finished)
            
#             self.voice_thread.start()
#             self.listen_button.setText("Stop Listening")
#             self.listen_button.setStyleSheet("background-color: #aa0000; color: white;")

#     def update_listen_status(self, status_msg):
#         self.input_text_edit.setPlaceholderText(status_msg)

#     def on_transcription_ready(self, text):
#         # Insert the recognized text into the input field
#         self.input_text_edit.setText(text)

#     def on_listen_finished(self):
#         self.listen_button.setText("Listen")
#         self.listen_button.setStyleSheet("")
#         self.input_text_edit.setPlaceholderText("Question will appear here...")

#     # ---------- SUBMIT FUNCTION ----------
#     def on_submit(self):
#         user_input = self.input_text_edit.toPlainText()
#         if not user_input.strip():
#             return
            
#         self.output_text_edit.setText("Fetching AI response...")
#         QApplication.processEvents() # Force UI update before blocking API call
        
#         response = self.call_api(user_input)
#         self.output_text_edit.setText(response)

#     # ---------- API CALL FUNCTION ----------
#     def call_api(self, user_input):
#         try:
#             response = requests.post(
#                 url="https://openrouter.ai/api/v1/chat/completions",
#                 headers={
#                     "Authorization": "Bearer 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",
#                     "Content-Type": "application/json",
#                 },
#                 data=json.dumps({
#                     "model": "minimax/minimax-m2.5",
#                     "messages": [{"role": "user", "content": user_input}],
#                     "reasoning": {"enabled": True}
#                 }),
#                 timeout=15 # Added a timeout so the app doesn't hang forever if API is down
#             )
#             response.raise_for_status()
#             data = response.json()
#             return data['choices'][0]['message'].get('content', 'No response from API')
#         except Exception as e:
#             return f"API Error: {str(e)}"

# # ---------------- MAIN ----------------
# if __name__ == "__main__":
#     app = QApplication(sys.argv)
#     window = AIChatWindow()
#     window.show()

#     hwnd = int(window.winId())
#     exclude_window_from_capture(hwnd)

#     sys.exit(app.exec_())

import speech_recognition as sr

def main():
    # 1. List all available audio devices
    print("--- Available Audio Devices ---")
    device_names = sr.Microphone.list_microphone_names()
    for index, name in enumerate(device_names):
        print(f"[{index}] {name}")
    print("-------------------------------")

    # 2. Ask the user which one to use
    print("\nLook at the list above. To capture desktop audio, look for 'Stereo Mix', 'What U Hear', or 'CABLE Output'.")
    user_input = input("Enter the number of the device you want to use: ")
    
    try:
        device_idx = int(user_input)
    except ValueError:
        print("Please enter a valid number.")
        return

    # 3. Try to listen to that specific device
    recognizer = sr.Recognizer()
    
    print(f"\nConnecting to device [{device_idx}]...")
    try:
        # We explicitly pass the device_index here!
        with sr.Microphone(device_index=device_idx) as source:
            print("Adjusting for background noise... (Play some audio/video right now!)")
            recognizer.adjust_for_ambient_noise(source, duration=2)
            
            print("Listening... (Play the audio you want to transcribe)")
            # It will listen for up to 10 seconds of speech
            audio = recognizer.listen(source, timeout=5, phrase_time_limit=10)
            
            print("Audio captured! Sending to Google for transcription...")
            text = recognizer.recognize_google(audio)
            
            print("\n===============================")
            print(f"TRANSCRIPTION: {text}")
            print("===============================")
            
    except sr.WaitTimeoutError:
        print("\n[Error] Timed out. Python didn't hear any audio on this device. The routing might be wrong.")
    except sr.UnknownValueError:
        print("\n[Error] Python heard audio, but Google couldn't understand any words in it.")
    except Exception as e:
        print(f"\n[Critical Error] {e}")

if __name__ == "__main__":
    main()