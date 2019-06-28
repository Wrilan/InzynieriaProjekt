package app;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import app.entity.Patient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import app.entity.User;
/**
 * \mainpage Opis aplikacji
 *  LZA System został stwrzony na zlecenie Narodowego Funduszu Zdrowia służy do wystawiania zwolnień lekarskich a następnie wysyłania ich do pracodawców obslugiwanych pacjentów.
 *
 * Możliwe rodzaje zwolnień:<br/>
 * L4 - Zwolnienie z powodu choroby pracownika.<br/>
 * L10 - Zwolnienie z powodu choroby członka rodziny pracownika.
 */
/**
 * @file App.java
 * @details Kasa App.java odpowiadaja za uruchamianie aplikacji, tworzenie sceny, wyświetlanie errorów oraz łączenie z plikami fxml.
 * @brief  Klasa główna.
 */
public class App extends Application {

    public static User user;
    public static Patient patient;

    private static Scene scene;

    /**
     * @details Metoda showAlert() odpowiada za wyświetlenie okienka opisującego błąd który się wydarzył.
     * @param text Tekst błędu do wyświetlenia w wyskakującym okienku.
     * @param type AlertType - Typ okienka do wyświetlenia.
     */
    public static void showAlert(String text, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("");
        alert.setHeaderText(text);
        alert.showAndWait();
    }

    /**
     * Metoda loadFXML() załadowuje widok aplikacji opisany w zapewnionym pliku fxml.
     * @param fxml Plik fxml opisujący widok aplikacji.
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * @details Metoda setRoot() definiuje główny widok na podstawie zapewnionego pliku fxml.
     * @param fxml Plik fxml opisujący widok aplikacji.
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * @details Główny punkt wejścia dla wszystkich aplikacji JavaFX.
     * @param stage Primary Stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println( sdf.format(cal.getTime()));
        System.out.println(System.currentTimeMillis());

        scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
        stage.setTitle("LZA System");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}