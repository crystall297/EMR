module com.example.emr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.emr to javafx.fxml;
    exports com.example.emr;
}