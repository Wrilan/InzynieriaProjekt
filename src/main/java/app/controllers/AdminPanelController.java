package app.controllers;

import javafx.fxml.FXML;

import java.io.IOException;

import app.App;

public class AdminPanelController {

    @FXML
    public void initialize() {
    }

    @FXML
    public void logout() throws IOException {
        App.setRoot("login");
    }
}