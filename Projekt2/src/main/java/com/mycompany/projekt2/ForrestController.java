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
/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class ForrestController implements Initializable {


    @FXML
    private Button NTO;
    @FXML
    private Button ETB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void northToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("north");
    }

    @FXML
    private void eastToBeach(ActionEvent event) throws IOException {
        App.g.goRoom("east");
    }

}
