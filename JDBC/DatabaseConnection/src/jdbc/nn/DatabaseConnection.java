package jdbc.nn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) throws SQLException {
        String driveName = "com.mysql.cj.jdbc.Driver";
        String dbName = "world";
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
            String sql = "select * from city where district = 'West Bengal'";
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                // System.out.printf("%-40s\n", rs.getString(1)) ;
                System.out.printf("%-8s %-30s %-5s %-30s%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                
            }
        }
    }

}
