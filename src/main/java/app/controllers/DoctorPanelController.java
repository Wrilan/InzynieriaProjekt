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
/**
 * @file DoctorPanelController.java
 * @brief Klasa zajmująca się obsługą panelu do doktora.
 * @details Klasa DoctorPanelController.java służy do obsługi panelu doktora,
 * w tym wyszukiwania pacjentów, tworzenia zwolnień i wylogowywania się z aplikacji.
 */
public class DoctorPanelController {

    @FXML
    public ListView listView;
    public TextField fieldSearch;
    public Label loggedIn;

    private ListOfPatients listOfPatients;

    /**
     * @throws SQLException
     * @details Metoda initialize() wywoływana jest do inicjalizacji kontrolera po całkowitym przetworzeniu elementu głównego.
     */
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

    /**
     * @details Metoda search() przeszukuje listę pacjentów i w przypadku braku danego pacjenta, wyświetlane jest okienku typu ERROR.
     */
    @FXML
    public void search() {
        if(!listOfPatients.search(fieldSearch.getText())) {
            App.showAlert("Nie znaleziono pacienta o poadnym nr PESEL lub NIP", Alert.AlertType.ERROR);
        }
    }

    /**
     * @throws IOException
     * @details Metoda createFormCertificate() wybiera zaznaczonego pacjenta, a następnie ustawia główny widok aplikacji na panel opisany w pliku form_certificate.fxml.
     */
    @FXML
    public void createFormCertificate() throws IOException {
        listOfPatients.selectItemFromList(listView.getSelectionModel().getSelectedIndex());
        System.out.println(App.patient.getId());
        App.setRoot("form_certificate");
    }

    /**
     * @throws IOException
     * @throws DocumentException
     * @details Metoda generate(), genetuje plik pdf.
     */
    @FXML
    public void generate() throws IOException, DocumentException {
        Pdf.generate("<h1>Hello World</h1>");
    }

    /**
     * @throws IOException
     * @details Metoda logout() ustawia główny widok aplikacji na początkowy panel logowania.
     */
    @FXML
    public void logout() throws IOException {
        App.setRoot("login");
    }


    /**
     * @file DoctorPanelController.java
     * @brief Klasa składująca dane pacjentów w liście.
     * @details Klasa ListOfPatients składuje dane pacjentów w liście typu ArrayList i interpretuje ją na typ ObservableList.
     */
    public class ListOfPatients {

        public ObservableList data = FXCollections.observableArrayList();

        private ArrayList<Patient> patients;

        /**
         * @throws SQLException
         * @details Konstruktor klasy ListOfPatients.
         */
        public ListOfPatients() throws SQLException {
            this.update();
        }

        /**
         * @throws SQLException
         * @details Metoda update() zajmuje się oddzielaniem danych pacjentów, wrzucaniem ich do listy by na końcu ustawić, by pierwszy pacjent był zaznaczony domyślnie.
         */
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

        /**
         * @param nr Numer pesel lub nip do wyszukania.
         * @return Metoga zwraca wartość true jeśli pacjent o podanym numerze zostanie znaleziony lub false gdy takowy nie istnieje w bazie danych.
         * @ Metoda search() zajmuje się wyszukiwaniem pacjenta po jego numerach nip lub pesel by następnie zwrócić zmienną typu boolean w zależności, czy pacjent został znaleziony lub nie.
         */
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

        /**
         * @param id Id pacjenta
         * @details Metoda selectItemFromList() filtruje listę pacjentów, tak by widoczny był jedynie wyszukany pacjent a następnie przekazuje go do App.patient.
         */
        private void selectItemFromList(int id) {
            listView.getSelectionModel().select(id);
            listView.scrollTo(id);
            App.patient = patients.get(id);
        }
    }
}