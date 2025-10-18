package nn.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AddRemoveItemJlist {

    
    public static void main(String[] args) 
    {
        JList<String> list = new JList<>();
        JTextField txtfld = new JTextField(25);
        JButton addBtn = new JButton("Add");
        JButton removeBtn = new JButton("Remove");
      
        list.setPrototypeCellValue("w".repeat(40));
        JScrollPane scpList = new JScrollPane(list);

        DefaultListModel<String> model = new DefaultListModel<>();
        list.setModel(model);

        // list.addListSelectionListener(new ListSelectionListener() {

        //             @Override
        //             public void valueChanged(ListSelectionEvent e) {
        //                 for(String s : list.getSelectedValuesList())
        //                     al.add(s);
        //             }
                    
        //         });

        JFrame jf = new JFrame();
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainP = new JPanel(new BorderLayout());
        JPanel showP = new JPanel();
        JPanel inputP = new JPanel();

        mainP.add(showP, BorderLayout.NORTH);
        mainP.add(inputP, BorderLayout.SOUTH);

        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtfld.getText().isBlank())
                {
                    JOptionPane.showMessageDialog(jf, "The Input is blank");
                }
                // else if () //duplicate entry
                else
                    model.addElement(txtfld.getText().trim());
                txtfld.setText(null);
            }
            
        });

        removeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ex) {
                for (int i : list.getSelectedIndices()) {
                    model.removeElementAt(i);
                }
            }
            
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if( e.getClickCount() == 2)
                    removeBtn.doClick();
            }
        });
        
        list.setPrototypeCellValue("w".repeat(40));
        showP.add(scpList);
        inputP.add(txtfld);
        inputP.add(addBtn);
        inputP.add(removeBtn);
        
        jf.getRootPane().setDefaultButton(addBtn);
        jf.add(mainP);
        jf.pack();
        jf.setVisible(true);
    }
}