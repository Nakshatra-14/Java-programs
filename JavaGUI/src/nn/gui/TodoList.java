package nn.gui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TodoList extends JFrame {

    public TodoList() {
        this.setTitle("Todo List");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel jlTitle = new JLabel("Todo List");
        JTextField jtxtTask = new JTextField(20);
        JButton btnSub = new JButton("Submit");
        this.getRootPane().setDefaultButton(btnSub);
        JButton btnDel = new JButton("Delete");
        JList<String> tskList = new JList<>();
        DefaultListModel<String> model = new DefaultListModel<>();
        tskList.setModel(model);
        tskList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scplst = new JScrollPane(tskList);
        tskList.setVisibleRowCount(20);
        tskList.setCellRenderer(new checkboxCellRenderer());

        btnSub.addActionListener(_ -> {
            String tsk = jtxtTask.getText();
            tsk = tsk.trim();
            if (!tsk.isEmpty()) {
                model.addElement(tsk);
                jtxtTask.setText("");
            } else
                JOptionPane.showMessageDialog(this, "Enter a task to add");
        });

        btnDel.addActionListener(_ -> {
            int arr[] = tskList.getSelectedIndices();
            if (arr.length != 0)
                for (int e : arr)
                    model.removeElementAt(e);
            else
                JOptionPane.showMessageDialog(this, "Select a task to delete");
        });

        JPanel p = new JPanel(new GridBagLayout());
        Insets inset = new Insets(5, 5, 5, 5);
        GridBagConstraints gbc;

        gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, inset, 0,
                0);
        p.add(jlTitle, gbc);

        gbc = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH, inset, 0,
                0);
        p.add(jtxtTask, gbc);

        gbc = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, inset, 0,
                0);
        p.add(btnSub, gbc);

        gbc = new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, inset, 0,
                0);
        p.add(scplst, gbc);

        gbc = new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, inset, 0,
                0);
        p.add(btnDel, gbc);

        // p.add(new JPanel().add(jlTitle), BorderLayout.NORTH);
        // JPanel inputPanel = new JPanel();
        // inputPanel.add(jtxtTask);
        // inputPanel.add(btnSub);
        // p.add(inputPanel, BorderLayout.CENTER);

        // JPanel outputpPanel= new JPanel();
        // outputpPanel.add(scplst);
        // outputpPanel.add(btnDel);
        // p.add(outputpPanel, BorderLayout.SOUTH);

        this.add(p);
        this.pack();
    }

    void main() {
        new TodoList().setVisible(true);
    }

}

class checkboxCellRenderer extends JCheckBox implements ListCellRenderer<String> {

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
            boolean isSelected, boolean cellHasFocus) {
                this.setText(value);
                this.setSelected(isSelected);
                return this;
    }

}
