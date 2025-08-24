package nn.gui;

import javax.swing.*;
import java.awt.*;

class GraphicsCubeboid extends JFrame {

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
            int w = getWidth()/2;
            int h = getHeight()/2;
            
            // int rectWidth = (int) 0.4 * getWidth();
            // int rectHeight = (int) 0.4 * getHeight();

            int rectWidth = 300;
            int rectHeight = 100;

            // if(w < h){
            //     rectWidth = (int) 0.5 * getWidth();
            //     rectHeight = (int) 0.5 * getHeight();
            // }

            // int dist = 50;
            int dist = (int) 0.2 * getWidth();

            g.drawRect((w - rectWidth/2) - dist, (h - rectHeight/2) - dist, rectWidth, rectHeight);

            g.drawRect(w - rectWidth/2, h - rectHeight/2, rectWidth, rectHeight);

            int f1X = w - rectWidth/2;
            int f1Y = h - rectHeight/2;

            int b1X = (w - rectWidth/2) - dist;
            int b1Y = (h - rectHeight/2) - dist;

            int f2X = w - rectWidth/2;
            int f2Y = (h - rectHeight/2) + rectHeight;

            int b2X = (w - rectWidth/2) - dist;
            int b2Y = ((h - rectHeight/2) - dist) + rectHeight;

            int f3X = (w - rectWidth/2) + rectWidth;
            int f3Y = (h - rectHeight/2) + rectHeight;

            int b3X = ((w - rectWidth/2) - dist) + rectWidth;
            int b3Y = ((h - rectHeight/2) - dist) + rectHeight;

            int f4X = w - rectWidth/2 + rectWidth;
            int f4Y = h - rectHeight/2;

            int b4X = ((w - rectWidth/2) - dist) + rectWidth;
            int b4Y = (h - rectHeight/2) - dist;


            g.drawLine(f1X, f1Y, b1X, b1Y);
            g.drawLine(f2X, f2Y, b2X, b2Y);
            g.drawLine(f3X, f3Y, b3X, b3Y);
            g.drawLine(f4X, f4Y, b4X, b4Y);

            System.out.println("ScreenSize: " + getWidth() + " X " + getHeight());
            // System.out.println("f1b1");
        }
    }
}
