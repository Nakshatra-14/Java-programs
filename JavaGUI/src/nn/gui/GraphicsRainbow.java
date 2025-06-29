package nn.gui;

import javax.swing.*;
import java.awt.*;

class GraphicsRainbow extends JFrame{
    
    GraphicsRainbow()
    {
        setTitle("Rainbow Display");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawingPanel();
        add(p);
    }

    class DrawingPanel extends JPanel{
    
        protected void paintComponent(Graphics g)
        {
            int x = getWidth();
            int y = getHeight();

            x = x + 4;
            // y = y + 2;
            
            float n = x/7;

            Color colors[] = {
                new Color(148, 0, 211),
                new Color(75, 0, 130),
                Color.blue,
                Color.green,
                Color.yellow,
                Color.orange,
                Color.red
            };
            
            // //Voilet
            // g.setColor(new Color(148, 0, 211));
            // g.fillRect(0, 0, (int)n, y);
            
            // //Indigo
            // g.setColor(new Color(75, 0, 130));
            // g.fillRect((int) (n), 0, (int)n, y);
            
            // // Blue
            // g.setColor(new Color(0, 0, 255));
            // g.fillRect((int) (n * 2), 0, (int)n, y);
            
            // //Green
            // g.setColor(new Color(0, 255, 0));
            // g.fillRect((int) (n * 3), 0, (int)n, y);

            // //Yellow
            // g.setColor(new Color(255, 255, 0));
            // g.fillRect((int) (n * 4), 0, (int)n, y);

            // //Orange
            // g.setColor(new Color(255, 127, 0));   
            // g.fillRect((int) (n * 5), 0, (int)n, y);

            // //Red
            // g.setColor(new Color(255, 0, 0));   
            // g.fillRect((int) (n * 6), 0, (int)n, y);

            for(int i = 0 ; i < colors.length ; i++)
            {
                g.setColor(colors[i]);
                g.fillRect((int) (n * i), 0, (int)n, y);
            }

        }
    }

    public static void main(String[] args) {
        new GraphicsRainbow().setVisible(true);
    }
}
