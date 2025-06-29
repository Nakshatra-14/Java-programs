package nn.gui;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BgColorChanger2 {
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

        MyActionListner2 lsn = new MyActionListner2(jp);
        
        btnRed.addActionListener(lsn);
        btnGreen.addActionListener(lsn);
        btnBlue.addActionListener(lsn);

        jp.add(btnRed);
        jp.add(btnGreen);
        jp.add(btnBlue);

        

        frm.setVisible(true);    
    }
}

class MyActionListner2 implements ActionListener{

    private JPanel p;

    
    public MyActionListner2(JPanel p) {
        this.p = p;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       JButton btn = (JButton) e.getSource();
       String txt = btn.getText();
       Color c;
       if(txt.equalsIgnoreCase("red"))
        c = Color.RED;
       else if(txt.equalsIgnoreCase("Green"))
        c = Color.GREEN;
       else 
        c = Color.BLUE;
       p.setBackground(c);
    }
}
