package com.nn.collage_mgt_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class App {

    JFrame frm = new JFrame("Collage Management System");
    private String dbName = "collagedb";
    private int selectedDeleteId = 0;
    private int selectedUpdateId = 0;
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

    private JButton btnBack = new JButton("Back");

    App() {
        runJFrame(roleChooserPanel);
        // if(frm.getRootPane().equals(roleChooserPanel))
        //     btnBack.setVisible(false);
        // runJFrame(new LoginPagePanel().getName(), new LoginPagePanel());
        // runJFrame(new AdminPagePanel().getName(), new AdminPagePanel());
        // runJFrame(new AddStudentPanel().getName(), new AddStudentPanel());
        // runJFrame(new DeleteStudentPanel().getName(), new DeleteStudentPanel());
        // System.out.println(Arrays.toString(frm.getComponents()));
        addActionListenerToAll();
    }

    public void runJFrame(JPanel p) {
        btnBack.setVisible(false);
        p.setBorder(BorderFactory.createLineBorder(Color.white, 5));
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(btnBack, BorderLayout.SOUTH);
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
            btnBack.setVisible(true);
            btnBack.addActionListener(_-> {
            manageBtnBack(loginPagePanel, roleChooserPanel);
            });
        });

        roleChooserPanel.getBtnStudent().addActionListener(_->{
            System.out.println("Student is CLicked");
            updateFrame(roleChooserPanel, searchStudentPanel);
            manageBtnBack(searchStudentPanel, roleChooserPanel);
        });

        loginPagePanel.getBtnSubmit().addActionListener(_-> {
            
            manageBtnBack(adminPagePanel, loginPagePanel);
    

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
            manageBtnBack(addStudentPanel, adminPagePanel);
        });

        adminPagePanel.getBtnDeleteStu().addActionListener(_ -> {
            updateFrame(adminPagePanel, deleteStudentPanel);
            manageBtnBack(deleteStudentPanel, adminPagePanel);
        });

        adminPagePanel.getBtnUpdateStu().addActionListener(_ -> {
            updateFrame(adminPagePanel, updateStudentPanel);
            manageBtnBack(updateStudentPanel, adminPagePanel);
        });

        adminPagePanel.getBtnSearchStu().addActionListener(_ -> {
            updateFrame(adminPagePanel, searchStudentPanel);
            manageBtnBack(searchStudentPanel, adminPagePanel);
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
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frm, "Unable to find any data of Id " + id);
                updateFrame(searchStudentPanel, roleChooserPanel);
            }
        });


        deleteStudentPanel.getBtnSearch().addActionListener(_->{
            int id = Integer.parseInt(deleteStudentPanel.getTxtId().getText());
            try {
                Connection con = MySQL.getConnection(dbName, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from studentdata\n" + //
                                                 "where id = " + id);
                rs.next();
                selectedDeleteId = rs.getInt(1);
                deleteStudentPanel.setTxtShowId(selectedDeleteId);
                deleteStudentPanel.setTxtShowName(rs.getString(2));
                deleteStudentPanel.setTxtShowBatch(rs.getString(3));
                con.close();
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

        updateStudentPanel.getBtnSearch().addActionListener(_ -> {
            int id = Integer.parseInt(updateStudentPanel.getTxtId().getText());
            try {
                Connection con = MySQL.getConnection(dbName, username, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from studentdata\n" + //
                                                 "where id = " + id);
                rs.next();
                selectedUpdateId = rs.getInt(1);
                String name = rs.getString(2);
                String batch = rs.getString(3);
                updateStudentPanel.getTxtShowId().setText(String.valueOf(selectedUpdateId));
                updateStudentPanel.getTxtShowName().setText(name);
                updateStudentPanel.getTxtShowBatch().setText(batch);

                updateStudentPanel.getTxtShowNewId().setText(String.valueOf(selectedUpdateId));
                updateStudentPanel.getTxtShowNewName().setText(name);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frm, "Error occured\nId might be wrong");
            }
        });

        updateStudentPanel.getBtnUpdate().addActionListener(_-> {
            String newBatch = updateStudentPanel.getTxtShowNewBatch().getText();
            if(newBatch.isEmpty())
            {
                JOptionPane.showMessageDialog(frm, "Enter new Batch name to update");
                return;
            }
            if(!updateStudentData(selectedUpdateId, newBatch))
                {
                JOptionPane.showMessageDialog(frm, "Error occured while updating");
            }
            else
            {
                JOptionPane.showMessageDialog(frm, "Succesfully updated");
                updateFrame(updateStudentPanel, adminPagePanel);

            }

        });
        
    }

    public void manageBtnBack(JPanel fromPanel, JPanel toPanel)
    {
        btnBack.removeAll();
        btnBack.setVisible(true);
        btnBack.addActionListener(_-> {
            updateFrame(fromPanel, toPanel);
        });
    }

    public void updateFrame(JPanel initPanel, JPanel finalPanel)
    {
        frm.remove(initPanel);
        frm.add(finalPanel);
        if(finalPanel.equals(roleChooserPanel))
            btnBack.setVisible(false);
        frm.revalidate();
        frm.repaint();
    }

    public boolean addStudentData(int id, String name, String batch)
    {
        try {
            Connection con = MySQL.getConnection(dbName, username, password);
            PreparedStatement pstmt = con.prepareStatement("insert into studentdata()\n" + //
                                                  "values (?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, batch);

            pstmt.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudentData(int id)
    {
        try {
            Connection con = MySQL.getConnection(dbName, username, password);
            PreparedStatement pstmt = con.prepareStatement("delete from studentdata\n" + //
                                                          "where id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateStudentData(int id, String newBatch)
    {
        try {
            Connection con = MySQL.getConnection(dbName, username, password);
            PreparedStatement pstmt = con.prepareStatement("update studentdata\n" + //
                                                           "set batch = ?\n" + //
                                                           "where id = ?");
            pstmt.setString(1, newBatch);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws SQLException {
        new App();
        
    }
}