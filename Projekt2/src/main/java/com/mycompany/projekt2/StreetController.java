/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

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
public class StreetController implements Initializable {


    @FXML
    private TextArea txtbox;
    @FXML
    private Button but;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void southToOutside(ActionEvent event) throws IOException {
        App.setRoot("outside");
    }

    @FXML
    private void butHandler(ActionEvent event) {
        txtbox.appendText("Klikket ");
    }

}
