/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Yonus Rafik
 */
public class BeachController implements Initializable {


    @FXML
    private Label bottle;
    @FXML
    private Button WTF;
    @FXML
    private Label straw;
    @FXML
    private Label cardboard;
    @FXML
    private AnchorPane ancPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
    }    
    
    @FXML
    private void pickUpbottle(MouseEvent event) {
    }

    @FXML
    private void westToForrest(ActionEvent event) {
    }

    @FXML
    private void pickUpStraw(MouseEvent event) {
    }

    @FXML
    private void pickUpCardboard(MouseEvent event) {
    }

}
