package nn.folderSearch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class FolderSearch extends JFrame {

    private ArrayList<File> filesArrayList = new ArrayList<>();
    private ArrayList<Object[]> alRecords = new ArrayList<>();
    // private static ArrayList<File> subFolderArrayList = new ArrayList<>();
    String dir = "C:\\Users\\naksh\\Downloads\\Test";
    String prefix = "png";
    String colNames[] = {"File Name", "Parent Folder", "File Size"};

    public void setFileInArrayList(File dir) {
        for (File f : dir.listFiles()) {
            // System.out.println(f);
            if (f.isFile()) {
                // if(f)
                filesArrayList.add(f);
            } else {
                setFileInArrayList(f);
                // subFolderArrayList.add(f);
            }
        }
    }

    public void searchFile(File folder, DefaultTableModel result)
    {

    }

    public FolderSearch() throws IOException {
        setFileInArrayList(new File(dir));
        // System.out.println(filesArrayList);
        add(new JScrollPane(new JTable(new MyTableModel())));
    }

    public static void main(String[] args) throws IOException {
        FolderSearch frm = new FolderSearch();
        frm.setTitle("File Search");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frm.setSize(600, 400);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    class MyTableModel extends AbstractTableModel {

       MyTableModel() throws IOException
       {
            for(int i = 0 ; i < filesArrayList.size() ; i++)
            {
                File f = filesArrayList.get(i);
                alRecords.add(new Object[] {f.getName(), f.getParentFile(), f.length()});
            }
       }

        @Override
        public int getRowCount() {
            return filesArrayList.size();
        }
        
        @Override
        public int getColumnCount() {
            return colNames.length;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return alRecords.get(rowIndex)[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public String getColumnName(int column) {
            return colNames[column];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
        
    }

}
