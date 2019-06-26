package app.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.lowagie.text.DocumentException;

import app.App;
import app.dao.PatientDao;
import app.entity.Patient;
import app.utilities.Pdf;

public class DoctorPanelController {

    @FXML
    public ListView listView;
    public TextField fieldSearch;
    public Label loggedIn;

    private ListOfPatients listOfPatients;

    @FXML
    public void initialize() throws SQLException {
        listOfPatients = new ListOfPatients();

        loggedIn.setText("Lekarz: " + App.user.getFirstName() + " " + App.user.getLastName());

        fieldSearch.setOnKeyPressed(key -> {
            if (key.getCode().equals(KeyCode.ENTER)) {
                search();
            }
        });
    }

    @FXML
    public void search() {
        if(!listOfPatients.search(fieldSearch.getText())) {
            App.showAlert("Nie znaleziono pacienta o poadnym nr PESEL lub NIP", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void createFormCertificate() throws IOException {
        listOfPatients.selectItemFromList(listView.getSelectionModel().getSelectedIndex());
        System.out.println(App.patient.getId());
        App.setRoot("form_certificate");
    }

    @FXML
    public void generate() throws IOException, DocumentException {
        Pdf.generate("<h1>Hello World</h1>");
    }

    @FXML
    public void logout() throws IOException {
        App.setRoot("login");
    }


    public class ListOfPatients {

        public ObservableList data = FXCollections.observableArrayList();

        private ArrayList<Patient> patients;

        public ListOfPatients() throws SQLException {
            this.update();
        }

        public void update() throws SQLException {
            patients = new PatientDao().getPatients();
            for (Patient patient : patients) {
                String item = patient.getFullName();
                for(int a = 0; a < (30 - patient.getFullName().length()); a++) {
                    item += ' ';
                }
                item += patient.getPesel() + "            " + patient.getNip() + "            " + patient.getPhone();
                data.add(item);
            }
            listView.setItems(data);
            selectItemFromList(0);
        }

        public boolean search(String nr) {
            int index = 0;

            for (Patient patient : patients) {
                if(patient.getPesel().equals(nr) || patient.getNip().equals(nr)) {
                    this.selectItemFromList(index);
                    return true;
                }
                index++;
            }

            return false;
        }

        private void selectItemFromList(int id) {
            listView.getSelectionModel().select(id);
            listView.scrollTo(id);
            App.patient = patients.get(id);
        }
    }
}