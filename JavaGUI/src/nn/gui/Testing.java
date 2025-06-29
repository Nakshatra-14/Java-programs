package nn.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Testing extends JFrame{
    
    int n = 50;
    public Testing()
    {
        setTitle("Ball movement");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel p = new DrawPanel();
        
        add(p);

        
        
        
        
    }
    
    public class DrawPanel extends JPanel {
        
        @Override
        public void paintComponent(Graphics g)
        {
            
            g.setColor(Color.red);
            
            // g.fillOval(50, getHeight() / 2, 20, 20);
            // g.fillOval((getWidth() - 50 - 20) , getHeight() / 2, 20, 20);
            
            
            int dist = getWidth() - (50 + 50);
            while(true)
            {
                if(n == dist)
                    break;
            g.fillOval(n, getHeight() / 2, 20, 20);
                n++;
            }
        } 
    }

    public static void main(String[] args) {
         new Testing().setVisible(true);
    }
}
