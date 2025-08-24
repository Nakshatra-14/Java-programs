package nn.gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Box extends JFrame{

    int x,y;
    
    public Box()
    {
        setTitle("Mouse tracker");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawPanel();

        add(p);

        // MouseListener ml = new MouseListener() {

        //     @Override
        //     public void mousePressed(MouseEvent e) {
        //         // x = e.getX();
        //         // y = e.getY();
        //         // repaint();
        //     }

        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         // x = e.getX();
        //         // y = e.getY();
        //         // repaint();
        //     }

        //     @Override
        //     public void mouseReleased(MouseEvent e) {
        //     }

        //     @Override
        //     public void mouseEntered(MouseEvent e) {
        //         // x = e.getX();
        //         // y = e.getY();
        //         // repaint();
        //     }

        //     @Override
        //     public void mouseExited(MouseEvent e) {
        //     }  
        // };

        MouseMotionListener mml = new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
            
        };

        p.addMouseMotionListener(mml);
    }

    public static void main(String[] args) {
        new Box().setVisible(true);
    }

    public class DrawPanel extends JPanel{
    
        @Override
        public void paintComponent(Graphics g)
        {
            int n = 40;
            g.drawOval(x - (n / 2), y - (n / 2), n, n);
            // g.drawOval(x - (n / 2), y - (n / 2), n, n);
            // g.drawOval(x - (n / 2), y - (n / 2), n, n);
            // g.drawOval(x - (n / 2), y - (n / 2), n, n);
            // g.drawOval(x - (n / 2), y - (n / 2), n, n);
            // g.drawOval(x - (n / 2), y - (n / 2), n, n);

        }
    }
}
