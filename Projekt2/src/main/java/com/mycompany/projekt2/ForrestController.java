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

public class ForrestController implements Initializable {
// various FXML attributes in order to acces them
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
    @FXML
    private AnchorPane scoreBox;
    @FXML
    private AnchorPane inventoryPane;
    @FXML
    private Pane trashPaneF;
// this will initialize the room and whats in it FXML-wise
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
        scoreBox.getChildren().add(App.getScoreLabel());
        inventoryPane.getChildren().add(App.getInventoryBox());
        checkTrash();
    }
// Allows us to go north
    @FXML
    private void northToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("north");
    }
// Allows us to east 
    @FXML
    private void eastToBeach(ActionEvent event) throws IOException {
        App.g.goRoom("east");
    }
// Allows us to pick up the bulb trash
    @FXML
    private void pickUpBulb(MouseEvent event) {
        if (App.g.pickUpTrash("Bulb") == 1) {
            App.getInventoryBox().getChildren().add(bulb);
            trashPaneF.getChildren().remove(bulb);
        } else if (App.g.pickUpTrash("bulb") == 2) {
            App.getConsole().appendText("Bulb is chosen\n\n");
            App.g.setChosenLabel(bulb);
        }
    }
// Allows us to pick up the Can trash
    @FXML
    private void pickUpCan(MouseEvent event) {
        if (App.g.pickUpTrash("Can") == 1) {
            App.getInventoryBox().getChildren().add(can);
            trashPaneF.getChildren().remove(can);
        } else if (App.g.pickUpTrash("can") == 2) {
            App.getConsole().appendText("Can is chosen\n\n");
            App.g.setChosenLabel(can);
        }
    }
// checks if the room contains the designated trash in order to remove them from the room
    private void checkTrash() {
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("bulb"))) {
            trashPaneF.getChildren().remove(bulb);
        }
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("can"))) {
            trashPaneF.getChildren().remove(can);
        }
    }
}
