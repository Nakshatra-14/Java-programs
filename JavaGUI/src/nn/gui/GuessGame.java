package nn.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GuessGame extends JFrame implements ActionListener {

    JTextField txtnum;
    JLabel txtShow;

    public GuessGame() {
        setTitle("Box");
        setLocationRelativeTo(null);
        setSize(170, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        p.add(new JLabel("Enter number: "));
        txtnum = new JTextField(9);
        p.add(txtnum);

        JButton btn = new JButton("Submit");
        btn.setActionCommand("Submit");
        btn.addActionListener(this);
        p.add(btn);

        JButton rtbtn = new JButton("Restart");
        rtbtn.setActionCommand("Restart");
        rtbtn.addActionListener(this);
        p.add(rtbtn);

        txtShow = new JLabel();
        p.add(txtShow);

        add(p);
    }

    public int randInt(int lb, int ub) {
        return lb + (int) ((ub - lb + 1) * Math.random());
    }

    int n = randInt(0, 100);
    int c = 0;

    public static void main(String[] args) {
        new GuessGame().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        int num = 0;

        try {
            num = Integer.parseInt(txtnum.getText());
        } catch (NumberFormatException ex) {}

        if (btn.getActionCommand() == "Submit") {

            if (num < n) {
                c++;
                txtShow.setText("Number is bigger than " + num);
            } else if (num > n) {
                c++;
                txtShow.setText("Number is smaller than " + num);
            } else if (num == n) 
                txtShow.setText("Found at " + c + " trys");
            else
                txtShow.setText("Invalid input");
        }

        else if (btn.getActionCommand() == "Restart") {
            txtShow.setText("");
            c = 0;
            n = randInt(1, 100);
        }


    }

}
