package nn.gui;

import java.util.function.Function;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;



class GraphPanel extends JPanel{

    private Function <Integer, Integer> func;

    public GraphPanel(Function <Integer, Integer> func) {
        this.func = func;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int w = getWidth() / 2 ;
        int h = getHeight() / 2;
        
        g.translate(w,  h); // Bring the origin at specify location
        
        g.setColor(Color.BLUE);
        g.drawLine(-w, 0, w , 0);   //X Axis
        g.setColor(Color.GREEN);
        g.drawLine(0, -h, 0, h);    //Y Axis


        g.setColor(Color.BLACK);
        // System.out.println("START");
        for(int x = -w ; x < w ; x++)
        {
            int y = - func.apply(x);
            // g.drawLine(x, y, x, y);
            g.fillRect(x, y, 5, 5);
        }
        // System.out.println("END");
    }
}

public class PlotGraph 
{
    
    public static void main(String[] args) {  
        JFrame fm = new JFrame();
        
        fm.setSize(500, 300);
        fm.setLocationRelativeTo(null);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fm.setLayout(new GridLayout(1, 2));

        // fm.add(new GraphPanel(x -> x));
        fm.add(new GraphPanel(x -> Math.abs(x) ));
        
        // fm.add(new GraphPanel(x -> (int) Math.exp(x)));
        fm.add(new GraphPanel(x -> {
            // System.out.println(x + ", " + Math.exp(x));
           return (int) Math.exp(x);
        }));

        fm.setVisible(true);
    }
}