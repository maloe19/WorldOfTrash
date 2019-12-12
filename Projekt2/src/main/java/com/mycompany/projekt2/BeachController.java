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
        checkTrash();

    }    
    
    @FXML
    private void pickUpbottle(MouseEvent event) {
        if (App.g.pickUpTrash("Bottle") == 1) {
        App.getInventoryBox().getChildren().add(bottle);
        trashPaneB.getChildren().remove(bottle);
        } else if (App.g.pickUpTrash("bottle") == 2) {
            App.getConsole().appendText("Bottle is chosen\n");
            App.g.setChosenLabel(bottle); 
        }
    }

    @FXML
    private void westToForrest(ActionEvent event) throws IOException {
        App.g.goRoom("west");
    }

    @FXML
    private void pickUpStraw(MouseEvent event) {
        if (App.g.pickUpTrash("straw") == 1) {
        App.getInventoryBox().getChildren().add(straw);
        trashPaneB.getChildren().remove(straw);
        } else if (App.g.pickUpTrash("straw") == 2) {
            App.getConsole().appendText("Straw is chosen\n");
            App.g.setChosenLabel(straw); 
        }
    }

    @FXML
    private void pickUpCardboard(MouseEvent event) {
        if (App.g.pickUpTrash("cardboard") == 1) {
        App.getInventoryBox().getChildren().add(cardboard);
        trashPaneB.getChildren().remove(cardboard);
        } else if (App.g.pickUpTrash("cardboard") == 2) {
            App.getConsole().appendText("Cardboard is chosen\n");
            App.g.setChosenLabel(cardboard); 
        }
    }
    
    private void checkTrash() {
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("straw"))){
           trashPaneB.getChildren().remove(straw);
       } 
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("bottle"))){
           trashPaneB.getChildren().remove(bottle);
       }
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("cardboard"))){
           trashPaneB.getChildren().remove(cardboard);
       }
    }
}
