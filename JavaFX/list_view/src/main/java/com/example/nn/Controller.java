package com.example.nn;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller implements Initializable {

    @FXML
    private ListView<String> myList;
    
    @FXML
    private Label myLbl;

    private String str;

    String arr[] = {"Apple", "Banana", "Orange", "Grape", "Strawberry", "Blueberry", "Raspberry", "Pineapple", "Mango", "Kiwi", "Watermelon", "Cantaloupe", "Peach", "Pear", "Plum", "Cherry", "Lemon", "Lime", "Coconut", "Pomegranate", "Apricot", "Fig", "Guava", "Lychee", "Papaya", "Passion Fruit", "Persimmon", "Dragon Fruit", "Star Fruit", "Cranberry", "Blackberry", "Currant", "Date", "Elderberry", "Gooseberry", "Honeydew", "Jujube", "Kiwifruit", "Longan", "Mulberry"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        myList.getItems().addAll(arr);

        myList.getSelectionModel().selectedItemProperty().addListener( ev -> {
            str = myList.getSelectionModel().getSelectedItem();
            myLbl.setText(str);
        });

    }

}
