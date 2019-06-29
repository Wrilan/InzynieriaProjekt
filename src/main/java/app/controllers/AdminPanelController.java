package app.controllers;

import javafx.fxml.FXML;

import java.io.IOException;

import app.App;

/**
 * @file AdminPanelController.java
 * @brief Klasa zajmująca się obsługą panelu administratora.
 */
public class AdminPanelController {
    /**
     * @details Wywoływany do inicjalizacji kontrolera po całkowitym przetworzeniu elementu głównego.
     */
    @FXML
    public void initialize() {
    }

    /**
     * @throws IOException
     * @details Metoda logout() ustawia główny widok aplikacji na początkowy panel logowania.
     */
    @FXML
    public void logout() throws IOException {
        App.setRoot("login");
    }
}