package com.example.nn;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public class HiddenApp {

    public interface MyUser32 extends StdCallLibrary {
        MyUser32 INSTANCE = Native.load("user32", MyUser32.class, W32APIOptions.DEFAULT_OPTIONS);
        int WDA_EXCLUDEFROMCAPTURE = 0x00000011;
        boolean SetWindowDisplayAffinity(HWND hWnd, int dwAffinity);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Secret Window");
            
            // 1. Remove the Windows title bar and borders (Required for translucency)
            frame.setUndecorated(true);
            
            // 2. Set background to Black with 150 Alpha (0 is invisible, 255 is solid)
            frame.setBackground(new Color(0, 0, 0, 150)); 
            
            frame.setSize(450, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            
            JLabel label = new JLabel("Invisible to OBS, but you can see through it!", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            // 3. Make the text white so it pops against the dark, translucent background
            label.setForeground(Color.WHITE); 
            frame.add(label);

            // --- BONUS: Make the window draggable since we removed the title bar ---
            MouseAdapter dragListener = new MouseAdapter() {
                int pX, pY;
                public void mousePressed(MouseEvent e) {
                    pX = e.getX();
                    pY = e.getY();
                }
                public void mouseDragged(MouseEvent e) {
                    frame.setLocation(frame.getLocation().x + e.getX() - pX, 
                                      frame.getLocation().y + e.getY() - pY);
                }
            };
            frame.addMouseListener(dragListener);
            frame.addMouseMotionListener(dragListener);
            // -----------------------------------------------------------------------

            frame.setVisible(true);

            Pointer pointer = Native.getWindowPointer(frame);
            HWND hwnd = new HWND(pointer);

            boolean result = MyUser32.INSTANCE.SetWindowDisplayAffinity(hwnd, MyUser32.WDA_EXCLUDEFROMCAPTURE);

            if (result) {
                System.out.println("Success: Translucent window is hidden from capture.");
            } else {
                System.out.println("Failed: Could not hide window.");
            }
        });
    }
}