package com.mycompany.projekt2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;

public class WelcomescreenController implements Initializable {
// attributes for the FXML variables
    @FXML
    private TextField writename;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
// allows us to enter a name of own choice. After entering a name, the game will start
    @FXML
    private void enterName(ActionEvent event) throws IOException {
        String name = writename.getText();
        App.getConsole().appendText("Welcome " + name + "!\nGood Luck on your journey!\n\n");
        App.setRoot("outside");

    }

}
