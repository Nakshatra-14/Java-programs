import sys
import os
import threading
import ctypes
from ctypes import wintypes

import speech_recognition as sr
import google.generativeai as genai
import keyboard

from PyQt5.QtWidgets import (
    QApplication, QMainWindow, QTextEdit,
    QVBoxLayout, QWidget, QPushButton,
    QLabel, QLineEdit
)
from PyQt5.QtCore import Qt, pyqtSignal, QObject
from PyQt5.QtGui import QFont

# ================= WINDOWS: HIDE FROM SCREEN CAPTURE =================

def exclude_window_from_capture(win_id):
    user32 = ctypes.windll.user32
    WDA_EXCLUDEFROMCAPTURE = 0x11
    user32.SetWindowDisplayAffinity(
        wintypes.HWND(win_id),
        WDA_EXCLUDEFROMCAPTURE
    )

# ================= SIGNALS =================

class UpdateSignal(QObject):
    update_text = pyqtSignal(str)
    update_status = pyqtSignal(str)

# ================= MAIN APP =================

class InterviewAssistant(QMainWindow):
    def __init__(self):
        super().__init__()

        # ---------- CONFIG ----------
        self.SYSTEM_AUDIO_INDEX = 23  # Stereo Mix device index

        # ---------- WINDOW ----------
        self.setWindowFlags(
            Qt.FramelessWindowHint |
            Qt.WindowStaysOnTopHint |
            Qt.Tool |
            Qt.BypassWindowManagerHint
        )
        self.setAttribute(Qt.WA_TranslucentBackground)
        self.setGeometry(1400, 200, 420, 330)

        # ---------- UI ----------
        self.main_widget = QWidget()
        self.layout = QVBoxLayout(self.main_widget)

        self.status_label = QLabel("Ready")
        self.answer_display = QTextEdit()
        self.answer_display.setReadOnly(True)

        self.prompt_input = QLineEdit()
        self.prompt_input.setPlaceholderText("Type a question and press Enter...")
        self.prompt_input.returnPressed.connect(self.manual_prompt)

        self.toggle_btn = QPushButton("Start Listening")
        self.toggle_btn.clicked.connect(self.toggle_listening)

        self.layout.addWidget(self.status_label)
        self.layout.addWidget(self.answer_display)
        self.layout.addWidget(self.prompt_input)
        self.layout.addWidget(self.toggle_btn)

        self.setCentralWidget(self.main_widget)

        # ---------- STYLE ----------
        self.setStyleSheet("""
        QWidget {
            background-color: rgba(25,25,35,220);
            color: #e0e0e0;
        }
        QTextEdit, QLineEdit {
            background-color: rgba(45,45,60,200);
            border-radius: 5px;
            padding: 6px;
        }
        QPushButton {
            background-color: rgba(70,70,90,200);
            border-radius: 5px;
            padding: 6px;
        }
        QPushButton:hover {
            background-color: rgba(90,90,120,220);
        }
        """)

        # ---------- SIGNALS ----------
        self.signals = UpdateSignal()
        self.signals.update_text.connect(self.answer_display.setText)
        self.signals.update_status.connect(self.status_label.setText)

        # ---------- SPEECH ----------
        self.recognizer = sr.Recognizer()

        # ---------- GEMINI ----------
        os.environ["GRPC_VERBOSITY"] = "ERROR"
        os.environ["GLOG_minloglevel"] = "2"

        genai.configure(api_key="AIzaSyCtbf2oe9GUUqmgqTP8xETzjyiVzLsZUvI")
        self.model = genai.GenerativeModel("gemini-2.5-flash")

        self.base_prompt = (
            "You are an interview assistant. "
            "Answer clearly and concisely."
        )

        # ---------- STATE ----------
        self.listening = False
        self.listen_thread = None

        # ---------- HOTKEYS ----------
        keyboard.add_hotkey("ctrl+space", self.toggle_listening)
        keyboard.add_hotkey("shift+q", self.force_exit)

    # ================= LOGIC =================

    def toggle_listening(self):
        if self.listening:
            self.stop_listening()
        else:
            self.start_listening()

    def start_listening(self):
        self.listening = True
        self.toggle_btn.setText("Stop Listening")
        self.signals.update_status.emit("Listening...")

        self.listen_thread = threading.Thread(
            target=self.listen_loop, daemon=True
        )
        self.listen_thread.start()

    def stop_listening(self):
        self.listening = False
        self.toggle_btn.setText("Start Listening")
        self.signals.update_status.emit("Ready")

    def listen_loop(self):
        while self.listening:
            try:
                # Capture system audio via Stereo Mix
                with sr.Microphone(device_index=self.SYSTEM_AUDIO_INDEX) as source:
                    self.recognizer.adjust_for_ambient_noise(source, duration=0.3)
                    audio = self.recognizer.listen(
                        source, timeout=1, phrase_time_limit=6
                    )

                if not self.listening:
                    break

                question = self.recognizer.recognize_google(audio)
                self.ask_gemini(question)

            except sr.WaitTimeoutError:
                continue
            except sr.UnknownValueError:
                continue
            except Exception as e:
                self.signals.update_status.emit(str(e))
                self.stop_listening()
                break

    def manual_prompt(self):
        text = self.prompt_input.text().strip()
        if text:
            self.prompt_input.clear()
            self.ask_gemini(text)

    def ask_gemini(self, question):
        self.signals.update_status.emit("Thinking...")
        prompt = f"{self.base_prompt}\n\nQuestion: {question}\nAnswer:"
        response = self.model.generate_content(prompt)
        self.signals.update_text.emit(f"Q: {question}\n\nA: {response.text}")
        self.signals.update_status.emit("Ready")

    def force_exit(self):
        self.listening = False
        QApplication.quit()

# ================= MAIN =================

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = InterviewAssistant()
    window.show()

    # Hide from screen capture (Windows)
    hwnd = int(window.winId())
    exclude_window_from_capture(hwnd)

    sys.exit(app.exec_())
