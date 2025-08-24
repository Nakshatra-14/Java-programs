package nn.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnalogClock extends JFrame {

    // int sX, sY;
    public AnalogClock() {
        setTitle("Analog Clock");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new DrawPanel();

        // JLabel lbl = new JLabel(new Date().getHours() + " : " + new
        // Date().getMinutes() + " : " + new Date().getSeconds());
        // lbl.setLocation(getWidth() / 2, (int)(0.3 * getHeight()));
        // p.add(lbl);

        add(p);

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.repaint();
            }
        }).start();
    }

    public class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            GregorianCalendar time = new GregorianCalendar();

            int sec = time.get(Calendar.SECOND);
            int min = time.get(Calendar.MINUTE);
            int hr = time.get(Calendar.HOUR);
            min = 40;
            int w = getWidth();
            int h = getHeight();
            
            int side;
            if (w > h)
                side = h;
            else
                side = w;

            int rad = side / 2;
            int sideBy2 = rad;
            int left = (w - side) / 2;
            int top = (h - side) / 2;
            int centX = left + rad;
            int centY = top + rad;

            g.setColor(Color.black);
            g.fillRect(0, 0, w, h);
            // this.setBackground(Color.black);

            g.setColor(Color.lightGray);
            g.fillOval(left, top, side, side);

            int d = (int) (0.95 * side);
            int inc = (side - d) / 2;
            // g.setColor(Color.green);
            g.setColor(Color.darkGray);
            g.fillOval(left + inc, top + inc, d, d);

            g.setColor(Color.white);
            d = (int) (0.8 * side);
            inc = (side - d) / 2;
            g.fillOval(left + inc, top + inc, d, d);

            // System.out.println("Pborder: " + pBorder + ", " + "cborder: " + cBorder);
            // if(true)
            // return;
            int bDotDia = (int) (side * 0.05);
            int sDotDia = bDotDia / 2;
            int tDotDia = sDotDia / 2;

            int len = (int) (rad * 0.75);
            int bDotRad = bDotDia / 2;
            int sDotRad = sDotDia / 2;
            int tDotRad = tDotDia / 2;
            int x, y;
            g.setColor(Color.red);

            float angle = (float) Math.toRadians(0);
            float incAngle = (float) Math.toRadians(6);

            for (int i = 0; i < 60; i++) {
                if (i % 15 == 0)
                    rad = bDotRad;
                else if (i % 5 == 0)
                    rad = sDotRad;
                else
                    rad = tDotRad;

                x = (int) (centX + len * Math.sin(angle));
                y = (int) (centY - len * Math.cos(angle));
                g.fillOval(x - rad, y - rad, rad * 2, rad * 2);

                angle += incAngle;
            }

            // Seconds Hand
            g.setColor(Color.orange);
            angle = (float) Math.toRadians(sec * 6);
            len = (int) (sideBy2 * 0.8);
            x = (int) (centX + len * Math.sin(angle));
            y = (int) (centY - len * Math.cos(angle));
            g.drawLine(centX, centY, x, y);
            // System.out.println(sec);
            
            // Min Hand
            g.setColor(Color.blue);
            angle = (float) Math.toRadians(min * 6 + (sec * 0.1));
            len = (int) (sideBy2 * 0.7);
            x = (int) (centX + len * Math.sin(angle));
            y = (int) (centY - len * Math.cos(angle));
            g.drawLine(centX, centY, x, y);

            // Hr Hand
            g.setColor(Color.green);
            angle = (float) Math.toRadians(hr * 30 + (min * 0.5));
            len = (int) (sideBy2 * 0.5);
            x = (int) (centX + len * Math.sin(angle));
            y = (int) (centY - len * Math.cos(angle));
            g.drawLine(centX, centY, x, y);

           
            g.setColor(Color.blue);
            g.fillOval(centX - bDotRad, centY - bDotRad, bDotDia, bDotDia);

            // g.setColor(Color.black);
            g.setColor(Color.white);
            g.drawString(hr + " : " + min + " : " + sec, (getWidth() / 2) - 20, (int) (0.06 * getHeight()));
        }

        public void paintComponentOLD(Graphics g) {
            int w = getWidth();
            int h = getHeight();
            int pBorder, oBorder;

            g.setColor(Color.black);
            g.fillRect(0, 0, w, h);

            if (w > h)
                oBorder = h;
            else
                oBorder = w;

            g.setColor(Color.lightGray);
            g.fillOval((w - oBorder) / 2, (h - oBorder) / 2, oBorder, oBorder);

            pBorder = (int) (0.95 * oBorder);
            // g.setColor(Color.green);
            g.setColor(Color.darkGray);
            g.fillOval((w - pBorder) / 2, (h - pBorder) / 2, pBorder, pBorder);

            g.setColor(Color.white);
            // int cBorder = pBorder - 30;
            int cBorder = (int) (0.9 * pBorder);
            g.fillOval((w - cBorder) / 2, (h - cBorder) / 2, cBorder, cBorder);

            // System.out.println("Pborder: " + pBorder + ", " + "cborder: " + cBorder);

            g.setColor(Color.red);
            int iBorder = (int) (0.98 * cBorder);
            // g.fillOval((w - iBorder)/2, (h - iBorder)/2, iBorder, iBorder);

            float r = (iBorder / 2) - 10;
            float sCenterX = getWidth() / 2;
            float sCenterY = getHeight() / 2;
            int numSize = (int) (0.05 * iBorder);
            int numRad = numSize / 2;
            // sCenterX -= 5;
            // sCenterY -= 5;
            r += 5;

            for (int i = 0; i < 360; i += 90) {
                float angle = (float) (i * (Math.PI / 180));
                float numX = (float) (sCenterX + r * Math.sin(angle));
                float numY = (float) (sCenterY - r * Math.cos(angle));
                g.fillOval((int) numX - numRad, (int) numY - numRad, numSize, numSize);
            }

            int smallNumSize = (int) (0.7 * numSize);
            int smallNumRad = smallNumSize / 2;
            for (int i = 0; i < 360; i += 30) {
                float angle = (float) (i * (Math.PI / 180));
                float numX = (float) (sCenterX + r * Math.sin(angle));
                float numY = (float) (sCenterY - r * Math.cos(angle));
                g.fillOval((int) (numX - smallNumRad), (int) (numY - smallNumRad), smallNumSize, smallNumSize);
            }

            // for(int i = 0 ; i < 360 ; i += 30)
            // {
            // float angle = (float) (i * (Math.PI / 180));
            // float numX = (float) (sCenterX + r * Math.sin(angle));
            // float numY = (float) (sCenterY - r * Math.cos(angle));
            // g.fillOval((int) numX - numRad, (int) numY - numRad, numSize, numSize);
            // }

            int innerNumSize = (int) (0.4 * numSize);
            int innerNumRad = (innerNumSize / 2) + 2;
            g.setColor(Color.red);
            for (float i = 0; i < 360; i += 5) {
                float angle = (float) (i * (Math.PI / 180));
                float innerX = (float) (sCenterX + r * Math.sin(angle));
                float innerY = (float) (sCenterY - r * Math.cos(angle));
                g.fillOval((int) innerX - innerNumRad, (int) innerY - innerNumRad, innerNumSize, innerNumSize);
            }

            // for(float i = 0 ; i < 360 ; i += 6)
            // {
            // float angle = 6;
            g.setColor(Color.black);
            int sec = new Date().getSeconds();
            float angle = (float) (((sec * 6)) * (Math.PI / 180));
            float sX = (float) (sCenterX + r * Math.sin(angle));
            float sY = (float) (sCenterY - r * Math.cos(angle));
            g.drawLine((int) sCenterX, (int) sCenterY, (int) sX, (int) sY);
            // g.fillRect((int) sX, (int) sY, (int) r, 20);
            // }

            g.setColor(Color.darkGray);
            r = (float) (0.9 * r);
            int min = new Date().getMinutes();
            angle = (float) (min * 6 * (Math.PI / 180));
            float mX = (float) (sCenterX + r * Math.sin(angle));
            float mY = (float) (sCenterY - r * Math.cos(angle));
            g.drawLine((int) sCenterX, (int) sCenterY, (int) mX, (int) mY);

            g.setColor(Color.orange);
            r = (float) (0.8 * r);
            int hour = new Date().getHours();
            angle = (float) (hour * 30 * (Math.PI / 180));
            float hX = (float) (sCenterX + r * Math.sin(angle));
            float hY = (float) (sCenterY - r * Math.cos(angle));
            g.drawLine((int) sCenterX, (int) sCenterY, (int) hX, (int) hY);

            g.setColor(Color.blue);
            int center = (int) (0.06 * cBorder);
            g.fillOval((w - center) / 2, (h - center) / 2, center, center);

            // g.setColor(Color.black);
            g.setColor(Color.white);
            g.drawString(hour + " : " + min + " : " + sec, (getWidth() / 2) - 20, (int) (0.06 * getHeight()));
        }
    }

    public static void main(String[] args) {
        new AnalogClock().setVisible(true);
    }
}
