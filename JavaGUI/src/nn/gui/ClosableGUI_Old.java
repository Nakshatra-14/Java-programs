package nn.gui;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ClosableGUI_Old {

    public static void main(String[] args) {

        JFrame frm = new JFrame();

        WindowListener lst = new MyWindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        frm.addWindowListener(lst);

        frm.setTitle("First GUI Program");
        frm.setSize(500, 300);
        frm.setLocation(100, 50);

        frm.setVisible(true);
    }

}

class MyWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
