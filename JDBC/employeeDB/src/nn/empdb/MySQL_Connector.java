package nn.empdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL_Connector implements AutoCloseable{
    
    String driveName = "com.mysql.cj.jdbc.Driver";
    String dbName;
    String usr = "root";
    String pwd = "4762";
    Connection con;
    Statement stmt;
    
    public MySQL_Connector(String databaseName) throws SQLException {
        this.dbName = databaseName;
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        try
        {
            Class.forName(driveName);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver " + driveName + " is not found");
        }
        con = DriverManager.getConnection(url, usr, pwd);
        System.out.println("Database " + dbName + " connected succesfully");
        stmt = con.createStatement();
    }

    public Connection getConnection()
    {
        return con;
    }

    public Statement getStatement() throws SQLException
    {
        return stmt;
    }

    public ResultSet getResultSetOfExecuteQuery(String query) throws SQLException
    {
 System.out.println("Executing Query: " + query);
        return stmt.executeQuery(query);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Connection " + dbName + " Closed");
    }

}
