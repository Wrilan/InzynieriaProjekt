package app;

import java.io.IOException;

import app.entity.Patient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import app.entity.User;

public class App extends Application {

    public static User user;
    public static Patient patient;

    private static Scene scene;

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    @Override
    public void start(Stage stage) throws IOException {
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