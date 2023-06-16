package com.example.emr.ActionCells;

import com.example.emr.PatientAccHandler;
import com.example.emr.PatientRecord;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import java.io.IOException;

public class ActionCell extends TableCell<PatientRecord,Void> {
    private final Button deleteButton;

    public ActionCell() {
        deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            PatientRecord rowData = getTableRow().getItem();
            getTableView().getItems().remove(rowData);
            PatientAccHandler pah = new PatientAccHandler();
            try {
                pah.delete(rowData.getP_Ic(),PatientRecord.filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(deleteButton);
        }
    }
}