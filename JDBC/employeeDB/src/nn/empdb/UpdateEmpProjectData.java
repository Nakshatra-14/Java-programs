package nn.empdb;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateEmpProjectData {
    private static JList<String> empLst;
    private static JTextArea txtAreaProj = new JTextArea(10, 20);
    private static JComboBox<String> cmdBoxAllProj;
    private static JTextField txtFdHour = new JTextField(10);
    private static JButton btnAdd = new JButton("Add");
    private static JButton btnSave = new JButton("Save");
    
    public static void main(String[] args) throws SQLException {
        
        JScrollPane scpLst = new JScrollPane((empLst = new JList<>(getEmpNames())));

        cmdBoxAllProj = new JComboBox<>(getAllProjName());
        JFrame frm = new JFrame();

        JPanel p = new JPanel(new GridBagLayout());
        Insets insets = new Insets(5,5, 5,5);

        //lst
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 3, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(scpLst, gbc);

        //txtArea
        gbc = new GridBagConstraints(1, 0, 3, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.SOUTH, insets, 0, 0);
        p.add(new JScrollPane(txtAreaProj), gbc);

        //combobox
        gbc = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(cmdBoxAllProj, gbc);

        //txtfldHr
        gbc = new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(txtFdHour, gbc);

        //btnAdd
        gbc = new GridBagConstraints(3, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(btnAdd, gbc);

        //btnSave
        gbc = new GridBagConstraints(2, 2, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(btnSave, gbc);

        frm.add(p);
        frm.setVisible(true);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String[] getEmpNames() throws SQLException
    {
        ArrayList<String> al = new ArrayList<>();
        Connection con = MySQL_Connector.getConnection("companydbtest");

        String sql = "select name from emp";
        // PreparedStatement preStmt = con.createStatement(sql);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            al.add(rs.getString(1));
        }
        String arr[] = new String[al.size()];
        return al.toArray(arr);
    }

    public static String[] getAllProjName() throws SQLException
    {
        ArrayList<String> al = new ArrayList<>();

        Connection con = MySQL_Connector.getConnection("companydbtest");
        Statement stmt = con.createStatement();
        String sql = "select pname from project;";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            al.add(rs.getString(1));
        }
        String arr[] = new String[al.size()];
        return al.toArray(arr);
    }
}