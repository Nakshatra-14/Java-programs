package nn.gui;

import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TableTester {
    public static void main(String[] args) {
        JFrame frm = new JFrame("Table Tester");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object mat[][] = {
                // Name, Age, isFemale
                // String, Integer, Boolean
                { "Tushar", 23, false },
                { "Sushmita", 35, true },
                { "Ronit", 27, false },
                { "Kakoli", 25, true },
        };

        String colNames[] = { "Name", "Age", "Gender" };

        JTable tabDefault = new JTable(mat, colNames);
        tabDefault.setFillsViewportHeight(true);
        tabDefault.setAutoCreateRowSorter(true);

        frm.setLayout(new FlowLayout());

        JScrollPane scp = new JScrollPane(tabDefault);
        frm.add(scp);

        JTable tabSimple = new JTable(new CSVTableModel());
        tabSimple.setFillsViewportHeight(true);
        tabSimple.setAutoCreateRowSorter(true);
        scp = new JScrollPane(tabSimple);
        frm.add(scp);

        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}

class SimpleTableModel extends AbstractTableModel {
    private Random rnd = new Random();
    private String colNames[] = { "Item Name", "Price", "Quantity", "Sold" };

    @Override
    public int getRowCount() {
        return 10;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Item" + (rowIndex + 1); // Item
            case 1 -> 100 * (rowIndex + 1); // Price
            case 2 -> rnd.nextInt(30) + 1; // Qty
            case 3 -> rowIndex % 2 == 1; // Sold of Not
            default -> "";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        System.out.printf("Row %d, Col%d, Val %s%n", rowIndex, columnIndex, aValue);
    }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        if (col == 3) // Sold
            return Boolean.class;
        else
            return super.getColumnClass(col);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1; // Price
    }

}