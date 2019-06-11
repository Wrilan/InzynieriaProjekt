package app.controllers;

import javafx.fxml.FXML;

import java.io.IOException;

import com.lowagie.text.DocumentException;

import app.App;
import app.utilities.Pdf;

public class PanelController {

    @FXML
    public void generate() throws IOException, DocumentException {
        Pdf.generate("<h1>Hello World</h1>");
    }

    @FXML
    public void logout() throws IOException {
        App.setRoot("login");
    }
}