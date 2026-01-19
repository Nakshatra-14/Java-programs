import sys
import os
import threading
import queue
import speech_recognition as sr
import google.generativeai as genai
from PyQt5.QtWidgets import QApplication, QMainWindow, QTextEdit, QVBoxLayout, QWidget, QPushButton, QLineEdit, QLabel
from PyQt5.QtCore import Qt, QTimer, pyqtSignal, QObject
from PyQt5.QtGui import QFont, QColor, QPalette
import keyboard

# Signal class for thread-safe communication
class UpdateSignal(QObject):
    update_text = pyqtSignal(str)

class InterviewAssistant(QMainWindow):
    def __init__(self):
        super().__init__()
        # Initialize signal
        self.update_signal = UpdateSignal()
        self.update_signal.update_text.connect(self.update_answer_text)
        
        # Set up the main window
        self.setWindowTitle("Interview Assistant")
        self.setWindowFlags(Qt.FramelessWindowHint | Qt.WindowStaysOnTopHint | Qt.Tool)
        self.setAttribute(Qt.WA_TranslucentBackground)
        self.setAttribute(Qt.WA_ShowWithoutActivating)
        
        # Set window size and position
        self.setGeometry(1400, 200, 400, 300)
        
        # Create the main widget and layout
        self.main_widget = QWidget()
        self.main_widget.setObjectName("mainWidget")
        self.layout = QVBoxLayout(self.main_widget)
        
        # Create the answer display
        self.answer_display = QTextEdit()
        self.answer_display.setReadOnly(True)
        self.answer_display.setFont(QFont("Arial", 10))
        self.answer_display.setObjectName("answerDisplay")
        
        # Create the prompt input
        self.prompt_input = QLineEdit()
        self.prompt_input.setPlaceholderText("Enter custom prompt here...")
        self.prompt_input.setObjectName("promptInput")
        
        # Create the status label
        self.status_label = QLabel("Ready")
        self.status_label.setObjectName("statusLabel")
        
        # Create the start button
        self.start_button = QPushButton("Start Listening")
        self.start_button.setObjectName("startButton")
        self.start_button.clicked.connect(self.toggle_listening)
        
        # Add widgets to layout
        self.layout.addWidget(self.status_label)
        self.layout.addWidget(self.answer_display)
        self.layout.addWidget(self.prompt_input)
        self.layout.addWidget(self.start_button)
        
        # Set the main widget
        self.setCentralWidget(self.main_widget)
        
        # Set style sheet for transparency and appearance
        self.setStyleSheet("""
            #mainWidget {
                background-color: rgba(30, 30, 40, 200);
                border-radius: 10px;
                border: 1px solid rgba(100, 100, 120, 100);
            }
            #answerDisplay {
                background-color: rgba(40, 40, 50, 180);
                color: #e0e0e0;
                border: 1px solid rgba(100, 100, 120, 100);
                border-radius: 5px;
                padding: 5px;
            }
            #promptInput {
                background-color: rgba(40, 40, 50, 180);
                color: #e0e0e0;
                border: 1px solid rgba(100, 100, 120, 100);
                border-radius: 5px;
                padding: 5px;
            }
            #statusLabel {
                color: #e0e0e0;
                padding: 5px;
            }
            #startButton {
                background-color: rgba(60, 60, 80, 180);
                color: #e0e0e0;
                border: 1px solid rgba(100, 100, 120, 100);
                border-radius: 5px;
                padding: 5px;
            }
            #startButton:hover {
                background-color: rgba(80, 80, 100, 180);
            }
        """)
        
        # Initialize speech recognition
        self.recognizer = sr.Recognizer()
        self.microphone = sr.Microphone()
        
        # Initialize Gemini
        self.api_key = "AIzaSyBfTl8ctnt_hrdXCtqFmjh-C77REG2Uu5g"
        self.model = None
        self.custom_prompt = "You are an interview assistant. Provide concise, helpful answers to interview questions."
        
        # Listening state
        self.is_listening = False
        self.listening_thread = None
        
        # Queue for communication between threads
        self.question_queue = queue.Queue()
        
        # Set up keyboard shortcut
        keyboard.add_hotkey('ctrl+space', self.toggle_listening)
        
        # Check if API key exists
        self.check_api_key()
    
    def check_api_key(self):
        """Check if API key is saved or prompt for it"""
        if os.path.exists("api_key.txt"):
            with open("api_key.txt", "r") as f:
                self.api_key = f.read().strip()
            self.setup_gemini()
        else:
            self.prompt_for_api_key()
    
    def prompt_for_api_key(self):
        """Prompt user for API key"""
        self.api_key, ok = QLineEdit.getText(self, "API Key", "Enter your Gemini API key:")
        if ok and self.api_key:
            with open("api_key.txt", "w") as f:
                f.write(self.api_key)
            self.setup_gemini()
    
    def setup_gemini(self):
        """Set up the Gemini model"""
        try:
            genai.configure(api_key=self.api_key)
            self.model = genai.GenerativeModel('gemini-1.5-flash')
            self.status_label.setText("Gemini model ready")
        except Exception as e:
            self.status_label.setText(f"Error: {str(e)}")
    
    def toggle_listening(self):
        """Toggle the listening state"""
        if not self.model:
            self.status_label.setText("Please set up API key first")
            return
            
        if self.is_listening:
            self.stop_listening()
        else:
            self.start_listening()
    
    def start_listening(self):
        """Start listening for questions"""
        self.is_listening = True
        self.start_button.setText("Stop Listening")
        self.status_label.setText("Listening...")
        
        # Start the listening thread
        self.listening_thread = threading.Thread(target=self.listen_for_questions)
        self.listening_thread.daemon = True
        self.listening_thread.start()
    
    def stop_listening(self):
        """Stop listening for questions"""
        self.is_listening = False
        self.start_button.setText("Start Listening")
        self.status_label.setText("Ready")
    
    def listen_for_questions(self):
        """Listen for questions in a separate thread"""
        with self.microphone as source:
            self.recognizer.adjust_for_ambient_noise(source)
            
        while self.is_listening:
            try:
                with self.microphone as source:
                    audio = self.recognizer.listen(source, timeout=1, phrase_time_limit=5)
                
                # Recognize speech
                question = self.recognizer.recognize_google(audio)
                
                # Update status
                self.status_label.setText(f"Heard: {question[:30]}...")
                
                # Get custom prompt
                custom_prompt = self.prompt_input.text() or self.custom_prompt
                
                # Generate answer
                full_prompt = f"{custom_prompt}\n\nQuestion: {question}\n\nAnswer:"
                response = self.model.generate_content(full_prompt)
                answer = response.text
                
                # Update the answer display
                self.update_signal.update_text.emit(f"Q: {question}\n\nA: {answer}")
                
            except sr.WaitTimeoutError:
                # No speech detected, continue listening
                pass
            except sr.UnknownValueError:
                # Could not understand audio
                pass
            except Exception as e:
                self.status_label.setText(f"Error: {str(e)}")
                break
    
    def update_answer_text(self, text):
        """Update the answer display (thread-safe)"""
        self.answer_display.setText(text)
    
    def closeEvent(self, event):
        """Handle close event"""
        self.stop_listening()
        event.accept()

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = InterviewAssistant()
    window.show()
    sys.exit(app.exec_())