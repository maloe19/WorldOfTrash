package com.mycompany.projekt2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class App extends Application {
// Attributes - Making variables for App class

    private static Scene scene;
    private static TextArea console;
    private static Label scoreLabel;
    private static HBox inventoryBox;

// Method to load our scene and to show it
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainmenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
        console = new TextArea();
        scoreLabel = new Label();
        inventoryBox = new HBox();
        scoreLabel.setText("Score: " + App.g.score.getScore());
    }
// method - to get our inventorybox
    public static HBox getInventoryBox() {
        return inventoryBox;
    }
// getting the score label
    public static Label getScoreLabel() {
        return scoreLabel;
    }
// getting the console
    public static TextArea getConsole() {
        return console;
    }
// A method that can load our FXML files
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
// The main FXML loader
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
// the object, which allows us to start the game
    public static Game g = new Game();
// our main method to launch the game 
    public static void load(String[] args) {
        launch();
    }
}
