package app.controllers;

import javafx.fxml.FXML;

import java.io.IOException;

import app.App;

public class FormL10Controller {

    @FXML
    public void send() throws IOException {
        App.setRoot("doctor_panel");
    }
}