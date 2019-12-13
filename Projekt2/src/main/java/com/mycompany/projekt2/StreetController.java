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

public class StreetController implements Initializable {

    @FXML
    private Button STO;
    @FXML
    private Label newspaper;
    @FXML
    private Label jar;
    @FXML
    private Label sodacan;
    @FXML
    private AnchorPane ancPane;
    @FXML
    private AnchorPane scoreBox;
    @FXML
    private Pane trashPaneS;
    @FXML
    private AnchorPane inventoryPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
        scoreBox.getChildren().add(App.getScoreLabel());
        inventoryPane.getChildren().add(App.getInventoryBox());
        checkTrash();
    }

    @FXML
    private void southToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("south");

    }

    @FXML
    private void pickUpNewspaper(MouseEvent event) throws IOException {
        if (App.g.pickUpTrash("Newspaper") == 1) {
            App.getInventoryBox().getChildren().add(newspaper);
            trashPaneS.getChildren().remove(newspaper);
        } else if (App.g.pickUpTrash("Newspaper") == 2) {
            App.getConsole().appendText("Newspaper is chosen\n\n");
            App.g.setChosenLabel(newspaper);
        }
    }

    @FXML
    private void pickUpJar(MouseEvent event) {
        if (App.g.pickUpTrash("jar") == 1) {
            App.getInventoryBox().getChildren().add(jar);
            trashPaneS.getChildren().remove(jar);
        } else if (App.g.pickUpTrash("jar") == 2) {
            App.getConsole().appendText("Jar is chosen\n\n");
            App.g.setChosenLabel(jar);
        }
    }

    @FXML
    private void pickUpSodaCan(MouseEvent event) {
        if (App.g.pickUpTrash("soda") == 1) {
            App.getInventoryBox().getChildren().add(sodacan);
            trashPaneS.getChildren().remove(sodacan);
        } else if (App.g.pickUpTrash("soda") == 2) {
            App.getConsole().appendText("Soda is chosen\n\n");
            App.g.setChosenLabel(sodacan);
        }
    }

    private void checkTrash() {
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("jar"))) {
            trashPaneS.getChildren().remove(jar);
        }
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("newspaper"))) {
            trashPaneS.getChildren().remove(newspaper);
        }
        if (!App.g.getCurrentRoom().getTrashList().contains(App.g.getCurrentRoom().getTrashKey("soda"))) {
            trashPaneS.getChildren().remove(sodacan);
        }
    }
}
