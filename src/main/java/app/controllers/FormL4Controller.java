package app.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

import app.App;

public class FormL4Controller {

    @FXML
    public void send() throws IOException {
        App.setRoot("doctor_panel");
    }
}