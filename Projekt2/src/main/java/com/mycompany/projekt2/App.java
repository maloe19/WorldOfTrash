package com.mycompany.projekt2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.TextArea;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static TextArea console;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainmenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
        console = new TextArea();
    }
    
    public static TextArea getConsole() {
        return console;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Game g = new Game();
    
    
    
    public static void load(String[] args) {
        launch();
    }

}