/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quizzapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Timer;

/**
 *
 * @author naksh
 */
public class QuizzApp {

    int i = 0;
    final int MAX_TIME = 10;

    public QuizzApp() {
        var app = new QuizzScreen();
        app.setVisible(true);
        
        ActionListener lsn = _ -> {
            int no = i+1;
            app.addData("New Question " + no, "A", "B", "C", "D");
//            if(app.getUserClick() == false);
        };
        
        Timer timer = new Timer(MAX_TIME * 1000, lsn);
        
        timer.start();
    }
    
    public static void main(String[] args) {
        new QuizzApp();
    }
}
