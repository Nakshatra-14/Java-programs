package com.example.nn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

import org.vosk.LibVosk;
import org.vosk.LogLevel;
import org.vosk.Model;
import org.vosk.Recognizer;

import javax.sound.sampled.*;
import java.io.IOException;

public class SpeakerListenerTest {

    public static void main(String[] args) {
        // 1. Tell Vosk not to spam the console with logs
        LibVosk.setLogLevel(LogLevel.WARNINGS);

        // 2. Load the downloaded Vosk model from your project folder
        // Make sure the path matches where you extracted the model!
        System.out.println("Loading Vosk Model...");
        try (Model model = new Model("E:\\code\\Java\\Projects\\Experiment\\screen\\model\\vosk-model-small-en-us-0.15")) {
            System.out.println("Model loaded successfully!");

            // 3. Set up the Audio Format (Standard for Speech Recognition: 16kHz, 16-bit, Mono)
            AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Microphone/Stereo Mix not supported!");
                return;
            }

            // 4. Open the microphone / Stereo mix
            TargetDataLine microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            microphone.start();
            System.out.println("Listening to system audio... (Play a YouTube video with talking to test)");

            // 5. Initialize the Vosk Recognizer
            try (Recognizer recognizer = new Recognizer(model, 16000)) {
                int bytesRead;
                byte[] b = new byte[4096];

                // 6. Infinite loop to continuously read audio and transcribe it
                while (true) {
                    bytesRead = microphone.read(b, 0, b.length);
                    
                    if (recognizer.acceptWaveForm(b, bytesRead)) {
                        // This triggers when the person finishes a sentence
                        System.out.println("Final: " + recognizer.getResult());
                    } else {
                        // This shows the text updating in real-time as they speak
                        System.out.println("Partial: " + recognizer.getPartialResult());
                    }
                }
            }
        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}