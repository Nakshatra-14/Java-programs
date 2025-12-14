package com.example.nn;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void changeToSceneSecondary(ActionEvent e) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void changeToScenePrimary(ActionEvent e) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
