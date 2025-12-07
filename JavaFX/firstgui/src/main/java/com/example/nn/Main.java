package com.example.nn;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();       //Layout
        Scene scene = new Scene(root, Color.BLACK);     //JPanel

        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Demo Program");

        stage.setWidth(420);
        stage.setHeight(420);
        stage.setResizable(false);
        // stage.setX(100);
        // stage.setY(100);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("press q");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

