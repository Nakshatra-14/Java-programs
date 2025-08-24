package nn.EmpMgt;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuBasedGUI extends JFrame{

    TextArea txtArea;
    JButton btnNew, btnOpen, btnSave, btnSaveAs, btnAdd, btnEdit, btnDelete, btnSearchById, btnDisplayLast, btnDiaplayAll;
    
    public void addNewData()
    {

    }

   MenuBasedGUI()
   {
    setTitle("Emp Mgt System");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel displayPanel = new JPanel();
    JPanel btnPanel = new JPanel(new GridLayout(2, 5, 10, 10));

    mainPanel.add(displayPanel, BorderLayout.NORTH);
    mainPanel.add(btnPanel, BorderLayout.CENTER);
    txtArea = new TextArea();
    displayPanel.add(txtArea);

    btnNew = new JButton("New");
    btnNew.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    btnPanel.add(btnNew);

    btnOpen = new JButton("Open");
    btnOpen.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    btnPanel.add(btnOpen);

    btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    btnPanel.add(btnSave);

    btnSaveAs = new JButton("Save as");
    btnSaveAs.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    btnPanel.add(btnSaveAs);

    btnAdd = new JButton("Add");
    btnAdd.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    btnPanel.add(btnAdd);

    btnEdit = new JButton("Edit");
    btnEdit.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    btnPanel.add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    btnPanel.add(btnDelete);

    btnSearchById = new JButton("Search By Id");
    btnSearchById.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    btnPanel.add(btnSearchById);

    add(mainPanel);
    // btnNew, btnOpen, btnSave, btnSaveAs, btnAdd, btnEdit, btnDelete, btnSearchById, btnDisplayLast, btnDiaplayAll;
   }

   public static void main(String[] args) {
    new MenuBasedGUI().setVisible(true);
   }
}
