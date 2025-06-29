package nn.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

class DrawingFrame extends JFrame{

    int n = 0;
    public DrawingFrame() {
        setTitle("Basic Drawing");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawingPanel();
        add(p);
    }

    public class DrawingPanel extends JPanel {
        
        // @Override                                ?????????
        protected void paintComponent(Graphics g)
        {
            System.out.println("Printed : " + ++n);
        }
    }
    
    public static void main(String[] args) {
       new DrawingFrame().setVisible(true); 
    }
}
