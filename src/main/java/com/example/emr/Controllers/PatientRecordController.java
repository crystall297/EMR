package com.example.emr.Controllers;

import com.example.emr.ActionCells.ActionCell;
import com.example.emr.ActionCells.ActionCell2;
import com.example.emr.PatientAccHandler;
import com.example.emr.PatientRecord;
import com.example.emr.ViewModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;

public class PatientRecordController implements Initializable {

    public Button updatebtn;
    public Button button_patient;
    public ImageView image_patient;
    public Button button_user;
    public ImageView image_user;
    public Button button_default;
    public ImageView image_default;
    public TextField searchbar;
    public TableView<com.example.emr.PatientRecord> table_patient;
    public ImageView add_Btn;

    private List<com.example.emr.PatientRecord> patients = new ArrayList<>();


    public class PatientRecord {

        @FXML
        private ImageView addbtn;

        @FXML
        private Button button_default;

        @FXML
        private Button button_user;

        @FXML
        private ImageView menu_image;

        @FXML
        private ImageView image_patient;

        @FXML
        private ImageView image_user;

        @FXML
        private TextField searchbar;

        @FXML
        private TableView<com.example.emr.PatientRecord> table_patient;

        @FXML
        private Button updatebtn;
        @FXML
        private AnchorPane main_patientform;

        private List<com.example.emr.PatientRecord> searchList = new ArrayList<>();
        private String searchString = "";


        public void logout() {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Confirm to Logout?");
            Optional<ButtonType> option_btn = alert.showAndWait();
        }

        public void close() {
            System.exit(0);
        }

        public void minimize() {
            Stage stage = (Stage) main_patientform.getScene().getWindow();
            stage.setIconified(true);
        }
    }
    ObservableList<com.example.emr.PatientRecord> observableArrayList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PatientAccHandler pah = new PatientAccHandler();
        table_patient.setEditable(true);

        TableColumn<com.example.emr.PatientRecord, String> name = new TableColumn<>("name");
        name.setCellValueFactory(new PropertyValueFactory<com.example.emr.PatientRecord, String>("p_Name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(event -> {
            com.example.emr.PatientRecord patient = event.getRowValue();
            patient.setP_Name(event.getNewValue());

            // Update the CSV file with the new values
            updateCSV(observableArrayList);
        });

        TableColumn<com.example.emr.PatientRecord, String> ic = new TableColumn<com.example.emr.PatientRecord, String>("ic");
        ic.setCellValueFactory(new PropertyValueFactory<com.example.emr.PatientRecord, String>("p_Ic"));
        ic.setCellFactory(TextFieldTableCell.forTableColumn());
        ic.setOnEditCommit(event -> {
            com.example.emr.PatientRecord patient = event.getRowValue();
            patient.setP_Ic(event.getNewValue());

            // Update the CSV file with the new values
            updateCSV(observableArrayList);
        });

        TableColumn<com.example.emr.PatientRecord, String> dob = new TableColumn<>("dob");
        dob.setCellValueFactory(new PropertyValueFactory<com.example.emr.PatientRecord, String>("p_Dob"));
        dob.setCellFactory(TextFieldTableCell.forTableColumn());
        dob.setOnEditCommit(event -> {
            com.example.emr.PatientRecord patient = event.getRowValue();
            patient.setP_Dob(event.getNewValue());

            // Update the CSV file with the new values
            updateCSV(observableArrayList);
        });

        TableColumn<com.example.emr.PatientRecord, String> gender = new TableColumn<com.example.emr.PatientRecord, String>("gender");
        gender.setCellValueFactory(new PropertyValueFactory<com.example.emr.PatientRecord, String>("p_Gender"));
        gender.setCellFactory(TextFieldTableCell.forTableColumn());
        gender.setOnEditCommit(event -> {
            com.example.emr.PatientRecord patient = event.getRowValue();
            patient.setP_Gender(event.getNewValue());

            // Update the CSV file with the new values
            updateCSV(observableArrayList);
        });

        TableColumn<com.example.emr.PatientRecord, String> address = new TableColumn<>("address");
        address.setCellValueFactory(new PropertyValueFactory<com.example.emr.PatientRecord, String>("p_Address"));
        address.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setOnEditCommit(event -> {
            com.example.emr.PatientRecord patient = event.getRowValue();
            patient.setP_Address(event.getNewValue());

            // Update the CSV file with the new values
            updateCSV(observableArrayList);
        });

