package nn.gui;

import javax.swing.*;
import java.awt.*;

class DrawingGraphics extends JFrame{
    
    public DrawingGraphics()
    {
        setTitle("Graphics Drawing");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawPanel();

        // JLabel jl = new JLabel();
        // jl.setText("Hello");
        // p.add(jl);

        add(p);


    }
        class DrawPanel extends JPanel{
            
            @Override
            protected void paintComponent(Graphics g)
            {

                g.setColor(Color.CYAN);
                g.drawString("Sampa", 100, 30);

                // g.drawLine(10, 8, 100, 90);
                // g.drawRect(8, 120, 150, 100);
                // g.drawOval(20, 240, 50, 50);
                
                g.drawRect(20, 20, 200, 200);
                g.drawOval(20, 20, 200, 200);

                g.setColor(Color.green);
                g.drawArc(20, 20, 200, 200, 0, 90);

                int x = getWidth()/2;
                int y = getHeight()/2;

                int dim = 20;
                int rad = dim/2;

                g.setColor(Color.red);
                // g.drawOval(x-rad, y-rad, dim, dim);
                g.fillOval(x-rad, y-rad, dim, dim);
            }
        }

        public static void main(String[] args) {
            new DrawingGraphics().setVisible(true);
        }
}
