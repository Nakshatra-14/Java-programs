package nn.empdb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringJoiner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DeptLocation {

    public static String[] getDeptNames() 
    {
        ArrayList<String> al = new ArrayList<>();
        String driveName = "com.mysql.cj.jdbc.Driver";
        String dbName = "companydb";
        String url = "jdbc:mysql://localhost:3306/" + dbName;

        String usr = "root";
        String pwd = "4762";

        try
        {
            Class.forName(driveName);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver " + driveName + " is not found");
        }

        try 
        (
            Connection con = DriverManager.getConnection(url, usr, pwd);
        ) 
        {
            // System.out.println("Database " + dbName + " connected succesfully");
            Statement stmt = con.createStatement(); 

            String sql = "select Dname from department";
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                al.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String arr[] = new String[al.size()];
        return al.toArray(arr);
    }

    public static String getDeptLoc(int dno)
    {
        String driveName = "com.mysql.cj.jdbc.Driver";
        String dbName = "companydb";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        StringJoiner sj = new StringJoiner(", ");

        String usr = "root";
        String pwd = "4762";

        try
        {
            Class.forName(driveName);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver " + driveName + " is not found");
        }

        try 
        (
            Connection con = DriverManager.getConnection(url, usr, pwd);
        ) 
        {
            // System.out.println("Database " + dbName + " connected succesfully");
            Statement stmt = con.createStatement(); 

            String sql = "select dloc\n" + 
                         "from deptloc\n" + 
                         "where dno = " + dno;
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                sj.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sj.toString();
    }
    
    public static void main(String[] args) {
        JFrame frm = new JFrame("Department Location");
        
        JTextArea deptlocTxt = new JTextArea(8, 30);
        JButton btn = new JButton("Submit");
        String deptNames[] = getDeptNames();
        JComboBox<String> deptNameCB = new JComboBox<>(deptNames);
        
        JPanel p = new JPanel(new BorderLayout(10, 10));

        btn.addActionListener(_ -> {
            deptlocTxt.setText(getDeptLoc(deptNameCB.getSelectedIndex()+1));
        });

        p.add(deptNameCB, BorderLayout.NORTH);
        p.add(btn, BorderLayout.CENTER);
        p.add(deptlocTxt, BorderLayout.SOUTH);

        frm.add(p);

        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
