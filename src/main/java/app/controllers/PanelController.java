package app.controllers;

import javafx.fxml.FXML;

import java.io.IOException;

import app.App;

public class PanelController {

    @FXML
    public void logout() throws IOException {
        App.setRoot("login");
    }
}