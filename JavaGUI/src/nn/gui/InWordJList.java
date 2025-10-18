package nn.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class InWordJList {
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
            StringBuilder sb = new StringBuilder();
            String hunds[] = {"crore ", "lakh ", "thousand ", "hundread ", ""};
            int i = 0;
            int h = 10000000; // 1 crore
            while(num != 0)
            {
                if(num >= h) 
                {
                    int m = num/h;
                    // word += oneTo99(m) + hunds[i];
                    sb.append(oneTo99(m)).append(hunds[i]);
                    num %= h;
                }
                i++;
                if(h == 1000)
                    h /= 10;
                else
                 h /=100;
            }
            word = sb.toString();
        }
        return word;
    }

    // public static void updateList(int lb, int ub, JList<String> lst)
    // {
    //     System.out.println("Updatelist");
    //     AbstractListModel<String> model = new AbstractListModel<String>() {

    //         @Override
    //         public int getSize() {
    //             return ub - lb + 1;
    //         }

    //         @Override
    //         public String getElementAt(int index) {
    //            return numberInWords(lb + index);
    //             // return String.valueOf(lb + index);
    //         }
    //     };
    //     lst.setModel(model);
    // }



    public static void main(String[] args) {
        // int ub, lb;
        JTextField ubTf, lbTf;
        JButton setBtn = new JButton("Set");
        JList<String> inWordList = new JList<>();
        JScrollPane scpInWord = new JScrollPane(inWordList);

        JFrame jf = new JFrame();
        jf.setTitle("In Words");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new BorderLayout(10, 10));
        JPanel pFlyt = new JPanel();
        jf.add(p);
        p.add(pFlyt, BorderLayout.NORTH);
        pFlyt.add(new JLabel("From: "), BorderLayout.NORTH);
        pFlyt.add(lbTf = new JTextField("", 20), BorderLayout.NORTH);
        pFlyt.add(new JLabel("To: "), BorderLayout.NORTH);
        pFlyt.add(ubTf = new JTextField("", 20), BorderLayout.NORTH);

        setBtn.addActionListener((ActionEvent e) -> {
            int ub = 0, lb = 0;
            try {
                lb = Integer.parseInt(lbTf.getText());
            } catch (NumberFormatException ex) { }
            try {
                ub = Integer.parseInt(ubTf.getText());
            } catch (NumberFormatException ex) { }
            System.out.println("lb: " + lb + " ub: " + ub);
            // System.out.println(al.toString());
            // updateList(lb, ub, inWordList);

            // inWordList.setModel(new NoInWordModel(lb, ub));
            var model = new NoInWordModel(lb, ub);
            inWordList.setModel(model);
            inWordList.setPrototypeCellValue(model.getSize() <= 1000 ? null : "w".repeat(20));
        });

        pFlyt.add(setBtn, BorderLayout.NORTH);
        p.add(scpInWord, BorderLayout.CENTER);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

}

    class NoInWordModel extends AbstractListModel<String>
    {
        private int lb;
        private int size;

        public NoInWordModel(int  lb, int ub)
        {
            this.lb = lb;
            this.size = ub - lb + 1;
        }

        @Override
            public int getSize() {
                return size;
            }

        @Override
        public String getElementAt(int index) {
            return InWordJList.numberInWords(lb + index);
            // return String.valueOf(lb + index);
        }
    }
