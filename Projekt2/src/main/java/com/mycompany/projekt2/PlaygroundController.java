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
public class PlaygroundController implements Initializable {


    @FXML
    private Button ETO;
    @FXML
    private Label juice;
    @FXML
    private Label ball;
    @FXML
    private Label bag;
    @FXML
    private AnchorPane ancPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ancPane.getChildren().add(App.getConsole());
       App.getConsole().appendText("you are at the playground \n");

    }    
    
    @FXML
    private void eastToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("east");
    }

    @FXML
    private void pickUpJuice(MouseEvent event) {
        App.g.pickUpTrash("Juicebox");
        App.getConsole().appendText("you picked up the Juice \n");
    }

    @FXML
    private void pickUpBall(MouseEvent event) {
    App.g.pickUpTrash("Ball");
    App.getConsole().appendText("you picked up the Ball \n");
    }

    @FXML
    private void pickUpBag(MouseEvent event) {
    App.g.pickUpTrash("Bag");
    App.getConsole().appendText("you picked up the Bag \n");
    }

}
