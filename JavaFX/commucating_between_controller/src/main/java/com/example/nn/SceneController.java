package com.example.nn;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController {

    @FXML
    TextField txtfdName;

    private Parent root;
    private Scene scene;
    private Stage stage;

    public void GoTologinPage(ActionEvent e) throws IOException
    {

        String str = txtfdName.getText();
        
        // root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root = loader.load();

        DataController dataController = loader.getController();
        dataController.login("Hello " + str);

        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
