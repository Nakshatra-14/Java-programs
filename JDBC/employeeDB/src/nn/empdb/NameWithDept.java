package nn.empdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NameWithDept 
{
    public static void main(String[] args) throws SQLException {
        String driveName = "com.mysql.cj.jdbc.Driver";
        String dbName = "company";
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
            System.out.println("Database " + dbName + " connected succesfully");
            Statement stmt = con.createStatement(); 

            // String sql = "select Name from Country";
            String sql = "select e.fname, d.dname \n" + 
                                "from emp e, department d\n" +
                                "where e.dno = d.dno";
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                System.out.printf("%-20s %-15s%n", rs.getString(1), rs.getString(2)) ;
                // System.out.printf("%-8s %-2s %-10s %-12s %-8s %-30s %-5s %-20s %-10s%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                
            }
        }
    }

}