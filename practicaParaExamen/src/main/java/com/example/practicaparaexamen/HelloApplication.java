package com.example.practicaparaexamen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("App.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 340);
        stage.setTitle("Practica para Examen : Apreza Gutierrez Carlos");
        stage.setScene(scene);
        stage.show();
    }
}
