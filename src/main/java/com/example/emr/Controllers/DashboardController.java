package com.example.emr.Controllers;

import com.example.emr.PatientAccHandler;
import com.example.emr.PatientRecord;
import com.example.emr.ViewModel;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public ImageView patientprofile;
    public ImageView menu;
    public ImageView patientProfile;
    public ImageView home;
    public Pane LivePatientPane;
    public javafx.scene.chart.LineChart LineChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setOnMouseClicked(mouseEvent -> {
            try {
                ViewModel.getPatientRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        inLineChart();
    }

        private void inLineChart(){
            PatientAccHandler patientAccHandler = new PatientAccHandler();
            List<PatientRecord> patientRecords = patientAccHandler.readCSV(PatientRecord.filename);
            LineChart.getXAxis().setLabel("Date Of Admission");
            LineChart.getYAxis().setLabel("Number of Patients");
            LineChart.setTitle("Live Patient Count");
            Map<String, Integer> doaCounter = new HashMap<>();

            for (PatientRecord patientRecord : patientRecords) {
                String date = patientRecord.getP_Doa();
                // The counter will increment following the date//
                doaCounter.put(date, doaCounter.getOrDefault(date, 0) + 1);
            }

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            for (Map.Entry<String, Integer> entry : doaCounter.entrySet()) {
                String date = entry.getKey();
                int count = entry.getValue();
                series.getData().add(new XYChart.Data<>(date, count));
            }
            LineChart.getData().add(series);
    }
}
