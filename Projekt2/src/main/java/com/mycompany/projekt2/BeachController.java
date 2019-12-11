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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    @FXML
    private AnchorPane scoreBox;
    @FXML
    private Pane trashPaneB;
    @FXML
    private AnchorPane inventoryPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
        scoreBox.getChildren().add(App.getScoreLabel());
        inventoryPane.getChildren().add(App.getInventoryBox());
        App.getConsole().appendText("you are at the beach \n");

    }    
    
    @FXML
    private void pickUpbottle(MouseEvent event) {
        if (App.g.pickUpTrash("Bottle") == 1) {
        App.getInventoryBox().getChildren().add(bottle);
        trashPaneB.getChildren().remove(bottle);
        }
    }

    @FXML
    private void westToForrest(ActionEvent event) throws IOException {
        App.g.goRoom("west");
    }

    @FXML
    private void pickUpStraw(MouseEvent event) {
        if (App.g.pickUpTrash("Straw") == 1) {
        App.getInventoryBox().getChildren().add(straw);
        trashPaneB.getChildren().remove(straw);
        }
    }

    @FXML
    private void pickUpCardboard(MouseEvent event) {
        if (App.g.pickUpTrash("Cardboard") == 1) {
        App.getInventoryBox().getChildren().add(cardboard);
        trashPaneB.getChildren().remove(cardboard);
        }
    }

}
