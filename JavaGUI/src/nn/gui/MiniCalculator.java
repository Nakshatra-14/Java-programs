package nn.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MiniCalculator extends JFrame implements ActionListener {

    private JTextField txtNum1, txtNum2, txtresult;

    private void addButton(JPanel p, String txt, ActionListener lsn) {
        JButton btn = new JButton(txt);
        btn.setActionCommand(txt);
        btn.addActionListener(lsn);
        p.add(btn);
    }

    public MiniCalculator() {
        setTitle("Mini Calculator");
        setLocationRelativeTo(null);
        setSize(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        p.add(new JLabel("Number1:"));
        txtNum1 = new JTextField(9);
        p.add(txtNum1);

        p.add(new JLabel("Number2:"));
        txtNum2 = new JTextField(9);
        p.add(txtNum2);

        p.add(new JLabel("Result:"));
        txtresult = new JTextField(9);
        p.add(txtresult);

        addButton(p, "Add", this);
        addButton(p, "Subtract", this);
        addButton(p, "Multiply", this);
        addButton(p, "Divide", this);

        this.add(p);
    }

    public static void main(String[] args) {
        new MiniCalculator().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        int num1 = 0;
        int num2 = 0;

        try
        {
            num1 = Integer.parseInt(txtNum1.getText());
        }
        catch(NumberFormatException ex)
        {
            txtresult.setText("Invalid");
            return;
        }

        try{
            num2 = Integer.parseInt(txtNum2.getText());
        }
        catch(NumberFormatException ex){}

        int r = switch (btn.getActionCommand()){
            case "Add" -> num1 + num2;
            case "Subtract" -> num1 - num2;
            case "Multiply" -> num1 * num2;
            default -> num1 / num2;
        };

        txtresult.setText(String.valueOf(r));
    }
    
}
