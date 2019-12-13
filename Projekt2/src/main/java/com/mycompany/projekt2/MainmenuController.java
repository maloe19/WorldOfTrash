package com.mycompany.projekt2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainmenuController implements Initializable {
// attributes for the play button
    @FXML
    private Button Play;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
// this method changes the play screen to welcomescreen
    @FXML
    private void startGame(ActionEvent event) throws IOException {
        App.setRoot("welcomescreen");
    }
}
