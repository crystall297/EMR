package com.example.emr.Controllers;

import com.example.emr.PatientRecord;
import com.example.emr.ViewModel;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class pProfileController implements Initializable {
    public Rectangle rectangle_image;
    public Label label_name1;
    public Label label_pastmedicalrecord1;
    public Label label_dob1;
    public Label label_anyallergies1;
    public Label label_gender1;
    public Label label_dateofadmission1;
    public Label label_address1;
    public Tab analysis_tab;
    public Tab diagnosis_tab;
    public Button diagnosis_button;

    private PatientRecord rowData;
    public static class profileController {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        diagnosis_tab.setOnSelectionChanged(Event  -> {
            ViewModel.showDiagnosisForm(rowData);
        });
    }
    public void displayinfo(PatientRecord rowData){
        this.rowData = rowData;
        label_name1.setText(rowData.getP_Name());
        label_dob1.setText(rowData.getP_Dob());
        label_address1.setText(rowData.getP_Address());
        label_anyallergies1.setText(rowData.getP_Allergies());
        label_dateofadmission1.setText(rowData.getP_Doa());
        label_gender1.setText(rowData.getP_Gender());
        label_pastmedicalrecord1.setText(rowData.getP_Pmr());
    }

}
