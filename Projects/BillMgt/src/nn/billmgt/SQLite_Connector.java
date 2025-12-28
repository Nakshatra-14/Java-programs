package nn.billmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite_Connector {
    
    static String driveName = "org.sqlite.JDBC";
    String dbName;

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
        String url = "jdbc:sqlite:" + databaseName + ".db";
        Connection con = DriverManager.getConnection(url);
        System.out.println("Database " + databaseName + " connected succesfully");
        return con;
    }
}
