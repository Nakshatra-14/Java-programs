package stream.nn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private String driverName;
    private String dbName;
    private String url;
    private String usr;
    private String pwd;

    public DatabaseConnection()
    {
        this("world", "root", "4762");
    }

    public DatabaseConnection(String dbName, String usr, String pwd) {
        this.dbName = dbName;
        this.driverName = "com.mysql.cj.jdbc.Driver";
        this.pwd = pwd;
        this.url = "jdbc:mysql://localhost:3306/" + dbName + "?charecterEncoding=Latin1";
        this.usr = usr;

        try
        {
            Class.forName(driverName);
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        try {
            return DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsr() {
        return usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
        url = "jdbc:mysql://localhost:3306/" + dbName + "?charecterEncoding=Latin1";
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
