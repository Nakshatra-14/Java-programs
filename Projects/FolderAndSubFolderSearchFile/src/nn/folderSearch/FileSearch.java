package nn.folderSearch;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

// class MyFileFilter implements FileFilter
// {

//     @Override
//     public boolean accept(File f) {
//         return f.isFile() && f.getName().endsWith(".java");
//     }
    
// }

public class FileSearch extends JFrame{

    public static void searchFile(File folder, DefaultTableModel result)
    {
        for(File f : folder.listFiles())
        {
            if(f.isFile())
            {
                if(f.isFile() && f.getName().endsWith(".java"))
                    result.addRow(new Object[] {f.getName(), f.getParent(), f.length()});
            }
            else
                searchFile(f, result);
        }
    }

    public static void main(String[] args) {
        FileSearch frm = new FileSearch();
        frm.setTitle("File Search");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frm.setSize(600, 400);
        String colNames[] = {"File Name", "Parent Folder", "File Size"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0)
        {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if(columnIndex == 2)
                    return Long.class;
                else
                    return super.getColumnClass(columnIndex);
            }
        };
        JTable jTable = new JTable(model);
        frm.add(new JScrollPane(jTable));
        // String dir = "C:\\Users\\naksh\\Downloads\\Test";
        String dir = "E:\\code\\Java";
        searchFile(new File(dir), model);
        System.out.println(jTable.getRowCount());
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);



    }

}
