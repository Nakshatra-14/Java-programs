/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.billmgtsystemfull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author naksh
 */
public class MySQL_Connector {
    
    static String driveName = "com.mysql.cj.jdbc.Driver";
  
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
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        return DriverManager.getConnection(url);
    }
}
