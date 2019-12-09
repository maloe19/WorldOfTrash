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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class BeachController implements Initializable {


    @FXML
    private Button WTF;
    @FXML
    private Label straw;
    @FXML
    private Label cardboard;
    @FXML
    private Label bottle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void westToForrest(ActionEvent event) throws IOException {
        App.g.goRoom("west");
    }

    @FXML
    private void pickUpStraw(MouseEvent event) {
        System.out.println("Straw clicked");
    }

    @FXML
    private void pickUpCardboard(MouseEvent event) {
    System.out.println("Cardboard clicked");
    }

    @FXML
    private void pickUpbottle(MouseEvent event) {
        System.out.println("Bottle clicked");
    }

}
