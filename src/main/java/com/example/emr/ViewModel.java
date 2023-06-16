package com.example.emr;

import com.example.emr.Controllers.DiagnosisController;
import com.example.emr.Controllers.pProfileController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewModel {
    public AnchorPane PatientRecord;
    public static TabPane tabPane;

    public static Stage stage;


    public ViewModel() {
        tabPane = new TabPane();
        stage = new Stage();
    }

    public void getPatientRecord() {
        if (PatientRecord == null) {
            try {
                FXMLLoader patientRecord = new FXMLLoader(getClass().getResource("/com/example/emr/pForm.fxml"));
                Parent my_root = patientRecord.load();
                Stage stage = new Stage();
                stage.setTitle("PatientRecord");
                stage.setScene(new Scene(my_root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showRegistrationForm() throws IOException {
        try {
            FXMLLoader R_form = new FXMLLoader(getClass().getResource("/com/example/emr/registrationform.fxml"));
            Parent r_root = R_form.load();
            Stage stage = new Stage();
            stage.setTitle("RegistrationForm");
            stage.setScene(new Scene(r_root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showPatientProfile(com.example.emr.PatientRecord rowData) {
        try {
            FXMLLoader patientProfile = new FXMLLoader(ViewModel.class.getResource("/com/example/emr/pProfile_doc.fxml"));
            //Parent my_root = (Parent) patientProfile.load();
            AnchorPane profile_pane = patientProfile.load();
            pProfileController controller = patientProfile.getController();
            controller.displayinfo(rowData);
            Scene newScene = new Scene(profile_pane);
            stage.setScene(newScene);
            stage.setTitle("Patient Profile");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void showDiagnosisForm(com.example.emr.PatientRecord rowData) {
        try {
            FXMLLoader diagnosis_loader = new FXMLLoader(ViewModel.class.getResource("/com/example/emr/Diagnosis.fxml"));
            AnchorPane diagnosis_pane = diagnosis_loader.load();
            DiagnosisController diagnosisController = diagnosis_loader.getController();
            diagnosisController.creatediagnosis(rowData);
            Scene newScene = new Scene(diagnosis_pane);
            stage.setScene(newScene);
            stage.setTitle("Patient Profile");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
