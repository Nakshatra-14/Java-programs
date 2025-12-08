package com.example.nn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    Circle circle;
    private int x;
    private int y;

    public void up(ActionEvent e)
    {
        // System.out.println("UP");
        circle.setCenterY(y-=4);
    }
    public void down(ActionEvent e)
    {
        // System.out.println("DOWN");
        circle.setCenterY(y+=4);

    }
    public void left(ActionEvent e)
    {
        // System.out.println("LEFT");
        circle.setCenterX(x-=4);

    }
    public void right(ActionEvent e)
    {
        // System.out.println("RIGHT");
        circle.setCenterX(x+=4);
    }
}
