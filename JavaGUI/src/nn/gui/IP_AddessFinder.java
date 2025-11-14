package nn.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class IP_AddessFinder {
    static String url;
    public static void main(String[] args) {
        JFrame frm = new JFrame();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Enter URL");
        JTextField txtfld = new JTextField(20);
        JTextArea output = new JTextArea(1, 20);
        JPanel p = new JPanel();
        p.add(label);
        p.add(txtfld);
        
        JButton btn = new JButton("Submit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                url = txtfld.getText();
                String msg;
                try
                {
                    InetAddress ia = InetAddress.getByName(url);
                    // msg = ia.getHostAddress();
                    msg = ia.getHostName();
                    // JOptionPane.showMessageDialog(frm, msg);
                    output.setText(msg);
                }
                catch(UnknownHostException ex)
                {
                    JOptionPane.showMessageDialog(frm, ex.toString());
                }
            }
        });
    
        p.add(btn);
        p.add(output);
        frm.add(p);
        frm.getRootPane().setDefaultButton(btn);
        frm.pack();
        frm.setVisible(true);
    }
}
