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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
        scoreBox.getChildren().add(App.getScoreLabel());
        inventoryPane.getChildren().add(App.getInventoryBox());
        checkTrash();
    }

    @FXML
    private void eastToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("east");
    }

    @FXML
    private void pickUpJuice(MouseEvent event) {
        if (App.g.pickUpTrash("juicebox") == 1) {
            App.getInventoryBox().getChildren().add(juice);
            trashPaneP.getChildren().remove(juice);
        } else if (App.g.pickUpTrash("juicebox") == 2) {
            App.getConsole().appendText("Juice is chosen\n\n");
            App.g.setChosenLabel(juice);
        }

    }

    @FXML
    private void pickUpBall(MouseEvent event) {
        if (App.g.pickUpTrash("ball") == 1) {
            App.getInventoryBox().getChildren().add(ball);
            trashPaneP.getChildren().remove(ball);
        } else if (App.g.pickUpTrash("Ball") == 2) {
            App.getConsole().appendText("Ball is chosen\n\n");
            App.g.setChosenLabel(ball);
        }
    }

    @FXML
    private void pickUpBag(MouseEvent event) {
        if (App.g.pickUpTrash("bag") == 1) {
            App.getInventoryBox().getChildren().add(bag);
            trashPaneP.getChildren().remove(bag);
        } else if (App.g.pickUpTrash("bag") == 2) {
            App.getConsole().appendText("Bag is chosen\n\n");
            App.g.setChosenLabel(bag);
        }
    }

    private void checkTrash() {
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("juicebox"))) {
            trashPaneP.getChildren().remove(juice);
        }
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("bag"))) {
            trashPaneP.getChildren().remove(bag);
        }
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("ball"))) {
            trashPaneP.getChildren().remove(ball);
        }

    }
}
