package app.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.util.StringConverter;
import javafx.fxml.FXML;

import app.App;
import app.dao.CertificateDao;
import app.entity.Certificate;

/**
 * @file FormCertificateController.java
 * @brief Klasa zajmująca się obsługą panelu do wystawiania zwolnień.
 * @details Klasa FormCertificateController.java służy do obsługi panelu od wystawiania zwolnień,
 * w tym ustawiania pól to uzupełnienia, wysyłania zwolnienia i wylogowywania się z aplikacji.
 */
public class FormCertificateController {

    @FXML
    public TextField fieldFullName;
    public TextField fieldDateBirth;
    public TextField fieldPesel;
    public TextField fieldNip;
    public TextField fieldDateRelease;
    public TextField fieldCode;
    public DatePicker fieldDateFrom;
    public DatePicker fieldDateTo;
    public ComboBox fieldType;

    /**
     * @throws SQLException
     * @details Metoda initialize() wywoływana jest do inicjalizacji kontrolera po całkowitym przetworzeniu elementu głównego dla wybranego pacjenta.
     */
    @FXML
    public void initialize() throws SQLException {
        fieldFullName.setText(App.patient.getFullName());
        fieldDateBirth.setText(App.patient.getDateBirth());
        fieldPesel.setText(App.patient.getPesel());
        fieldNip.setText(App.patient.getNip());
        fieldDateRelease.setText(datePickrConverter("yyyy-MM-dd").toString(LocalDate.now()));
        fieldType.setItems(FXCollections.observableArrayList("L4", "L10"));
        fieldDateFrom.setConverter(datePickrConverter("yyyy-MM-dd"));
        fieldDateTo.setConverter(datePickrConverter("yyyy-MM-dd"));
    }

    /**
     * @throws Exception
     * @details Metoda send() wysyła zwolnienie pacjenta a następnie wyświela okienko informujące, czy przeprowadzana operacja się udała.
     */
    @FXML
    public void send() throws Exception {

        try {
            int type = 0;

            if (fieldType.getValue() == "L4") {
                type = 1;
            } else if (fieldType.getValue() == "L10") {
                type = 2;
            }

            if (CertificateDao.setCertificate(new Certificate(0, App.patient.getId(), fieldDateRelease.getText(),
                    fieldDateFrom.getValue().toString(), fieldDateTo.getValue().toString(),
                    type, Integer.parseInt(fieldCode.getText())))) {
                App.showAlert("Zwolnienie zostało wysłane", Alert.AlertType.INFORMATION);
                App.setRoot("doctor_panel");
            } else {
                App.showAlert("Błąd wysyłania zwolnienia", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            App.showAlert("Niepoprawnie wypełnione pola", Alert.AlertType.ERROR);
        }
    }

    /**
     * @throws IOException
     * @details Metoda back() ustawia główny widok aplikacji na ten opisany w pliku doctor_panel.fxml.
     */
    @FXML
    public void back() throws IOException {
        App.setRoot("doctor_panel");
    }

    /**
     * @param format Format daty.
     * @return Medota zwraca datę zwolnienia.
     * @detasils Metoda datePickrConverter() umożliwia użytkownikowi wybranie daty, która następnie jest zwracana w formie LocalDate.
     */
    public StringConverter<LocalDate> datePickrConverter(String format) {
        return new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

            @Override
            public String toString(LocalDate localDate) {
                if(localDate == null) {
                    return "";
                }

                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if(dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }

                return LocalDate.parse(dateString,dateTimeFormatter);
            }
        };
    }
}