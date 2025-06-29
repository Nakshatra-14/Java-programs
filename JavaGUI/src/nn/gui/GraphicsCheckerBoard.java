package nn.gui;

import javax.swing.*;
import java.awt.*;

class GraphicsCheckerBoard extends JFrame {

    GraphicsCheckerBoard() {
        setTitle("Checker Board");
        setSize(800, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawingPanel();
        add(p);
    }

    public static void main(String[] args) {
        new GraphicsCheckerBoard().setVisible(true);
    }

    class DrawingPanel extends JPanel {

        protected void paintComponent(Graphics g) {
            int wd = getWidth();
            int ht = getHeight();

            int boardSize;
            // int boardSize = 300;
            // int boardSize = 800;

            if(wd > ht)
                boardSize = ht;
            else
                boardSize = wd;

            int xMin = (wd - boardSize)/2;
            int yMin = (ht - boardSize)/2;

            // g.setColor(Color.red);
            g.drawRect(xMin, yMin, boardSize, boardSize);

            int n = boardSize / 8;

            Color b = Color.BLACK;
            Color w = Color.WHITE;

            xMin = xMin + 2;
            yMin = yMin + 2;

            for(int i = 0 ; i < 8 ; i++)
            {
                for(int j = 0; j < 8 ; j++)
                {

                }
            }

            // Row 1
            g.setColor(b);
            g.fillRect(xMin, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*2, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*3, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*4, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*5, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*6, yMin, n, n);
            // g.setColor(Color.pink);
            g.setColor(w);
            g.fillRect(xMin + n*7, yMin, n, n);

            //Row 2
            yMin = yMin + n;
            g.setColor(w);
            g.fillRect(xMin, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*2, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*3, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*4, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*5, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*6, yMin, n, n);
            // g.setColor(Color.yellow);
            g.setColor(b);
            g.fillRect(xMin + n*7, yMin, n, n);

            //Row 3
            yMin = yMin + n;
            g.setColor(b);
            g.fillRect(xMin, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*2, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*3, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*4, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*5, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*6, yMin, n, n);
            // g.setColor(Color.CYAN);
            g.setColor(w);
            g.fillRect(xMin + n*7, yMin, n, n);

            //Row 4
            yMin = yMin + n;
            g.setColor(w);
            g.fillRect(xMin, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*2, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*3, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*4, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*5, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*6, yMin, n, n);
            // g.setColor(Color.orange);
            g.setColor(b);
            g.fillRect(xMin + n*7, yMin, n, n);

            //Row 5
            yMin = yMin + n;
            g.setColor(b);
            g.fillRect(xMin, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*2, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*3, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*4, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*5, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*6, yMin, n, n);
            // g.setColor(Color.magenta);
            g.setColor(w);
            g.fillRect(xMin + n*7, yMin, n, n);

            //Row 6
            yMin = yMin + n;
            g.setColor(w);
            g.fillRect(xMin, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*2, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*3, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*4, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*5, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*6, yMin, n, n);
            // g.setColor(Color.pink);
            g.setColor(b);
            g.fillRect(xMin + n*7, yMin, n, n);

            //Row 7
            yMin = yMin + n;
            g.setColor(b);
            g.fillRect(xMin, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*2, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*3, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*4, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*5, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*6, yMin, n, n);
            // g.setColor(Color.BLUE);
            g.setColor(w);
            g.fillRect(xMin + n*7, yMin, n, n);

            //Row 8
            yMin = yMin + n;
            g.setColor(w);
            g.fillRect(xMin, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*2, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*3, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*4, yMin, n, n);
            g.setColor(b);
            g.fillRect(xMin + n*5, yMin, n, n);
            g.setColor(w);
            g.fillRect(xMin + n*6, yMin, n, n);
            // g.setColor(Color.GREEN);
            g.setColor(b);
            g.fillRect(xMin + n*7, yMin, n, n);
        }
    }

}
