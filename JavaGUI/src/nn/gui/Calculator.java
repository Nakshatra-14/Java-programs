package nn.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame implements ActionListener {

    JTextArea txtresult;
    

    String arr[] = { "AC", "(temp)", "%", "/", "7", "8", "9", "X", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".",
            "temp", "=" };

    private void addButton(JPanel p, Font fnt, String txt, String actioncmd, ActionListener lsn) {
        JButton btn = new JButton(txt);
        btn.setActionCommand(actioncmd);
        btn.addActionListener(lsn);
        p.add(btn);
        btn.setFont(fnt);
    }

    public Calculator() {
        setTitle("Calculator");
        // setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel(new BorderLayout());
        JPanel q = new JPanel(new BorderLayout()); // display
        JPanel r = new JPanel(new GridLayout(5, 4)); // btns

        txtresult = new JTextArea(2, 3);
        q.add(txtresult, BorderLayout.CENTER);
        Font font = p.getFont().deriveFont(36f);
        for (int i = 0; i < arr.length; i++)
            addButton(r, font, arr[i], arr[i], this);

        p.add(q, BorderLayout.NORTH);
        p.add(r, BorderLayout.CENTER);

        add(p);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton) e.getSource();

        float a = 0, b = 0;
        char op = ' ';

        txtresult.setText("");

        try
        {
            a = switch(btn.getActionCommand())
            {
                case "9" -> Float.parseFloat(btn.getActionCommand());
                case "8" -> Float.parseFloat(btn.getActionCommand());
                case "7" -> Float.parseFloat(btn.getActionCommand());
                case "6" -> Float.parseFloat(btn.getActionCommand());
                case "5" -> Float.parseFloat(btn.getActionCommand());
                case "4" -> Float.parseFloat(btn.getActionCommand());
                case "3" -> Float.parseFloat(btn.getActionCommand());
                case "2" -> Float.parseFloat(btn.getActionCommand());
                case "1" -> Float.parseFloat(btn.getActionCommand());
                default -> Float.parseFloat(btn.getActionCommand());    //0
            };
        }
        catch(NumberFormatException ex) {}

        txtresult.append(String.valueOf(a));

        try{
            op = switch(btn.getActionCommand().charAt(0))
            {
                case '+' -> (btn.getActionCommand()).charAt(0);
                case '-' -> (btn.getActionCommand()).charAt(0);
                case '*' -> (btn.getActionCommand()).charAt(0);
               
                default -> (btn.getActionCommand()).charAt(0);   //0
            };
        }
        catch(NumberFormatException ex) {}

        txtresult.append(String.valueOf(op));


        try{
            b = switch(btn.getActionCommand())
            {
                case "9" -> Float.parseFloat(btn.getActionCommand());
                case "8" -> Float.parseFloat(btn.getActionCommand());
                case "7" -> Float.parseFloat(btn.getActionCommand());
                case "6" -> Float.parseFloat(btn.getActionCommand());
                case "5" -> Float.parseFloat(btn.getActionCommand());
                case "4" -> Float.parseFloat(btn.getActionCommand());
                case "3" -> Float.parseFloat(btn.getActionCommand());
                case "2" -> Float.parseFloat(btn.getActionCommand());
                case "1" -> Float.parseFloat(btn.getActionCommand());
                default -> Float.parseFloat(btn.getActionCommand());    //0
            };
        }
        catch(NumberFormatException ex) {}

        txtresult.append(String.valueOf(b));

    }

}
