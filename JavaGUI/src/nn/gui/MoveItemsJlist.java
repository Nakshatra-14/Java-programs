package nn.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MoveItemsJlist {

    
    public static void main(String[] args) 
    {
        ArrayList<String> al = new ArrayList<>();
        String[] fruits = {
            "Apple", "Banana", "Cherry", "Date", "Elderberry",
            "Fig", "Grape", "Honeydew", "Indian Fig", "Jackfruit",
            "Kiwi", "Lemon", "Mango", "Nectarine", "Orange",
            "Papaya", "Quince", "Raspberry", "Strawberry", "Tangerine",
            "Ugli Fruit", "Vanilla Bean", "Watermelon", "Xigua", "Yellow Passion Fruit"
        };
        JButton moveBtn = new JButton("Move >"), moveAllBtn = new JButton("Move All"), removeBtn = new JButton("< Remove"), removeAllBtn = new JButton("Remove All"), moveUpBtn = new JButton("Move Up"), moveDownBtn = new JButton("Move Down");
        JList<String> list1 = new JList<>();
        JList<String> list2 = new JList<>();
        list1.setPrototypeCellValue("w".repeat(20));
        list2.setPrototypeCellValue("w".repeat(20));
        JScrollPane scpList1 = new JScrollPane(list1);
        JScrollPane scpList2 = new JScrollPane(list2);

        // list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list1.setVisibleRowCount(20);
        DefaultListModel<String> model1 = new DefaultListModel<>();
        list1.setModel(model1);
        
        // list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setVisibleRowCount(20);
        DefaultListModel<String> model2 = new DefaultListModel<>();
        list2.setModel(model2);

        for(String e : fruits)
            model1.addElement(e);

        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // list1.addListSelectionListener(new ListSelectionListener() {

        //     @Override
        //     public void valueChanged(ListSelectionEvent e) {
        //         if(!list1.getValueIsAdjusting()){
        //             // for(String s : list1.getSelectedValuesList())
        //                 // al.add(s);
        //             selection = list1.getSelectedValue();
        //         }
        //     }
            
        // });

        // list2.addListSelectionListener(new ListSelectionListener() {

        //     @Override
        //     public void valueChanged(ListSelectionEvent e) {
        //         if(!list2.getValueIsAdjusting()){
        //             // for(String s : list1.getSelectedValuesList())
        //                 // al.add(s);
        //             moveSelectionIndex = list2.getSelectedIndex();
        //         }
        //     }
            
        // });

        moveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int c = 0;
                for (int i : list1.getSelectedIndices())
                {
                    String s = model1.getElementAt(i+c);
                    model1.removeElementAt(i+c);
                    model2.addElement(s);
                    c--;
                }

                // for (String s : list1.getSelectedValuesList())
                // {
                //     model1.removeElement(s);
                //     model2.addElement(s);
                // }

                // for (int i : list1.getSelectedIndices())
                // {
                //     String s = model1.getElementAt(i);
                //     model2.addElement(s);
                // }
                // for (int i : list1.getSelectedIndices())
                // {  
                //     model1.removeElementAt(i);
                // }
            }
            
        });

        moveAllBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0 ; i < model1.size() ; i++)
                {
                    model2.addElement(model1.getElementAt(i));
                }
                model1.clear();
            }
            
        });

        removeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i : list1.getSelectedIndices())
                {
                    String s = model1.getElementAt(i);
                    model1.removeElementAt(i);
                }
            }
            
        });

        removeAllBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model1.removeAllElements();
            }
            
        });

        moveUpBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i : list2.getSelectedIndices())
                    {
                        String a = model2.getElementAt(i);
                        String b = model2.elementAt(i - 1);
                        // model2.removeElementAt(i);
                        // model2.add(i, b);
                        // model2.removeElementAt(i - 1);
                        // model2.add(i - 1, a);
                        String temp = b;
                        b = a;
                        a = temp;
                        model2.setElementAt(a, i);
                        model2.setElementAt(b, i-1);
                        list2.setSelectedIndex(i-1);
                    }
                } catch (Exception ex) {
                    // JOptionPane.showMessageDialog(jf, "No item on top of the object");
                }
            }
            
        });

        moveDownBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i : list2.getSelectedIndices())
                    {
                        String a = model2.getElementAt(i);
                        String b = model2.elementAt(i + 1);
                        model2.removeElementAt(i);
                        model2.add(i, b);
                        model2.removeElementAt(i + 1);
                        model2.add(i + 1, a);
                    }   
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(jf, "No item bellow the object");
                }
            }
        });

        JPanel list1Panel = new JPanel();
            list1Panel.add(scpList1);
        JPanel btnPanel1 = new JPanel();
        btnPanel1.setLayout(new GridLayout(4, 1, 0, 20));
            btnPanel1.add(moveBtn);
            btnPanel1.add(moveAllBtn);
            btnPanel1.add(removeBtn);
            btnPanel1.add(removeAllBtn);
        // JPanel sec1Panel = new JPanel(new BorderLayout())
        JPanel list2Panel = new JPanel();
            list2Panel.add(scpList2);
        JPanel btnPanel2 = new JPanel(new GridLayout(2, 1, 0, 20));
            btnPanel2.add(moveUpBtn);
            btnPanel2.add(moveDownBtn);

        JPanel mainPanel = new JPanel();
        mainPanel.add(list1Panel);
        mainPanel.add(btnPanel1);
        mainPanel.add(list2Panel);
        mainPanel.add(btnPanel2);

        jf.add(mainPanel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
