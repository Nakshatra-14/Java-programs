package nn.gui;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BgColorChanger1 {
    public static void main(String[] args) {
        JFrame frm = new JFrame();

        frm.setTitle("Background Colour Changer");

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();

        frm.setSize(d.width/3, d.height/2);
        frm.setLocation((d.width - frm.getWidth()) / 2, (d.height - frm.getHeight()) / 2);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();
        frm.add(jp);

        JButton btnRed = new JButton("Red");
        JButton btnGreen = new JButton("Green");
        JButton btnBlue = new JButton("Blue");
        
        btnRed.addActionListener(new MyActionListner(jp, Color.RED));
        btnGreen.addActionListener(new MyActionListner(jp, Color.GREEN));
        btnBlue.addActionListener(new MyActionListner(jp, Color.BLUE));

        jp.add(btnRed);
        jp.add(btnGreen);
        jp.add(btnBlue);

        

        frm.setVisible(true);    
    }
}

class MyActionListner implements ActionListener{

    JPanel p;
    Color c;

    
    public MyActionListner(JPanel p, Color c) {
        this.p = p;
        this.c = c;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        p.setBackground(c);
    }

}
