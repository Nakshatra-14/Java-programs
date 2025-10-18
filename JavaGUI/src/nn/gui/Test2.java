package nn.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Test2 {
    public static void main(String[] args) {

        JCheckBox ckBox = new JCheckBox("Testing");
        
        JCheckBox jtxtBox[] = {

            new JCheckBox("One"),
            new JCheckBox("Two"),
            new JCheckBox("Three"),
            new JCheckBox("Four"),
            new JCheckBox("Five"),
            new JCheckBox("Six"),
            new JCheckBox("Seven"),
            new JCheckBox("Eight"),
        };

        // JList<JCheckBox> checkBoxList = new JList<>(jtxtBox);
        // JScrollPane scpCheckBox = new JScrollPane(checkBoxList);
        // checkBoxList.setVisibleRowCount(4);

        JFrame frm = new JFrame();
        JPanel p = new JPanel(new GridLayout(9, 0));
        // p.add(checkBoxList);
        p.add(ckBox);
        for (JCheckBox jCheckBox : jtxtBox) {
            p.add(jCheckBox);
        }
        frm.add(p);
        frm.pack();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
