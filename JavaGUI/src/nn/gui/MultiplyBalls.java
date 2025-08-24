package nn.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class MultiplyBalls extends JFrame{

    // Ball ball = new Ball(20, 2, 30, 40, Color.red);
    Random rnd = new Random();
    // Ball balls[];
    int v = 0;
    ArrayList<Ball> b = new ArrayList<Ball>();

    
    public void createBall()
    {
        // balls = new Ball[n];
        // for(int i = 0 ; i < n ; i++)
        // {
            int dia = rnd.nextInt(60)+10;
            int inc = rnd.nextInt(2)+1;
            int xPos = rnd.nextInt(this.getWidth() / 2);
            int yPos = rnd.nextInt(this.getHeight() / 2);
            Color color = new Color(rnd.nextInt(255)+1, rnd.nextInt(255)+1, rnd.nextInt(255)+1);
            // balls[i] = new Ball(dia, inc, xPos, yPos, color);
            b.add(new Ball(dia, inc, xPos, yPos, color));
        // }
    }
    
    public MultiplyBalls()
    {
        setTitle("Simulator");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawPanel();

        p.setBackground(Color.black);
        add(p);

        createBall();

        new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < b.size() ; i++) {
                   b.get(i).move(p);
                }
                p.repaint();
            }
            
        }).start();

    }

    public static void main(String[] args) {
        new MultiplyBalls().setVisible(true);
    }

    public class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            for (int i = 0 ; i < b.size() ; i++) {
                b.get(i).draw(g);
            }
        }
        
    }

    class Ball
    {
        private int diameter, xPos, yPos, xInc, yInc;
        private final int INC;
        Color color;
        Random rnd = new Random();

        public Ball(int dia, int inc, int x, int y , Color color)
        {
            diameter = dia;
            xPos = x;
            yPos = y;
            INC = inc;
            // xInc = INC;
            // yInc = INC;
            if(rnd.nextBoolean())
                xInc = -INC;
            else
                xInc = INC;
            
            if(rnd.nextBoolean())
                yInc = -INC;
            else 
                yInc = INC;

            this.color = color;
        }

        public void draw(Graphics g)
        {
            g.setColor(color);
            g.fillOval(xPos, yPos, diameter, diameter);
        }

        public void move(JPanel p)
        {
            int w = p.getWidth();
            int h = p.getHeight();

            if(xPos + diameter >= w)
            {
                xInc = -INC;
                createBall();
            }
            else if(xPos <= 0)
            {
                xInc = INC;
                createBall();
            }
            
            if(yPos + diameter >= h)
            {
                yInc = -INC;
                createBall();
            }
            else if(yPos <= 0)
            {
                yInc = INC;
                createBall();
            }

            xPos += xInc;
            yPos += yInc;
        }

    }
}
