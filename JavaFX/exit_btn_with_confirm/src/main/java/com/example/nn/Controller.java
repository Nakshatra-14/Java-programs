package com.example.nn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    AnchorPane scenePane;

    private Stage stage;

    public void logoutForBtn(ActionEvent e)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Do u want to close ?");
        alert.setContentText("Want to save before close ?");

        if(alert.showAndWait().get() == ButtonType.OK)
        {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("LOGOUT");
            stage.close();
        }
    }
}
