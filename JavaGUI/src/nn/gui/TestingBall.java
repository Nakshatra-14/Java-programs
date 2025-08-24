package nn.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TestingBall extends JFrame {

    int h = 0, w = 0;
    int inc = 2;
    

    public TestingBall() {
        setTitle("Ball");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawPanel();

        add(p);

        // setBackground(Color.green);

        new Timer(5, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(w + 40 >= getWidth())
                    inc = -5;
                else if(w <= 0)
                    inc = 5;
                w += inc;
                // System.out.println(w);
                p.repaint();
            }
        }).start();
    }

    

    public static void main(String[] args) {
        new TestingBall().setVisible(true);
    }

    public class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            // h = getHeight();
            // w = getWidth();
            super.paintComponent(g);
            g.fillOval(w, h, 20, 20);
            // g.fillOval(w, h+20, 20, 20);
            // g.fillOval(w, h+40, 20, 20);
            // g.fillOval(w, h+60, 20, 20);
            // g.fillOval(w, h+80, 20, 20);
        }
    }
}
