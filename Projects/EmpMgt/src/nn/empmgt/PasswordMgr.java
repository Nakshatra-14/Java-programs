package nn.empmgt;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringJoiner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordMgr {

    public void getEncryptedValue(int pos) throws FileNotFoundException {
        try (
                Scanner inp = new Scanner(new File("encryptPassword.txt"))) {
            int c = 0;
            while (inp.hasNextLine()) {
                if (c == pos) {
                    System.out.println(inp.nextLine().length());
                    break;
                }
                c++;
            }
        }
    }

    public String encrypt(char[] pass)
    {
        // pass = axz
        // encrypted = a * 256^2 + x * 256 + z  
        int n = pass.length - 1;
        int value = 0;
        // for(char c : pass)
        // {
        //     value += c * Math.pow(256 , n);
        //     n--;
        // }
        long p = 1;
        for(int i = n ; i >= 0 ; i--)
        {
            value += pass[i] * p;
            p *= 256;
        }
        return String.valueOf(value);
    }

    public void doEncryption(File file) throws IOException {
        try (
                Scanner inp = new Scanner(new File("password.txt"));
                FileWriter fw = new FileWriter(file);) {
            while (inp.hasNextLine()) {
                fw.write(encrypt(inp.nextLine().toCharArray()) + "\n");
            }
        }
    }

    void main() throws FileNotFoundException, IOException {
        JFrame frame = new JFrame("Change Password");
        frame.setSize(350, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center window

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createLineBorder(Color.white, 10));

        JLabel oldPassLabel = new JLabel("Old Password:");
        JLabel newPassLabel = new JLabel("New Password:");
        JLabel rePassLabel = new JLabel("Re-enter Password:");

        JPasswordField oldPassField = new JPasswordField();
        JPasswordField newPassField = new JPasswordField();
        JPasswordField rePassField = new JPasswordField();

        JButton submitButton = new JButton("Submit");

        panel.add(oldPassLabel);
        panel.add(oldPassField);

        panel.add(newPassLabel);
        panel.add(newPassField);

        panel.add(rePassLabel);
        panel.add(rePassField);

        panel.add(new JLabel("."));
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPass = new String(newPassField.getPassword());
                String rePass = new String(rePassField.getPassword());

                if (newPass.equals(rePass)) {
                    JOptionPane.showMessageDialog(frame,
                            "Password changed successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame,"New passwords do not match! Error");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);

        doEncryption(new File("encryptPassword.txt"));
    }
}
