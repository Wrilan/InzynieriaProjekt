package app.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.fxml.FXML;

import app.App;
import app.dao.UserDao;
import app.utilities.Hash;

/**
 * @file LoginController.java
 * @brief Klasa zajmująca się obsługą panelu logowania.
 * @details Klasa LoginController.java zajmuje się obsługą panelu logowania, w tym jego inicjalizacją i przeprowadzaniem logowania.
 */
public class LoginController {

    @FXML
    public TextField fieldTechId;
    public TextField fieldPassword;

    /**
     * @details Metoda initialize() wywoływana jest do inicjalizacji kontrolera po całkowitym przetworzeniu elementu głównego dla wybranego pacjenta.
     */
    @FXML
    public void initialize() {
        fieldTechId.setText("10000");
        fieldPassword.setText("test");

        fieldTechId.setOnKeyPressed(key -> {
            if (key.getCode().equals(KeyCode.ENTER)) {
                login();
            }
        });

        fieldPassword.setOnKeyPressed(key -> {
            if (key.getCode().equals(KeyCode.ENTER)) {
                login();
            }
        });
    }

    /**
     * @details Metoda login() obsługuje logowanie się do aplikacji.
     */
    @FXML
    public void login() {
        try {
            App.user = new UserDao().getUser(Integer.parseInt(fieldTechId.getText()));

            if (App.user.getPassword().equals(Hash.sha256(fieldPassword.getText()))) {
                if(App.user.getRole() == 0) {
                    App.setRoot("admin_panel");
                } else {
                    App.setRoot("doctor_panel");
                }

                return;
            }
        } catch (Exception e) {
            App.showAlert("Podany identyfikator lub hasło jest nieprawidłowe", Alert.AlertType.ERROR);
            System.out.println("Error: " + e);
            return;
        }

        App.showAlert("Podany identyfikator lub hasło jest nieprawidłowe", Alert.AlertType.ERROR);
    }
}