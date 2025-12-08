package com.example.nn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, Color.GREY);
        
        // Circle circle = new Circle();
        // circle.setRadius(50);
        // circle.setCenterX(scene.getWidth()/2);
        // circle.setCenterY(scene.getHeight()/2);
        // circle.setFill(Color.YELLOW);
        // circle.setStroke(Color.YELLOWGREEN);
        // circle.setStrokeWidth(10);

        // root.getChildrenUnmodifiable().add(circle);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
