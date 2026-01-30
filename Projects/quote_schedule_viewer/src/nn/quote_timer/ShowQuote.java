package nn.quote_timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ShowQuote extends JFrame {

    private ArrayList<String> al = new ArrayList<>();
    private String str = "Helloo";
    Font f = new Font("Times New Romans", Font.BOLD, 20);
    final Date time; 

    ShowQuote(String title) {
        setTitle(title);

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(gc.HOUR, 21);
        gc.set(gc.MINUTE, 4);
        time = gc.getTime(); 

        setSize(530, 200);

        Quote.getQuoteArraylist(al);

        JPanel p = new MyPanel();
        p.setBackground(Color.darkGray);

        new Timer(1000, _ -> {
            GregorianCalendar curr = new GregorianCalendar();
            Date currTime = curr.getTime();
            long fixedMillis = time.getTime();
            long currMillis = currTime.getTime();
            System.out.println("Fixed: " + fixedMillis + "\nCurrent: " + currMillis);
            if(fixedMillis >= currMillis)
            {
                str = al.get(new Random().nextInt(30));
                p.repaint();
            }
        }).start();
        add(p);
    }

    class MyPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int y = getHeight() / 2;
            int x = getWidth() / 2;
            g.setFont(f);
            g.setColor(Color.white);
            int l = (int) ((str.length() / 2) * 9.5);
            g.drawString(str, x - l, y);
        }
    }

    public static void main(String[] args) {
        ShowQuote sq = new ShowQuote("Show Quote");
        sq.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sq.setLocationRelativeTo(null);
        sq.setVisible(true);
    }

}
