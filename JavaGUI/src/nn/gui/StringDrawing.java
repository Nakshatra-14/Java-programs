package nn.gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

class StringDrawing extends JFrame {
    
    public StringDrawing()
    {
        setTitle("Font");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawPanel();

        add(p);
    }

    public static void main(String[] args) {
        new StringDrawing().setVisible(true);
    }

    public class DrawPanel extends JPanel {
    
            protected void paintComponent(Graphics g)
            {
                String s1 = "India";
                String s2 = " is ";
                String s3 = "Great";
                Font font1 = new Font("Times New Roman", Font.PLAIN, 72);
                Font font2 = new Font("Verdane", Font.ITALIC, 14);
                Font font3 = new Font("Garamond", Font.BOLD, 36);
                FontMetrics fm1 = this.getFontMetrics(font1);
                FontMetrics fm2 = this.getFontMetrics(font2);
                FontMetrics fm3 = this.getFontMetrics(font3);
                int w1 = fm1.stringWidth(s1);
                int w2 = fm2.stringWidth(s2);
                int w3 = fm3.stringWidth(s3);
                int totWid = w1 + w2 + w3;
                int totHi = Math.max(fm1.getHeight(), Math.max(fm2.getHeight(), fm3.getHeight()));
                int x = (getWidth() - totWid) / 2;
                int y = (getHeight() - totHi) / 2 + (fm1.getAscent() / 2);
                // OR
                // FontMetrics fm = g.getFontMetrics();

                g.setFont(font1);
                g.setColor(Color.orange);
                g.drawString(s1, x, y );
                // x += fm.stringWidth(s1);
                // x += 12;
                
                g.setFont(font2);
                g.setColor(Color.blue);
                g.drawString(s2, x + w1, y );
                // x += fm.stringWidth(s2);
                // x += 12;

                g.setFont(font3);
                g.setColor(Color.green);
                g.drawString(s3, x + w1 + w2, y );
            }
    }
}
