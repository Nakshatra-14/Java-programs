package nn.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class InWords extends JFrame implements ActionListener{

    JTextField inp, out;

    public static String oneTo99(int n)
    {
        String teens[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirtheen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String ties[] = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String w = "";  
        
        if(n > 19)
        {
            w += ties[n/10 - 2] + " ";
            n %= 10;
        }

        if(n != 0)
            w += teens[n - 1] + " ";

        return w;  
    }

    public static String numberInWords(int num)
    {
        String word = "";

        if(num >= 1000000000) //100 crore
            word = "too large number";
        else if(num == 0)
            word = "zero";
        else
        {
            String hunds[] = {"crore ", "lakh ", "thousand ", "hundread ", ""};
            int i = 0;
            int h = 10000000; // 1 crore
            while(num != 0)
            {
                if(num >= h) 
                {
                    int m = num/h;
                    word += oneTo99(m) + hunds[i];
                    num %= h;
                }
                i++;
                if(h == 1000)
                    h /= 10;
                else
                 h /=100;
            }
        } 
        
        return word;
    }

    public InWords()
    {
        setTitle("Number In Words");
        setSize(700, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        p.add(new JLabel("Enter num: "));
        inp = new JTextField(10);
        p.add(inp);

        JButton btn = new JButton("Submit");
        btn.setActionCommand("Submit");
        btn.addActionListener(this);
        p.add(btn);

        out = new JTextField(66);
        p.add(out);

        add(p);
    }

    public static void main(String[] args) {
        new InWords().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        int num = 0;

        try
        {
            num = Integer.parseInt(inp.getText());
        }
        catch(NumberFormatException ex) {
            out.setText("Invalid Number");
        }

        if(num >= 1000000000) //100 crore
            out.setText("less than 100 crore");
        else
        out.setText(numberInWords(num));
    }
}