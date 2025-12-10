package nn.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimpleBallFrame extends JFrame {

    Ball balls[];
    Random rnd = new Random();
    int fps = 0, frame = 0;
    Font font = new Font("Times New Roman", Font.PLAIN, 42);
    
    public void createBall(int n) {
        balls = new Ball[n];
        for (int i = 0; i < n; i++) {
            Color c = new Color(rnd.nextInt(255)+1, rnd.nextInt(255)+1, rnd.nextInt(255)+1);
            int inc = rnd.nextInt(3)+1;
            int dia = rnd.nextInt(25)+10;
            int x = rnd.nextInt(this.getWidth());
            int y = rnd.nextInt(this.getHeight());
            balls[i] = new Ball(dia, inc, x, y, c);
        }
    }

    public SimpleBallFrame() {
        setTitle("Ball Simulation");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new BallPanel();

        createBall(100);
        
        add(p);
        


        new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // ball.moveBall(p);
                for (Ball ball : balls) {
                    ball.moveBall(p);
                }
                p.repaint();
            }

        }).start();

        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fps = frame;
                frame = 0;
            }
            
        }).start();
    }

    public class BallPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.black);
            for (Ball b : balls) {
                b.draw(g);
            }
            g.setColor(Color.gray);
            int h = (int)(getWidth() * 0.05), v = (int)(getHeight() * 0.1);
            g.fillRect(0, 0, h, v);
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString(String.valueOf(fps), (int)(h * 0.05), (int)(v * 0.05 + 30));
            frame++;
        }
    }

    public static void main(String[] args) {
        new SimpleBallFrame().setVisible(true);
    }

}

class Ball {

    private int diameter;
    private final int INC;
    private int xPos;
    private int yPos;
    private int xInc;
    private int yInc;
    private Color color;
    private Random rnd = new Random();

    public Ball(int dia, int increment, int x, int y, Color color) {
        diameter = dia;
        INC = increment;
        xPos = x;
        yPos = y;
        // xInc = INC;
        // yInc = INC;
        this.color = color;
        if(rnd.nextBoolean())
            xInc = INC;
        else
            xInc = -INC;
        
        if(rnd.nextBoolean())
            yInc = INC;
        else 
            yInc = -INC;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(xPos, yPos, diameter, diameter);
        g.setColor(color);
        g.fillOval(xPos, yPos, diameter, diameter);
    }

    public void moveBall(JPanel p) {
        int w = p.getWidth();
        int h = p.getHeight();

        // System.out.println("W: " + w + ", " + "H: " + h);
        if (xPos + diameter >= w) {
            xInc = -INC;
        } else if (xPos <= 0)
            xInc = INC;

        if (yPos + diameter >= h) {
            yInc = -INC;
        } else if (yPos <= 0)
            yInc = INC;

        xPos += xInc;
        yPos += yInc;

        // System.out.println("xPos: " + xPos + ", " + "yPos: " + yPos);
    }

}