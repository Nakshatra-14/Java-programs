package nn.empdb;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateEmpProjectData {

    private static JComboBox<String> comboNoProjEmp;
    private static JComboBox<String> comboProjects;
    private static JTextField txtFdHours = new JTextField();
    private static JButton btn = new JButton("Submit");

    public static void main(String[] args) throws SQLException {
        JFrame frm = new JFrame("Update Emp Project Data");
        
        comboNoProjEmp = new JComboBox<>(getNoProjEmp());
        comboProjects = new JComboBox<>(getProjects());
        
        txtFdHours.setVisible(false);
        comboProjects.setVisible(false);

        JPanel p = new JPanel();

        btn.addActionListener( _ -> {
            System.out.println("Submitted");
        });

        p.add(comboNoProjEmp);
        p.add(comboProjects);
        p.add(txtFdHours);
        p.add(btn);

        frm.add(p);
        frm.pack();
        // frm.setResizable(false);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);

    }

    public static String[] getNoProjEmp() throws SQLException 
    {
        ArrayList<String> al = new ArrayList<>();
        MySQL_Connector connector = new MySQL_Connector("companydb");

            ResultSet rs = connector.getResultSetOfExecuteQuery("select name from emp");
            
            while(rs.next())
            {
                al.add(rs.getString(1));
            }
        try {
            connector.close();
        } catch (Exception ex) {
            System.getLogger(UpdateEmpProjectData.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        String arr[] = new String[al.size()];
        return al.toArray(arr);
    } 

    public static String[] getProjects() throws SQLException
    {
ArrayList<String> al = new ArrayList<>();
        MySQL_Connector connector = new MySQL_Connector("companydb");

            ResultSet rs = connector.getResultSetOfExecuteQuery("select pname from project");
            
            while(rs.next())
            {
                al.add(rs.getString(1));
            }
        try {
            connector.close();
        } catch (Exception ex) {
            System.getLogger(UpdateEmpProjectData.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
            String arr[] = new String[al.size()];
            return al.toArray(arr);
    }

}