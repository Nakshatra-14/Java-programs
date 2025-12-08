package com.example.nn;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();       //Layout
        Scene scene = new Scene(root, 600, 600);     //JPanel

        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Demo Program");

        // stage.setWidth(420);
        // stage.setHeight(420);
        // stage.setResizable(false);
        // stage.setX(100);
        // stage.setY(100);
        // stage.setFullScreen(true);
        // stage.setFullScreenExitHint("press q");
        // stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));


        Text txt = new Text("Hellooo");
        txt.setX(100);
        txt.setY(300);
        txt.setFont(Font.font("Roboto", 50));
        txt.setFill(Color.DARKGREEN);

        Line line = new Line(300, 300, 400, 400);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.5);
        line.setRotate(45);

        Rectangle rec = new Rectangle(100, 100, 100, 100);
        rec.setStroke(Color.BLUE);
        rec.setStrokeWidth(5);
        rec.setFill(Color.PINK);

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
            400.0, 200.0,
            500.0, 300.0,
            400.0, 300.0
        );
        triangle.setFill(Color.GOLD);
        triangle.setStroke(Color.BROWN);
        triangle.setStrokeWidth(5);
        triangle.setRotate(45);

        Circle circle = new Circle();
        circle.setCenterX(500);
        circle.setCenterY(450);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);
        circle.setStroke(Color.DARKORANGE);
        circle.setStrokeWidth(5);

        ImageView imgView = new ImageView(icon);
        imgView.setX(200);
        imgView.setY(450);
        imgView.setFitHeight(100);
        imgView.setFitWidth(100);

        root.getChildren().add(txt);
        root.getChildren().add(line);
        root.getChildren().add(rec);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imgView);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
