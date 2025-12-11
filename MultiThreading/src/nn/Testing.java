package nn;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Testing {

    private static int waitRed = 60000;
    private static int waitYellow = 5000;
    private static int waitGreen = 80000;
    private static int colorIndex = 0;
    // private static JLabel txtLabel = new JLabel("Helllooo");
    static String str = "";
    static int countDownStr = 0;
    static Font font = new Font("Roboto", Font.BOLD, 60);

    public static int getWaitGreen() {
        return waitGreen;
    }

    public static int getWaitYellow() {
        return waitYellow;
    }

    public static int getWaitRed() {
        return waitRed;
    }

    public static void setColorIndex(int colorIndex) {
        Testing.colorIndex = colorIndex;
    }

    public static void setCountDownStr(int countDownStr) {
        Testing.countDownStr = countDownStr;
    }

    public static int getCountDownStr() {
        return countDownStr;
    }

    public static void running() throws InterruptedException {

        while (true) {

            Task t1 = new Task("Task 1");
            Task t2 = new Task("Task 2");
            Task t3 = new Task("Task 3");

            t1.start();
            t1.join(waitRed);
            t2.start();
            t2.join(waitGreen);
            t3.start();
            t3.join(waitYellow);
        }

    }

    static JFrame frm = new JFrame("Traffic Light");

    public static void main(String[] args) throws InterruptedException {

        JPanel p = new MyPanel();

        new Timer(1000, _ -> {
            int temp = Testing.getCountDownStr();
            Testing.setCountDownStr(--temp);
            p.repaint();
        }).start();

        // p.add(txtLabel);

        frm.add(p);
        frm.setSize(500, 500);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        running();

    }

    static class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = frm.getWidth();
            int y = frm.getHeight();
            int n = 40;

            g.setColor(Color.BLACK);
            g.fillRect(x / 2 - 60 / 2, y / 2 - 180 / 2, 60, 180);
            g.setColor((colorIndex == 1) ? Color.red : Color.gray);
            // g.fillRect(x/2 - 40/2, (y/2 - 40/2) - 50, n, n);
            g.fillArc(x / 2 - 40 / 2, (y / 2 - 40 / 2) - 50, 40, 40, 0, 360);
            // g.fillRect(x/2 - 40/2, y/2 - 40/2, n, n);
            g.setColor((colorIndex == 2) ? Color.yellow : Color.gray);
            g.fillArc(x / 2 - 40 / 2, y / 2 - 40 / 2, 40, 40, 0, 360);
            // g.fillRect(x/2 - 40/2, (y/2 - 40/2) + 50, n, n);
            g.setColor((colorIndex == 3) ? Color.green : Color.gray);
            g.fillArc(x / 2 - 40 / 2, (y / 2 - 40 / 2) + 50, 40, 40, 0, 360);

            g.setColor(Color.black);
            g.fillRect((x / 2 - 40 / 2) + 60, (y / 2 - 40 / 2) + 50, 80, 60);
            g.setColor(Color.darkGray);
            g.fillRect((x / 2 - 40 / 2) + 65, (y / 2 - 40 / 2) + 55, 70, 50);

            g.drawString(str, x / 2 - 5, y / 2 + 150);
            // FontMetrics fm = this.getFontMetrics(font);

            Color c;
            g.setFont(font);
            switch (colorIndex) {
                case 1 -> {
                    c = Color.red;
                    g.setColor(c);
                    g.drawString(String.valueOf(countDownStr), (x / 2 - 40 / 2) + 65, (y / 2 - 40 / 2) + 100);
                }
                case 2 -> {
                    
                }
                case 3 -> {
                    c = Color.green;
                    g.setColor(c);
                    g.drawString(String.valueOf(countDownStr), (x / 2 - 40 / 2) + 65, (y / 2 - 40 / 2) + 100);
                }
            }

        }
    }

}

class Task extends Thread {

    private String task;

    public Task(String task) {
        this.task = task;
    }

    public void run() {

        String t = Thread.currentThread().getName();
        int sleepTime = 0;
        // System.out.println(task + " is running on " + t);
        if (task.equals("Task 1")) {
            System.out.println("Red on " + t);
            sleepTime = Testing.getWaitRed();
            Testing.setColorIndex(1);
            Testing.setCountDownStr(Testing.getWaitRed() / 1000);
            Testing.str = "Stop";
        } else if (task.equals("Task 2")) {
            System.out.println("Green on " + t);
            sleepTime = Testing.getWaitGreen();
            Testing.setColorIndex(3);
            Testing.setCountDownStr(Testing.getWaitGreen() / 1000);
            Testing.str = "Go";
        } else {
            System.out.println("Yellow on " + t);
            sleepTime = Testing.getWaitYellow();
            Testing.setColorIndex(2);
            Testing.setCountDownStr(Testing.getWaitYellow() / 1000);
            Testing.str = "Wait";
        }

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {

        }
    }
}