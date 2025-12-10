package nn.gui ;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ColorChanging extends JFrame{

    private int num = 0;

    public ColorChanging() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p = new DrawingPanel();

        new Timer(200, _ -> {
            p.repaint();
        }).start();

        this.add(p);
        // this.pack();
        // this
    }

    private class DrawingPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            int x = getWidth();
            int y = getHeight();
            g.setColor((changeColor() == 1) ? Color.red : Color.green);
            g.fillRect(x/2 - 30/2 , y/2 - 30/2, 30, 30);

            // g.setColor((changeColor() == 1) ? Color.yellow : Color.cyan);
            // g.fillRect(x/2 - 30/2 , (y/2 - 30/2) + 40, 30, 30);

            // g.setColor((changeColor() == 1) ? Color.blue : Color.orange);
            // g.fillRect(x/2 - 30/2 , (y/2 - 30/2) + 80, 30, 30);
        }
    }

    public int changeColor()
    {
        if (num == 0)
        {
            num = 1;
            return num;
        }
        else
        {
            num = 0;
            return num;
        }
    }

    public static void main(String[] args) {
        new ColorChanging().setVisible(true);
    }
    
}
