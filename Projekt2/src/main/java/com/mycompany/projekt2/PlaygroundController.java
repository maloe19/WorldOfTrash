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
import javafx.scene.layout.Pane;
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
    @FXML
    private AnchorPane scoreBox;
    @FXML
    private AnchorPane inventoryPane;
    @FXML
    private Pane trashPaneP;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ancPane.getChildren().add(App.getConsole());
       scoreBox.getChildren().add(App.getScoreLabel());
       inventoryPane.getChildren().add(App.getInventoryBox());
       App.getConsole().appendText("you are at the playground \n");

    }    
    
    @FXML
    private void eastToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("east");
    }

    @FXML
    private void pickUpJuice(MouseEvent event) {
         if (App.g.pickUpTrash("Juicebox") == true) {
        App.getInventoryBox().getChildren().add(juice);
        trashPaneP.getChildren().remove(juice);
        }
        
    }

    @FXML
    private void pickUpBall(MouseEvent event) {
        if (App.g.pickUpTrash("Ball") == true) {
        App.getInventoryBox().getChildren().add(ball);
        trashPaneP.getChildren().remove(ball);
    }
    }

    @FXML
    private void pickUpBag(MouseEvent event) {
        if (App.g.pickUpTrash("Bag") == true) {
        App.getInventoryBox().getChildren().add(bag);
        trashPaneP.getChildren().remove(bag);
    }
    }

}
