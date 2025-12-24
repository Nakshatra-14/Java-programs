package nn.empdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL_Connector implements AutoCloseable{
    
    static String driveName = "com.mysql.cj.jdbc.Driver";
    String dbName;
    static String usr = "root";
    static String pwd = "4762";

    static 
    {
        try
        {
            Class.forName(driveName);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver " + driveName + " is not found");
        }
    }

    public static Connection getConnection(String databaseName) throws SQLException
    {
        return getConnection(databaseName, usr, pwd);
    }

    public static Connection getConnection(String databaseName, String user, String password) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        Connection con = DriverManager.getConnection(url, user, password);
        // System.out.println("Database " + databaseName + " connected succesfully");
        return con;
    }

    @Override
    public void close() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet.");
    }
}
