package app.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.fxml.FXML;

import java.sql.ResultSet;

import app.App;
import app.utilities.Database;
import app.utilities.Hash;

public class LoginController {

    @FXML
    public TextField fieldId;
    public TextField fieldPassword;

    @FXML
    public void initialize() {
        fieldId.setOnKeyPressed(key -> {
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

    @FXML
    public void login() {
        try {
            ResultSet result = Database.query("SELECT * FROM users WHERE id=" + Integer.parseInt(fieldId.getText()));

            while (result.next()) {
                if (result.getString("password").equals(Hash.sha256(fieldPassword.getText()))) {
                    App.setRoot("panel");
                    return;
                }
            }
        } catch (Exception e) {
            showError();
            return;
        }

        showError();
    }

    private void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Komunikat logowania");
        alert.setHeaderText("Podany identyfikator lub hasło jest nieprawidłowe");
        alert.showAndWait();
    }
}