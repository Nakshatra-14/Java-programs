package nn.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiniCalculator2 extends JFrame implements ActionListener {

    JTextField txtNum1, txtNum2, txtResult;

    private void addButton(JPanel p, String txt, String actioncmd, ActionListener lsn) {
            JButton btn = new JButton(txt);
            btn.setActionCommand(actioncmd);
            btn.addActionListener(lsn);
            p.add(btn);
    }

    public MiniCalculator2() {
        setTitle("Calculator");
        // setSize(315, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout()); // Main Container
        JPanel centerPanel = new JPanel(new GridLayout(3, 1)); // For inp and out
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));    //show btns
        
        
        JPanel inpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // show inp and out

        inpPanel.add(new JLabel("Enter Number 1: "));
        txtNum1 = new JTextField(9);
        inpPanel.add(txtNum1);

        centerPanel.add(inpPanel);
        
        inpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // show inp and out


        inpPanel.add(new JLabel("Enter Number 2: "));
        txtNum2 = new JTextField(9);
        inpPanel.add(txtNum2);

        centerPanel.add(inpPanel);

        inpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // show inp and out

        inpPanel.add(new JLabel("Result: "));
        txtResult = new JTextField(9);
        inpPanel.add(txtResult);

        centerPanel.add(inpPanel);
        inpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // show inp and out



        //r
        addButton(btnPanel, "add", "+", this);
        addButton(btnPanel, "subtract", "-", this);
        addButton(btnPanel, "multiply", "*", this);
        addButton(btnPanel, "divide", "/", this);


        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new MiniCalculator2().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        int a = 0, b = 0;
        try
        {
            a = Integer.parseInt(txtNum1.getText());
            b = Integer.parseInt(txtNum2.getText());
        }
        catch(NumberFormatException ex) { }

        int r = switch(btn.getActionCommand())
        {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };

        txtResult.setText(String.valueOf(r));

    }

}
