package com.example.nn;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DataController {
    
    @FXML
    private Label username;

    public void login(String name)
    {
        username.setText(name);
    }
}