        TableColumn<com.example.emr.PatientRecord, String> allergies = new TableColumn<>("allergies");
        allergies.setCellValueFactory(new PropertyValueFactory<com.example.emr.PatientRecord, String>("p_Allergies"));
        allergies.setCellFactory(TextFieldTableCell.forTableColumn());
        allergies.setOnEditCommit(event -> {
            com.example.emr.PatientRecord patient = event.getRowValue();
            patient.setP_Allergies(event.getNewValue());

            // Update the CSV file with the new values
            updateCSV(observableArrayList);
        });

        TableColumn<com.example.emr.PatientRecord, String> doa = new TableColumn<com.example.emr.PatientRecord, String>("doa");
        doa.setCellValueFactory(new PropertyValueFactory<com.example.emr.PatientRecord, String>("p_Doa"));
        doa.setCellFactory(TextFieldTableCell.forTableColumn());
        doa.setOnEditCommit(event -> {
            com.example.emr.PatientRecord patient = event.getRowValue();
            patient.setP_Doa(event.getNewValue());

            // Update the CSV file with the new values
            updateCSV(observableArrayList);
        });

        TableColumn<com.example.emr.PatientRecord, String> pmr = new TableColumn<com.example.emr.PatientRecord, String>("pmr");
        pmr.setCellValueFactory(new PropertyValueFactory<com.example.emr.PatientRecord, String>("p_Pmr"));
        pmr.setCellFactory(TextFieldTableCell.forTableColumn());
        pmr.setOnEditCommit(event -> {
            com.example.emr.PatientRecord patient = event.getRowValue();
            patient.setP_Name(event.getNewValue());

            // Update the CSV file with the new values
            updateCSV(observableArrayList);
        });

        //delete & view action cell//
        TableColumn<com.example.emr.PatientRecord, Void> delete = new TableColumn<>("delete");
        delete.setCellFactory(column -> new ActionCell(observableArrayList));

        TableColumn<com.example.emr.PatientRecord, Void> view = new TableColumn<>("view_text");
        view.setCellFactory(column -> new ActionCell2());

        table_patient.getColumns().addAll(name, ic, dob, gender, address, allergies, doa, pmr, delete, view);

        //ObservableList<com.example.emr.PatientRecord> observableArrayList = FXCollections.observableArrayList(pah.readCSV(com.example.emr.PatientRecord.filename));
        //To allow the data to appear back to the tableview//
        observableArrayList.addAll(pah.readCSV(com.example.emr.PatientRecord.filename));
        table_patient.setItems(observableArrayList);

        Thread readFile = new Thread(() -> {
            while (true) {
                List<com.example.emr.PatientRecord> updated_data = pah.readCSV(com.example.emr.PatientRecord.filename);
                Platform.runLater(() -> {
                    observableArrayList.clear();
                    observableArrayList.addAll(updated_data);
                    table_patient.refresh();
                });

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        readFile.setDaemon(true); // Set the thread as a daemon thread (optional)
        readFile.start();

        add_Btn.setOnMouseClicked(mouseEvent -> {
            try {
                new ViewModel().showRegistrationForm();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        searchPatient();

    }

    private void searchPatient() {
        FilteredList<com.example.emr.PatientRecord> filterdata = new FilteredList<>(observableArrayList, e-> true);
        searchbar.setOnKeyReleased(e -> {
            searchbar.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filterdata.setPredicate((Predicate<? super com.example.emr.PatientRecord>) pat-> {
                    if (newValue == null) {
                        return true;
                    }
                    String toLowerCaseFilter = newValue.toLowerCase();
                    if (pat.getP_Ic().contains(newValue)) {
                        return true;
                    } else if (pat.getP_Name().toLowerCase().contains(toLowerCaseFilter)) {
                        return true;
                    } else return pat.getP_Doa().toLowerCase().contains(toLowerCaseFilter);
                });
            });
            SortedList<com.example.emr.PatientRecord> sortedData = new SortedList<>(filterdata);
            sortedData.comparatorProperty().bind(table_patient.comparatorProperty());

            // Set the sorted and filtered data to the table view
            table_patient.setItems(sortedData);
        });
    }

    public void updateCSV(List<com.example.emr.PatientRecord> records) {
        try {
            PatientAccHandler pah = new PatientAccHandler();
            pah.writeCSV(records, com.example.emr.PatientRecord.filename);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

}
