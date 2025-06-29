package nn.gui;

import javax.swing.*;
import java.awt.*;

public class GraphicsCubeboid extends JFrame {

    public GraphicsCubeboid() {
        setTitle("Cubeboid");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        JPanel p = new DrawingPanel();
        JLabel jl = new JLabel();
        jl.setText("Hi");
        add(jl);
        
        add(p);
    }
    
    public static void main(String[] args) {
        new GraphicsCubeboid().setVisible(true);
    }

    public class DrawingPanel extends JPanel {

        protected void paintComponent(Graphics g)
        {
            int x = getWidth()/2;
            int y = getHeight()/2;

            int rectWidth = 300;
            int rectHeight = 150;

            int dist = 50;

            g.drawRect((x - rectWidth/2) - dist, (y - rectHeight/2) - dist, rectWidth, rectHeight);

            g.drawRect(x - rectWidth/2, y - rectHeight/2, rectWidth, rectHeight);

            int f1X = x - rectWidth/2;
            int f1Y = y - rectHeight/2;

            int b1X = (x - rectWidth/2) - dist;
            int b1Y = (y - rectHeight/2) - dist;

            int f2X = x - rectWidth/2;
            int f2Y = (y - rectHeight/2) + rectHeight;

            int b2X = (x - rectWidth/2) - dist;
            int b2Y = ((y - rectHeight/2) - dist) + rectHeight;

            int f3X = (x - rectWidth/2) + rectWidth;
            int f3Y = (y - rectHeight/2) + rectHeight;

            int b3X = ((x - rectWidth/2) - dist) + rectWidth;
            int b3Y = ((y - rectHeight/2) - dist) + rectHeight;

            int f4X = x - rectWidth/2 + rectWidth;
            int f4Y = y - rectHeight/2;

            int b4X = ((x - rectWidth/2) - dist) + rectWidth;
            int b4Y = (y - rectHeight/2) - dist;


            g.drawLine(f1X, f1Y, b1X, b1Y);
            g.drawLine(f2X, f2Y, b2X, b2Y);
            g.drawLine(f3X, f3Y, b3X, b3Y);
            g.drawLine(f4X, f4Y, b4X, b4Y);

            System.out.println("ScreenSize: " + getWidth() + " X " + getHeight());
            // System.out.println("f1b1");
        }
    }
}
