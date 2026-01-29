package com.nn.collage_mgt_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static Connection getConnection(String databaseName, String username, String password)
    {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
