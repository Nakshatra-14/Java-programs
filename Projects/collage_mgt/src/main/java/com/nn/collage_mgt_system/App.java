package com.nn.collage_mgt_system;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.mysql.cj.jdbc.result.UpdatableResultSet;


public class App {

    JFrame frm = new JFrame("Collage Management System");
    private String dbName = "collagedb";
    private int selectedDeleteId = 0;
    private final String username = "root";
    private final String password = "4762";
    // private ResultSet rs;

    private RoleChooserPanel roleChooserPanel = new RoleChooserPanel();
    private LoginPagePanel loginPagePanel = new LoginPagePanel();
    private SearchStudentPanel searchStudentPanel = new SearchStudentPanel();
    private AdminPagePanel adminPagePanel = new AdminPagePanel();
    private AddStudentPanel addStudentPanel = new AddStudentPanel();
    private DeleteStudentPanel deleteStudentPanel = new DeleteStudentPanel();
    private UpdateStudentPanel updateStudentPanel = new UpdateStudentPanel();

    App() {
        runJFrame(roleChooserPanel);
        // runJFrame(new LoginPagePanel().getName(), new LoginPagePanel());
        // runJFrame(new AdminPagePanel().getName(), new AdminPagePanel());
        // runJFrame(new AddStudentPanel().getName(), new AddStudentPanel());
        // runJFrame(new DeleteStudentPanel().getName(), new DeleteStudentPanel());
        addActionListenerToAll();
    }

    public void runJFrame(JPanel p) {
        p.setBorder(BorderFactory.createLineBorder(Color.white, 5));
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(p);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setVisible(true);
    }

    public void addActionListenerToAll() 
    {
        roleChooserPanel.getBtnAdmin().addActionListener(_->{
            System.out.println("Admin is Clicked");
            updateFrame(roleChooserPanel, loginPagePanel);
        });

        roleChooserPanel.getBtnStudent().addActionListener(_->{
            System.out.println("Student is CLicked");
            updateFrame(roleChooserPanel, searchStudentPanel);
        });

        loginPagePanel.getBtnSubmit().addActionListener(_-> {
            System.out.println("Submit is Clicked for Login");
            System.out.println(loginPagePanel.getTxtUsername().getText() + ", " + loginPagePanel.getTxtPassword().getText());
            // String str = "select * from admin";
            try {
                Connection con = MySQL.getConnection(dbName, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from admin");
                rs.next();
                // System.out.printf("%-5d%s%n", rs.getInt(1), rs.getString(2));
                if(rs.getInt(1) == Integer.parseInt(loginPagePanel.getTxtUsername().getText()) && rs.getString(2).equals(loginPagePanel.getTxtPassword().getText()))
                {
                    updateFrame(loginPagePanel, adminPagePanel);
                    rs.close();
                }
                else
                    JOptionPane.showMessageDialog(frm, "Incorrect Username or Password");
            } catch (SQLException ex) {
            }

        });
        
        adminPagePanel.getBtnAddStu().addActionListener(_ -> {
            updateFrame(adminPagePanel, addStudentPanel);
        });

        adminPagePanel.getBtnDeleteStu().addActionListener(_ -> {
            updateFrame(adminPagePanel, deleteStudentPanel);
        });

        adminPagePanel.getBtnUpdateStu().addActionListener(_ -> {
            updateFrame(adminPagePanel, updateStudentPanel);
        });

        adminPagePanel.getBtnSearchStu().addActionListener(_ -> {
            updateFrame(adminPagePanel, searchStudentPanel);
        });

        addStudentPanel.getBtnSubmit().addActionListener(_->{
            int id = Integer.parseInt(addStudentPanel.getTxtId().getText());
            String name = addStudentPanel.getTxtName().getText().trim();
            String batch = addStudentPanel.getTxtBatch().getText().trim();

            if(!addStudentData(id, name, batch))
                JOptionPane.showMessageDialog(frm, "Error");
            else
            {
                JOptionPane.showMessageDialog(frm, "Student added to database succesfully");
                updateFrame(addStudentPanel, adminPagePanel);
            }
        });

        searchStudentPanel.getBtnSearch().addActionListener(_->{
            int id = Integer.parseInt(searchStudentPanel.getTxtId().getText());
            try {
                Connection con = MySQL.getConnection(dbName, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from studentdata\n" + //
                                                 "where id =" + id);
                rs.next();
                searchStudentPanel.setTxtShowId(rs.getInt(1));
                searchStudentPanel.setTxtShowName(rs.getString(2));
                searchStudentPanel.setTxtShowBatch(rs.getString(3));
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frm, "Unable to find any data of Id " + id);
                updateFrame(searchStudentPanel, roleChooserPanel);
            }
        });


        deleteStudentPanel.getBtnSearch().addActionListener(_->{
            int id = Integer.parseInt(deleteStudentPanel.getTxtId().getText());
            // rs = getResultSetOfSQL("select * from studentdata\n" + //
            //                        "where id = " + id);
            try {
                Connection con = MySQL.getConnection(dbName, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("delete from studentdata\n" + 
                                                 "where id =" + id);
                rs.next();
                selectedDeleteId = rs.getInt(1);
                deleteStudentPanel.setTxtShowId(selectedDeleteId);
                deleteStudentPanel.setTxtShowName(rs.getString(2));
                deleteStudentPanel.setTxtShowBatch(rs.getString(3));
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frm, "Error occured\nId might be wrong");
            }
        });

        deleteStudentPanel.getBtnDelete().addActionListener(_-> {
            if(!deleteStudentData(selectedDeleteId))
                JOptionPane.showMessageDialog(frm, "Unable to delete");
            else
            {
                JOptionPane.showMessageDialog(frm, "Succesfully deleted");
                updateFrame(deleteStudentPanel, adminPagePanel);
            }
        });

        
    }

    public void updateFrame(JPanel initPanel, JPanel finalPanel)
    {
        frm.remove(initPanel);
        frm.add(finalPanel);
        frm.revalidate();
    }

    public ResultSet getResultSetOfSQL(String sqlQuery)
    {
        try {
            // try
            // (
            Connection con = MySQL.getConnection(dbName, "root", "4762");
            Statement stmt = con.createStatement();
            // )
            // {
            return stmt.executeQuery(sqlQuery);
            // }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean addStudentData(int id, String name, String batch)
    {
        try {
            Connection con = MySQL.getConnection(dbName, "root", "4762");
            PreparedStatement pstmt = con.prepareStatement("insert into studentdata()\n" + //
                                                  "values (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, batch);

            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudentData(int id)
    {
        try {
            Connection con = MySQL.getConnection(dbName, "root", "4762");
            PreparedStatement pstmt = con.prepareStatement("delete from studentdata\n" + //
                                                          "where id = " + id);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws SQLException {
        new App();

        // ResultSet rs = getResultSetOfSQL("select * from deptloc");
        // while(rs.next())
        // {
        //     System.out.printf("%-5d%s%n", rs.getInt(1), rs.getString(2));
        // }
        
    }
}