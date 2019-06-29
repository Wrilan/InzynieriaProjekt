package app.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lowagie.text.DocumentException;

import app.App;
import app.dao.CertificateDao;
import app.entity.Certificate;
import app.utilities.Pdf;

public class HistoryCertificatesController {

    @FXML
    public ListView listView;

    public ListOfCertificates listOfCertificates;

    @FXML
    public void initialize() throws SQLException {
        listOfCertificates = new ListOfCertificates();
    }

    @FXML
    public void generate() throws IOException, DocumentException {
        Certificate certificate = listOfCertificates.getSelected();
        if(certificate == null) {
            App.showAlert("Brak zwolnienia do eksportu", Alert.AlertType.ERROR);
            return;
        }

        String pdf = "";
        String type = "";

        if(certificate.getType() == 1) {
            type = "L4 ";
        } else if(certificate.getType() == 2) {
            type = "L10";
        }

        pdf += "<div>";
        pdf += "<div style=\"width: 100%; text-align: center;\"><h3>Zwolnienie " + type + "</h3></div>";
        pdf += "<p>Imie i nazwisko: " + App.patient.getFullName() + "</p>";
        pdf += "<p>Data urodzenia: " + App.patient.getDateBirth() + "</p>";
        pdf += "<p>Numer Pesel: " + App.patient.getPesel() + "</p>";
        pdf += "<p>Numer Nip: " + App.patient.getNip() + "</p>";
        pdf += "<p>Data wystawienia: " + certificate.getDateRelease() + "</p>";
        pdf += "<p>Okres zwolnienia: " + certificate.getDateFrom() + " - " + certificate.getDateTo() + "</p>";
        pdf += "<div style=\"width: 100%; text-align: right;\">Lekarz wystawiajacy:    <br/><p>" + App.user.getFirstName() + " " + App.user.getLastName() + "</p>";
        pdf += "<p>Identyfikator: " + App.user.getTechId() + "</p></div>";
        pdf += "</div>";

        Pdf.generate(pdf);
    }

    @FXML
    public void back() throws IOException {
        App.setRoot("doctor_panel");
    }

    public class ListOfCertificates {

        public ObservableList data = FXCollections.observableArrayList();

        private ArrayList<Certificate> certificates;

        public ListOfCertificates() throws SQLException {
            this.update();
            this.initialSelect();
        }

        public void initialSelect() {
            listView.getSelectionModel().select(0);
            listView.scrollTo(0);
        }

        public void update() throws SQLException {
            certificates = new CertificateDao().getCertificates(App.patient.getId());
            String item;
            String type;
            String tab = "            ";
            for (Certificate certificate : certificates) {
                item = "";
                type = "";

                if(certificate.getType() == 1) {
                    type = "L4    ";
                } else if(certificate.getType() == 2) {
                    type = "L10   ";
                }
                item += certificate.getDateRelease() + tab;
                item += type + tab;
                item += certificate.getDateFrom() + tab;
                item += certificate.getDateTo() + tab;
                item += certificate.getCode();
                this.data.add(item);
            }
            listView.setItems(data);
        }

        public Certificate getSelected() {
            if(listView.getSelectionModel().getSelectedIndex() < 0) {
                return null;
            }
            return certificates.get(listView.getSelectionModel().getSelectedIndex());
        }
    }
}