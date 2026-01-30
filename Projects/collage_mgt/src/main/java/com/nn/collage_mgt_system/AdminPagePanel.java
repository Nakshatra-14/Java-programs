package com.nn.collage_mgt_system;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminPagePanel extends JPanel {

    private JButton btnAddStu = new javax.swing.JButton();
    private JButton btnDeleteStu = new javax.swing.JButton();
    private JButton btnUpdateStu = new javax.swing.JButton();
    private JPanel jPanel1 = new javax.swing.JPanel();
    private JLabel jLabel1 = new javax.swing.JLabel();
    private JButton btnSearchStu = new JButton();

    public AdminPagePanel() {

        setBackground(new java.awt.Color(191, 255, 188));
        setPreferredSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(new java.awt.Color(166, 255, 161));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ADMIN PANEL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE)));

        btnDeleteStu.setBackground(new java.awt.Color(255, 31, 64));
        btnDeleteStu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDeleteStu.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteStu.setText("Delete Student");

        btnUpdateStu.setBackground(new java.awt.Color(156, 28, 137));
        btnUpdateStu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdateStu.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStu.setText("Update Student");

        btnAddStu.setBackground(new java.awt.Color(17, 156, 17));
        btnAddStu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddStu.setForeground(new java.awt.Color(255, 255, 255));
        btnAddStu.setText("Add Student");

        btnSearchStu.setBackground(new java.awt.Color(51, 51, 255));
        btnSearchStu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSearchStu.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchStu.setText("Search Student");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnUpdateStu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddStu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSearchStu, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteStu))
                                .addGap(85, 85, 85)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddStu, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearchStu, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdateStu, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteStu, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(58, Short.MAX_VALUE)));

    }

    public JButton getBtnAddStu() {
        return btnAddStu;
    }

    public JButton getBtnDeleteStu() {
        return btnDeleteStu;
    }

    public JButton getBtnUpdateStu() {
        return btnUpdateStu;
    }

    public JButton getBtnSearchStu() {
        return btnSearchStu;
    }

}
