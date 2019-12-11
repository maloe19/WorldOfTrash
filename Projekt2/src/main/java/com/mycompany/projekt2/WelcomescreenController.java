/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class WelcomescreenController implements Initializable {
    

    @FXML
    private TextField writename;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void enterName(ActionEvent event) throws IOException {
        String name = writename.getText();
        App.g.play();
        App.g.createRooms();
        App.getConsole().appendText("Welcome "+name+"!\nGood Luck on your journey!\n \n");
        App.setRoot("outside");
        
    }

}
