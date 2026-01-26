package nn.gui;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

class CSVTableModel extends AbstractTableModel {

    private String colNames[] = new String[0];
    private ArrayList<String[]> alRecords = new ArrayList<>();

    CSVTableModel(File csvFile) {
        Pattern pat = Pattern.compile(",");

        try (
                Scanner sc = new Scanner(csvFile);
            ) 
            {
            colNames = pat.split(sc.nextLine());
            String fields[];
            while (sc.hasNextLine()) {
                fields = pat.split(sc.nextLine());
                // System.out.println(Arrays.toString(line));
                alRecords.add(fields);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return alRecords.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return alRecords.get(rowIndex)[columnIndex];
    }

    // @Override
    // public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    //     System.out.printf("Row %d, Col%d, Val %s%n", rowIndex, columnIndex, aValue);
    // }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}

public class CsvViewer {

    public String[] getFileNames()
    {
        ArrayList<String> al = new ArrayList<>();

        return al.toArray(new String[al.size()]);
    }



    public static void main(String[] args) {

        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File("."));
        jfc.setFileFilter(new FileNameExtensionFilter("csv files", "csv", "tsv", "txt"));
        JTable jt = new JTable(new CSVTableModel(new File("Test.csv")));

        JFrame frm = new JFrame("CSV Reader");
        
        JButton btn = new JButton("Button");
        btn.addActionListener( _ -> {
            int result = jfc.showOpenDialog(frm);
            if(result != JFileChooser.CANCEL_OPTION)
                System.out.println("Selected " + jfc.getSelectedFile());
        });

        jt.setFillsViewportHeight(true);
        jt.setAutoCreateRowSorter(true);
        frm.add(btn, BorderLayout.SOUTH);
        frm.add(new JScrollPane(jt));
        frm.pack();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
