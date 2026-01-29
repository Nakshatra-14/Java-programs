package nn.gui;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

public class CsvViewer extends JFrame{

    private JTextField txtFileName = new JTextField(20);
    private JFileChooser jfc = new JFileChooser();
    JButton browseBtn = new JButton("...");
    JButton openBtn = new JButton("Open");
    private JTable jt;
    private File file = new File("Test2.csv");
    JPanel tablePanel = new JPanel();

    public CsvViewer()
     {
        setTitle("CSV Reader");

        jfc.setCurrentDirectory(new File("."));
        jfc.setFileFilter(new FileNameExtensionFilter("csv files", "csv"));

        
        browseBtn.addActionListener( _ -> {
            int result = jfc.showOpenDialog(this);
            if(result != JFileChooser.CANCEL_OPTION)
                {
                    // System.out.println("Selected " + jfc.getSelectedFile());
                    file = new File(jfc.getSelectedFile().getAbsolutePath());
                    txtFileName.setText(file.getName());
                }
                
            });

        openBtn.addActionListener( _ -> {
            System.out.println(file);
            if(!file.getName().equals(txtFileName.getText()))
            {
                JOptionPane.showMessageDialog(this, "No csv found of name " + txtFileName.getText() + "\nIt might be " + file.getName());
                return;
            }
            showTable(tablePanel, jt, file);   
        });
        
        JPanel p = new JPanel();
        p.add(txtFileName);
        p.add(browseBtn);
        p.add(openBtn);
        add(p, BorderLayout.NORTH);

        // showTable(tablePanel, jt, file);

        add(tablePanel, BorderLayout.SOUTH);

    }

    public void showTable(JPanel p, JTable jt, File file)
    {
        p.removeAll();
        jt = new JTable(new CSVTableModel(file));
        jt.setFillsViewportHeight(true);
        jt.setAutoCreateRowSorter(true);
        p.add(new JScrollPane(jt));
        p.repaint();
        revalidate();
        pack();
    }

    public static void main(String[] args) {
        CsvViewer csvViewer = new CsvViewer();
        csvViewer.pack();
        csvViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        csvViewer.setVisible(true);
    }
}
