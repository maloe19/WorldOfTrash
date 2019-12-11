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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private Label bulb;
    @FXML
    private Label can;
    @FXML
    private AnchorPane ancPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
        App.getConsole().appendText("you are in the forrest \n");

    }    
    
    @FXML
    private void northToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("north");
    }

    @FXML
    private void eastToBeach(ActionEvent event) throws IOException {
        App.g.goRoom("east");
    }

    @FXML
    private void pickUpBulb(MouseEvent event) {
        App.g.pickUpTrash("Bulb");
        App.getConsole().appendText("you picked up the Bulb \n");
    }

    @FXML
    private void pickUpCan(MouseEvent event) {
        App.g.pickUpTrash("Can");
        App.getConsole().appendText("you picked up the Can \n");
    }

}
