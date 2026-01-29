package com.nn.collage_mgt_system;

import javax.swing.JFrame;

public class App extends JFrame {

    App(String title) {
        setTitle(title);
        add(new RoleChooserPanel());
        add(new LoginPagePanel());
        add(new AdminPanel());
        add(new AddStudentPanel());
    }

    public static void main(String[] args) {
        App app = new App("Collage Management System");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setLocationRelativeTo(null);
        app.setVisible(true);

    }
}