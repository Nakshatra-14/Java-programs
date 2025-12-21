package com.example.nn;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FormController implements Initializable{

    @FXML
    private ListView<String> myList;
    @FXML
    private ComboBox<String> occupComboBox;
    @FXML
    private TextField txtFdName;
    @FXML
    private TextArea txtFdAddress;
    @FXML
    private DatePicker datePickDOB;
    @FXML
    private RadioButton rMale, rFemale;
    @FXML
    private TextField txtFdEmail;
    @FXML
    private TextField txtFdUsername;
    @FXML
    private PasswordField txtFdPassword;
    @FXML
    private Button btnFirst;
    @FXML
    private Button btnPrevious;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnLast;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnChangePicture;
    @FXML
    private ImageView myImgView;

    ArrayList<Person> people;
    int curIndex = -1;
    DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // char

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // System.out.println("Hellooo");
        people = new ArrayList<>();
        try {
            people = Person.generate();
        } catch (Exception e) {
            System.err.println("ERROR");
            e.printStackTrace();
        }
        for (Person p : people) {
            myList.getItems().add(p.getName());
        }

        try {
            occupComboBox.getItems().addAll(txtFileToArray(new File("src\\main\\resources\\com\\example\\nn\\jobs.txt")));
        } catch (FileNotFoundException ex) {
            System.getLogger(FormController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        firstListItem();
        
        myList.getSelectionModel().selectedItemProperty().addListener( ev -> {
            curIndex = myList.getSelectionModel().getSelectedIndex();
            showData(curIndex);
        });
    
    }

    public String[] txtFileToArray(File file) throws FileNotFoundException
    {
        ArrayList<String> al = new ArrayList<>();
        
        try
        (
            Scanner inp = new Scanner(file);
        )
        {
            while (inp.hasNextLine()) {
                al.add(inp.nextLine());
            }
        }

        String arr[] = new String[al.size()];
        return al.toArray(arr);
    }

    public void showData(int curIndex)
    {
        Person p = people.get(curIndex);
        txtFdName.setText(p.getName());
        String addr[] = p.getAddress().split(", ");
        txtFdAddress.setText(String.join("\n", addr));
        datePickDOB.setValue(LocalDate.parse(p.getDob(), dtFormat));
        // System.out.println(p.getDob());
        if(p.getGender().equals("M"))
            rMale.setSelected(true);
        else
            rFemale.setSelected(true);
        txtFdEmail.setText(p.getEmail());
        occupComboBox.getSelectionModel().select(p.getOccupation() - 1);
        txtFdUsername.setText(p.getUsername());
        txtFdPassword.setText(p.getPassword());
        btnSave.setDisable(true);
    }

    public void blankData()
    {
        txtFdName.setText("");
        txtFdAddress.setText("");
        datePickDOB.setValue(null);
        rFemale.setSelected(true);
        rFemale.setSelected(false);
        txtFdEmail.setText("");
        occupComboBox.getSelectionModel().select(null);
        txtFdUsername.setText("");
        txtFdPassword.setText("");
        btnChangePassword.setDisable(false);
        btnChangePicture.setDisable(false);
    }
    
    public void addData()
    {
        blankData();
        btnFirst.setDisable(true);
        btnPrevious.setDisable(true);
        btnNext.setDisable(true);
        btnLast.setDisable(true);
        btnAdd.setDisable(true);
        btnEdit.setDisable(true);
        btnSave.setDisable(false);
        btnChangePassword.setDisable(true);
        btnChangePicture.setDisable(true);
    }

    public void editData(){
        btnFirst.setDisable(true);
        btnPrevious.setDisable(true);
        btnNext.setDisable(true);
        btnLast.setDisable(true);
        btnAdd.setDisable(true);
        btnEdit.setDisable(true);
        btnSave.setDisable(false);
        btnChangePassword.setDisable(true);
        btnChangePicture.setDisable(true);
    }

    public boolean checkData()
    {
        boolean check = true;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //Name
        if(!txtFdName.getText().trim().matches("[A-Za-z ]+"))
        {
            check = false;
            alert.setHeaderText("Name should be between A to Z charecters");
            if(alert.showAndWait().get() == ButtonType.OK)
                txtFdName.requestFocus();
        }

        //Address
        if(!txtFdAddress.getText().trim().matches("[A-Za-z0-9 ]+"))
        {
            check = false;
            alert.setHeaderText("For Address use A - Z, 0 - 9 and ',' charecters is allowed");
            if(alert.showAndWait().get() == ButtonType.OK)
                txtFdAddress.requestFocus();
        }

        //DOB
        if(datePickDOB.getValue() == null)
        {
            check = false;
            alert.setHeaderText("Give a proper date in format dd/mm/yyyy");
            if(alert.showAndWait().get() == ButtonType.OK)
                datePickDOB.requestFocus();
        }

        //Gender
        if(rMale.isSelected() == false && rFemale.isSelected() == false)
        {
            check = false;
            alert.setHeaderText("Select a Gender");
            alert.showAndWait();
        }

        //Email
        if(!txtFdEmail.getText().trim().matches("[A-Za-z0-9]+"))
        {
            check = false;
            alert.setHeaderText("Give a proper Email");
            if(alert.showAndWait().get() == ButtonType.OK)
                datePickDOB.requestFocus();
        }

        //Occupation
        if(occupComboBox.getSelectionModel().getSelectedItem() == null)
        {
            check = false;
            alert.setHeaderText("Select a Occupation");
            if(alert.showAndWait().get() == ButtonType.OK)
                occupComboBox.requestFocus();
        }

        //Username
        if(!txtFdUsername.getText().trim().matches("[A-Za-z0-9]+"))
        {
            check = false;
            alert.setHeaderText("Give a Username");
            if(alert.showAndWait().get() == ButtonType.OK)
                txtFdUsername.requestFocus();
        }

        //Password
        if(!txtFdPassword.getText().trim().matches("[A-Za-z0-9]+"))
        {
            check = false;
            alert.setHeaderText("Give a password");
            if(alert.showAndWait().get() == ButtonType.OK)
                txtFdPassword.requestFocus();
        }

        return check;
    }

    public void saveData()
    {
        if(checkData())
        {
            String name = txtFdName.getText().trim();
            String address = txtFdAddress.getText().trim();
            LocalDate lDt = datePickDOB.getValue();
            String dob = lDt.format(dtFormat);
            String gender = "";
            if(rMale.isSelected())
                gender = "M";
            else
                gender = "F";
            String occupation = String.valueOf(occupComboBox.getSelectionModel().getSelectedIndex() + 1);
            String username = txtFdUsername.getText().trim();
            String password = txtFdPassword.getText().trim();
            Person p = new Person(name, dob, gender, address, dob, occupation, username, password);

            people.add(p);

            myList.getItems().add(p.getName());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Person " + p.getName() + " has been added succesfully");
            System.out.println("New Person is saved");
        }
        else
            System.out.println("Wrong Data Input");
    }

    public void cancel()
    {
        showData(curIndex);
        btnFirst.setDisable(false);
        btnPrevious.setDisable(false);
        btnNext.setDisable(false);
        btnAdd.setDisable(false);
        btnLast.setDisable(false);
        btnEdit.setDisable(false);
        btnChangePassword.setDisable(false);
        btnChangePicture.setDisable(false);
    }

    public void firstListItem()
    {
        curIndex = 0;
        myList.getSelectionModel().select(curIndex);
        curIndex = myList.getSelectionModel().getSelectedIndex();
        showData(curIndex);
    }
    public void previousListItem()
    {
        if(curIndex > 0)
            curIndex-=1;
        else 
            curIndex = people.size() - 1;
        myList.getSelectionModel().select(curIndex);
        curIndex = myList.getSelectionModel().getSelectedIndex();
        showData(curIndex);
    }
    public void nextListItem()
    {
        if(curIndex < people.size() - 1)
            curIndex+=1;
        else 
            curIndex = 0;
        myList.getSelectionModel().select(curIndex);
        curIndex = myList.getSelectionModel().getSelectedIndex();
        showData(curIndex);
    }
    public void lastListItem()
    {
        curIndex = people.size() - 1;
        myList.getSelectionModel().select(curIndex);
        curIndex = myList.getSelectionModel().getSelectedIndex();
        showData(curIndex);
    }

    public void changeImage(Image image)
    {
        myImgView.setImage(image);
    }

    public void showDataInCLI()
    {
        System.out.println(people.get(myList.getSelectionModel().getSelectedIndex()));
    }
}
