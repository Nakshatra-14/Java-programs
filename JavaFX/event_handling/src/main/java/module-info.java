module com.example.nn {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.nn to javafx.fxml;
    exports com.example.nn;
}
