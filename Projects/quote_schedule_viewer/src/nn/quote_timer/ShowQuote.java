package nn.quote_timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ShowQuote extends JFrame {

    private ArrayList<String> al = new ArrayList<>();
    private String str = "Helloo";
    Font f = new Font("Times New Romans", Font.BOLD, 20);

    ShowQuote(String title) {
        setTitle(title);

        setSize(530, 200);

        Quote.getQuoteArraylist(al);

        JPanel p = new MyPanel();
        p.setBackground(Color.darkGray);

        new Timer(5000, _ -> {
            str = al.get(new Random().nextInt(30));
            p.repaint();
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
