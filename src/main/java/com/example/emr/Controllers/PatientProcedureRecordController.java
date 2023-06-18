package com.example.emr.Controllers;

import com.example.emr.PatientProcHandler;
import com.example.emr.PatientProcedureRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PatientProcedureRecordController implements Initializable {
    @FXML
    public TableView<PatientProcedureRecord> table_procedure;
    @FXML
    private TableColumn<PatientProcedureRecord, String> codeColumn;
    @FXML
    private TableColumn<PatientProcedureRecord, String> dateColumn;
    @FXML
    private TableColumn<PatientProcedureRecord, String> descriptionColumn;
    @FXML
    private TableColumn<PatientProcedureRecord, String> priceColumn;
    public Label code_label; //set as not visible, just for reference purpose
    @FXML
    public Button saveBtn;
    @FXML
    public AnchorPane procedureForm;

    private PatientProcHandler pph = new PatientProcHandler();

    private List<PatientProcedureRecord> searchList = new ArrayList<>();

    private String searchString = "";
    private String diagnosis;
    private ObservableList<PatientProcedureRecord> observableArrayList = FXCollections.observableArrayList();

    public void setProcedureItems(ObservableList<PatientProcedureRecord> items) {
        table_procedure.setItems(items);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayProcedures();
        saveBtn.setOnAction(e -> {
            try {
                createPatientProcedure();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    // Compare whether the first data in csv matches the data
    // It should be used when clicked add at treatment page
    // Display patient proc based on code into table
    public PatientProcedureRecord searchProcCode(String diagnosis) {
        this.diagnosis = diagnosis;
        searchString = diagnosis; // pass selected code diag form

        searchList = pph.readFixedProc(PatientProcedureRecord.filename_fixedP);
        // Search for the procedure code based on the diagnosis
        for (PatientProcedureRecord record : searchList) {
            if (record.getProcedure_code() != null && record.getProcedure_code().equals(searchString)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Procedures found!");
                return record;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText("No such procedure exists");
        return null; // Return null if no matching procedure code is found
    }

    private void createPatientProcedure() throws IOException {
        PatientProcedureRecord procedureRecord = searchProcCode(diagnosis);
        if (procedureRecord != null) {
            pph.create(procedureRecord);

            // Notify the user that the data has been saved
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Info saved");
            alert.show();
        } else {
            // Execute when the record doesn't exist
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Record doesn't exist");
            alert.show();
        }
    }

    // To instantly show the data
    public void displayProcedures() {
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        List<PatientProcedureRecord> procedureRecords = pph.readFixedProc(PatientProcedureRecord.filename_fixedP);
        observableArrayList.setAll(procedureRecords);
        table_procedure.setItems(observableArrayList);
    }
}

