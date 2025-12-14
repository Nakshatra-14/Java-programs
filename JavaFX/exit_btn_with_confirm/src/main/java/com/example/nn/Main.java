package com.example.nn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest( ev -> {
            // ev.consume() prevents the default close action of the stage.
            // If we didn't consume the event, the stage would close immediately
            // without waiting for the user's response to the logout confirmation dialog.
            ev.consume(); 
            logout(primaryStage);
        });

    }

    public static void logout(Stage stage)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Do u want to close ?");
        alert.setContentText("Want to save before close ?");

        if(alert.showAndWait().get() == ButtonType.OK)
        {
            System.out.println("LOGOUT");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
