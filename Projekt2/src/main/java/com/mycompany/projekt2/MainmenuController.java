/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class MainmenuController implements Initializable {

    @FXML
    private Button Play;
   
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(new File(".").getAbsolutePath());
    }    
    
    @FXML
    private void startGame(ActionEvent event) throws IOException {
        
        App.g.play();
        App.g.createRooms();
        App.setRoot("outside");
    }

}
