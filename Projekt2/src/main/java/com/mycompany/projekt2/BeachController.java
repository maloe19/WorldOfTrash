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

public class BeachController implements Initializable {
// Different types of attributes for our FXML file
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
// This initialize our FXML file, so that it can add our scorebox, inventorypane etc. Furthermore it check if the room contains trash
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
        scoreBox.getChildren().add(App.getScoreLabel());
        inventoryPane.getChildren().add(App.getInventoryBox());
        checkTrash();
    }
// a FXML method that allow us to go west
    @FXML
    private void westToForrest(ActionEvent event) throws IOException {
        App.g.goRoom("west");
    }
// a FXML method that allow us to pick the bottle trash. You can pick it up if your inventory have room for it
    @FXML
    private void pickUpbottle(MouseEvent event) {
        if (App.g.pickUpTrash("Bottle") == 1) {
            App.getInventoryBox().getChildren().add(bottle);
            trashPaneB.getChildren().remove(bottle);
        } else if (App.g.pickUpTrash("bottle") == 2) {
            App.getConsole().appendText("Bottle is chosen\n\n");
            App.g.setChosenLabel(bottle);
        }
    }
// a FXML method that allow us to pick the straw trash. You can pick it up if your inventory have room for it
    @FXML
    private void pickUpStraw(MouseEvent event) {
        if (App.g.pickUpTrash("straw") == 1) {
            App.getInventoryBox().getChildren().add(straw);
            trashPaneB.getChildren().remove(straw);
        } else if (App.g.pickUpTrash("straw") == 2) {
            App.getConsole().appendText("Straw is chosen\n\n");
            App.g.setChosenLabel(straw);
        }
    }
// a FXML method that allow us to pick up the cardboard trash. You can pick it up if your inventory have room for it
    @FXML
    private void pickUpCardboard(MouseEvent event) {
        if (App.g.pickUpTrash("cardboard") == 1) {
            App.getInventoryBox().getChildren().add(cardboard);
            trashPaneB.getChildren().remove(cardboard);
        } else if (App.g.pickUpTrash("cardboard") == 2) {
            App.getConsole().appendText("Cardboard is chosen\n\n");
            App.g.setChosenLabel(cardboard);
        }
    }
// This method checks if the room contains the designated trash. If it does, then - when we pick it up - it will be removed from the designated room.
    private void checkTrash() {
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("straw"))) {
            trashPaneB.getChildren().remove(straw);
        }
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("bottle"))) {
            trashPaneB.getChildren().remove(bottle);
        }
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("cardboard"))) {
            trashPaneB.getChildren().remove(cardboard);
        }
    }
}
