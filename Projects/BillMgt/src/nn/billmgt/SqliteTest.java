package nn.billmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteTest {
    public static void main(String[] args) throws SQLException {
    
            String driveName = "org.sqlite.JDBC";
            String dbName = "test";
            String url = "jdbc:sqlite:" + dbName + ".db";
            
        try {
            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
           System.out.println("Driver " + driveName + " is not found");
        }   

        try 
        (
            Connection con = DriverManager.getConnection(url);
        )
        {
            System.out.println("Database " + dbName + " connected succesfully");
            Statement stmt = con.createStatement();

            String sql = """
                        create table emp(
                            id Integer,
                            name Varchar(30)
                        )
                        """;

            stmt.execute(sql);
            stmt.close();
            stmt = con.createStatement();
            sql = """
                    create table workon(
                        id Integer,
                        dept Varchar(20),
                        projId Integer
                    )
                    """;
            stmt.execute(sql);
            stmt.close();
        }
    }
}
