package com.example.nn;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void changeToSceneSecondary(ActionEvent e) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource(""));
    }

    public void changeToScenePrimary(ActionEvent e) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource(""));
    }
}
