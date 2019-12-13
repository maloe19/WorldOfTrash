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

public class RecycleController implements Initializable {
// Attributes for our FXML variables
    @FXML
    private Button WTO;
    @FXML
    private Label plastic;
    @FXML
    private Label metal;
    @FXML
    private Label cardboard;
    @FXML
    private Label glass;
    @FXML
    private AnchorPane ancPane;
    @FXML
    private AnchorPane scoreBox;
    @FXML
    private AnchorPane inventoryPane;
// initializing the room / screen
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
        scoreBox.getChildren().add(App.getScoreLabel());
        inventoryPane.getChildren().add(App.getInventoryBox());
    }
// allows us to go to west from recycle
    @FXML
    private void westToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("west");
    }
// allows us to throw plastic-type trash into the plasticbin. if the last trash you threw is a plastic trash, then the game will end
    @FXML
    private void plasticthrown(MouseEvent event) throws IOException {
        if (App.g.throwTrash(App.g.getChosenTrash(), ((Recycle) App.g.getCurrentRoom()).getPlasticBin()) == true) {
            App.getInventoryBox().getChildren().remove(App.g.getChosenLabel());
        }
        App.g.isEndGame();
    }
// allows us to throw the metal-type trash into the metalbin
    @FXML
    private void metalthrown(MouseEvent event) throws IOException {
        if (App.g.throwTrash(App.g.getChosenTrash(), ((Recycle) App.g.getCurrentRoom()).getMetalBin()) == true) {
            App.getInventoryBox().getChildren().remove(App.g.getChosenLabel());
        }
        App.g.isEndGame();
    }
// allows us to throw cardboard-type trash into the cardboardbin
    @FXML
    private void cardboardthrown(MouseEvent event) throws IOException {
        if (App.g.throwTrash(App.g.getChosenTrash(), ((Recycle) App.g.getCurrentRoom()).getCardboardBin()) == true) {
            App.getInventoryBox().getChildren().remove(App.g.getChosenLabel());
        }
        App.g.isEndGame();
    }
// allows us to throw glass-type trash into the cardboardbin
    @FXML
    private void glassthrown(MouseEvent event) throws IOException {
        if (App.g.throwTrash(App.g.getChosenTrash(), ((Recycle) App.g.getCurrentRoom()).getGlassBin()) == true) {
            App.getInventoryBox().getChildren().remove(App.g.getChosenLabel());
        }
        App.g.isEndGame();
    }

}
