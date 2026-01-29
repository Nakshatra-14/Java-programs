package com.nn.collage_mgt_system;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoleChooserPanel extends JPanel {

    private JPanel jp = new JPanel();
    private JPanel jpFooter = new JPanel();
    private JLabel lblTitle = new JLabel();
    private JLabel lblSelectTxt = new JLabel();
    private JButton adminBtn = new JButton();
    private JButton studentBtn = new JButton();

    RoleChooserPanel() {

        setBackground(new java.awt.Color(191, 255, 188));
        setPreferredSize(new java.awt.Dimension(680, 400));

        jp.setBackground(new java.awt.Color(166, 255, 161));

        lblTitle.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblTitle.setText("COLLAGE MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jp);
        jp.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblTitle)
                        .addContainerGap(25, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)));

        lblSelectTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSelectTxt.setForeground(new java.awt.Color(51, 51, 51));
        lblSelectTxt.setText("SELECT YOUR ROLE");

        adminBtn.setBackground(new java.awt.Color(219, 173, 106));
        adminBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        adminBtn.setForeground(new java.awt.Color(51, 51, 51));
        adminBtn.setText("ADMIN");
        adminBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        studentBtn.setBackground(new java.awt.Color(150, 137, 123));
        studentBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentBtn.setForeground(new java.awt.Color(51, 51, 51));
        studentBtn.setText("STUDENT");
        studentBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jpFooter.setBackground(new java.awt.Color(39, 7, 34));
        jpFooter.setForeground(new java.awt.Color(98, 131, 149));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jpFooter);
        jpFooter.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 36, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(237, 237, 237)
                                        .addComponent(lblSelectTxt))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(adminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(studentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jpFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblSelectTxt)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(studentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jpFooter, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

        );
        addActionlistenerToButton(adminBtn, studentBtn);
    }

    public void addActionlistenerToButton(JButton adminBtn, JButton studentButton) {
        adminBtn.addActionListener(_ -> {
            System.out.println("Admin is clicked");
        });

        studentBtn.addActionListener(_ -> {
            System.out.println("Student is clicked");
        });
    }

}
