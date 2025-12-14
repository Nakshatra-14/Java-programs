package com.example.nn;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ImageView myImageView;

    Image img = new Image(getClass().getResourceAsStream("2.png"));

    public void changeImage()
    {
        myImageView.setImage(img);
    }
}
