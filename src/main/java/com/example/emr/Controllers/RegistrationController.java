package com.example.emr.Controllers;
;import com.example.emr.PatientAccHandler;
import com.example.emr.PatientRecord;
import com.example.emr.ViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.Optional;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {
    public Label label_name;
    public TextField textfield_name;
    public Label label_icno;
    public TextField textfield_icno;
    public Label label_DOB;
    public TextField textfield_dob;
    public Label label_gender2;
    public ChoiceBox Choicebox_gender;
    public Label Address_label;
    public TextField textfield_address;
    public Label label_allergies;
    public ChoiceBox ChoiceBox_allergies;
    public Label label_dateofadmission;
    public TextField textfield_dateofadmission;
    public Label label_pastmedicalrecord;
    public TextField textfield_pastmedicalrecord;
    public Button submit_Btn;
    public ImageView image_imageview;
    public Label label_uploadimage;
    public AnchorPane registration_form;
    public String[] gender = {"male","female"};
    public String[] allergies = {"nuts","dairy products","seafood","pineapple","NONE"};
    public TextArea textarea_pmr;

    public class registrationController {
        @FXML
        private Label Address_label;

        @FXML
        private ChoiceBox<?> ChoiceBox_allergies;

        @FXML
        private ChoiceBox<?> Choicebox_gender;

        @FXML
        private ImageView image_imageview;

        @FXML
        private Label label_DOB;

        @FXML
        private Label label_allergies;

        @FXML
        private Label label_dateofadmission;

        @FXML
        private Label label_gender2;

        @FXML
        private Label label_icno;

        @FXML
        private Label label_name;

        @FXML
        private Label label_pastmedicalrecord;

        @FXML
        private Label label_uploadimage;

        @FXML
        private Rectangle rectangle_image;

        @FXML
        private AnchorPane registration_form;

        @FXML
        private Button submit_Btn;

        @FXML
        private TextField textfield_address;

        @FXML
        private TextField textfield_dateofadmission;

        @FXML
        private TextField textfield_dob;

        @FXML
        private TextField textfield_icno;

        @FXML
        private TextField textfield_name;

        @FXML
        private TextField textfield_pastmedicalrecord;

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Choicebox_gender.getItems().addAll(gender);
        ChoiceBox_allergies.getItems().addAll(allergies);

        submit_Btn.setOnAction(e-> {
            try {
                createPatient();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    private void createPatient() throws IOException {
        String ic = textfield_icno.getText();
        String name = textfield_name.getText();
        String dob = textfield_dob.getText();
        String address = textfield_address.getText();
        String doa = textfield_dateofadmission.getText();
        String gender = (String) Choicebox_gender.getValue();
        String allergies = (String) ChoiceBox_allergies.getValue();
        String pmr = textarea_pmr.getText();
        PatientRecord patientRecord = new PatientRecord(name,ic,dob,gender,address,allergies,doa,pmr);
        PatientAccHandler pah = new PatientAccHandler();
        pah.create(patientRecord);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("Info saved");
        Optional<ButtonType> option_btn = alert.showAndWait();
    }
}
