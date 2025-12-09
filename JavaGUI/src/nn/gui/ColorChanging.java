package nn.gui ;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChanging extends JFrame{

    public ColorChanging() {
        JPanel p = new DrawingPanel();
        this.add(p);
        this.pack();
        // this
    }

    private class DrawingPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g)
        {
            g.fillRect(30, 30, 30, 30);
        }
    }

    public static void main(String[] args) {
        new ColorChanging().setVisible(true);
    }
    
}
