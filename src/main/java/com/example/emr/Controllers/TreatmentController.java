package com.example.emr.Controllers;

import com.example.emr.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TreatmentController implements Initializable {

    public Text diagCode_text;
    public Text appointDate_text;

    @FXML
    public Label diagCode_label;
    @FXML
    public Label appointDate_label;
    public ImageView procedureFrame;
    @FXML
    public ImageView image_add;
    @FXML
    public ImageView generateSum_Btn;


    private String diagnosis;

    //get diag code from diagnosis page
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        diagCode_label.setText("the code leh");
        image_add.setOnMouseClicked(mouseEvent -> {
            try {
                new ViewModel().showProcedureForm();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    //to get the diagnosis code from diag controller
    public void updateLabelText(String diagnosis) {
        this.diagnosis = diagnosis;
        // it's printing out the value tho, but not coming out on label
        System.out.println(diagnosis);
        //setLabelText();
    }

    /*private void setLabelText() {
        diagCode_label.setText(diagnosis);
    }*/
}

    // Update diagnose code to be passed to procedure -> diag code
    /*public void String (String text) {
        diagCode_label.setText(text);
    }

}*/
