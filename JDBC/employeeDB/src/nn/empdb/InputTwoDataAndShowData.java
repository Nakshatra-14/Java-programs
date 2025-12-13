package nn.empdb;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InputTwoDataAndShowData {

    public static void main(String[] args) {
        JFrame frm = new JFrame("Department Location");
        
        JTextArea projectNameTxt = new JTextArea(8, 30);
        JButton btn = new JButton("Submit");
                
        JPanel p = new JPanel(new BorderLayout(10, 10));

        btn.addActionListener(_ -> {
            
        });

        

        frm.add(p);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
