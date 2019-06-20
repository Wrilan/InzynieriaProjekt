package app.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.lowagie.text.DocumentException;

import app.App;
import app.dao.PatientDao;
import app.entity.Patient;
import app.utilities.Pdf;

public class DoctorPanelController {

    @FXML
    public Label loggedIn;
    public ListView listOfPatients;
    public ObservableList data = FXCollections.observableArrayList();

    private ArrayList<Patient> patients;

    @FXML
    public void initialize() throws SQLException {
        patients = new PatientDao().getPatients();

        for (Patient patient : patients) {
            data.add(patient.getFullName());
        }

        listOfPatients.setItems(data);

        loggedIn.setText("Zalogowany: " + App.user.getFirstName() + " " + App.user.getLastName());
    }

    @FXML
    public void createForm() throws IOException {
        //System.out.println(listOfPatients.getSelectionModel().getSelectedIndex());
        //listOfPatients.scrollTo(5);
        App.setRoot("form");
    }

    @FXML
    public void generate() throws IOException, DocumentException {
        Pdf.generate("<h1>Hello World</h1>");
    }

    @FXML
    public void logout() throws IOException {
        App.setRoot("login");
    }
}