package nn.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class DigitalClock extends JFrame{

    public DigitalClock()
    {
        setTitle("Digital Clock");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        JLabel lblTime = new JLabel(new Date().toString());
        p.add(lblTime);
        add(p);

        new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                lblTime.setText(new Date().toString());
            }
        }).start();
    }

    public static void main(String[] args) {
        new DigitalClock().setVisible(true);
    }
}