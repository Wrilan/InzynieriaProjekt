package app.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

import app.App;

/**
 * @file FormL4Controller.java
 * @details Kasa FormL4Controller.java odpowiadaja za ustawienie widoku głównego aplikacji na panel odpowiadający typowi użytkownika jakim jest doktor.
 * Widok panelu opisany jest w pliku doctor_panel.fxml.
 * @brief  Klasa odpowiadająca za ustawienie widoku dla doktora.
 */
public class FormL4Controller {
    /**
     * @details Metoda send() ustawia główny widok aplikacji na panel opisany w pliku doctor_panel.fxml.
     * @throws IOException
     */
    @FXML
    public void send() throws IOException {
        App.setRoot("doctor_panel");
    }
}