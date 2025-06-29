package nn.gui;

import javax.swing.JFrame;

public class ClosableGUI_New {
    
    public static void main(String[] args) {

        JFrame frm = new JFrame();

        frm.setTitle("First GUI Program");
        frm.setSize(500, 300);
        frm.setLocation(100, 50);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        frm.setVisible(true);
    }
}
