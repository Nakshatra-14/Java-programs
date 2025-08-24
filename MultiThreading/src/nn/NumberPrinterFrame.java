package nn;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

public class NumberPrinterFrame extends JFrame implements ActionListener {

    JLabel lbl8 = new JLabel("Eight");
    JLabel lbl10 = new JLabel("Ten");

    JButton btn8Start = new JButton("Eight Start");
    JButton btn8Stop = new JButton("Eight Stop");

    JButton btn10Start = new JButton("Ten Start");
    JButton btn10Stop = new JButton("Ten Stop");

    Thread th8, th10;

    public NumberPrinterFrame() {
        JPanel p = new JPanel();

        th8 = new Thread(new MyNumberPrinter(8, lbl8));
        th10 = new Thread(new MyNumberPrinter(10, lbl10));

        p.add(lbl8);
        p.add(btn8Start);
        p.add(btn8Stop);

        p.add(lbl10);
        p.add(btn10Start);
        p.add(btn10Stop);

        btn8Start.addActionListener(this);
        btn10Start.addActionListener(this);
        btn8Stop.addActionListener(this);
        btn10Stop.addActionListener(this);

        this.add(p);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new NumberPrinterFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object b = e.getSource();

        if (b == btn10Start)
            th10.start();
        else if (b == btn8Start)
            th8.start();
        else if (b == btn8Stop)
            th8.stop();
        else if (b == btn10Stop)
            th10.stop();
    }
}

class MyNumberPrinter implements Runnable {

    private int multipleOf;
    private JLabel lbl;

    public MyNumberPrinter(int multipleOf, JLabel lbl)
    {
        this.multipleOf = multipleOf;
        this.lbl = lbl;
    }

    @Override
    public void run() {
        for(int i = 0 ; i <= 1000 ; i++)
            if(i % multipleOf == 0)
                lbl.setText("Multiple of " + multipleOf + " " + i);
            try{
                Thread.currentThread().sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
    }
}
