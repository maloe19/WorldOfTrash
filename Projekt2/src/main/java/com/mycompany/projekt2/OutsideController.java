package com.mycompany.projekt2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class OutsideController implements Initializable {
// attributes for the FXML code
    @FXML
    private Button WTP;
    @FXML
    private Button ETR;
    @FXML
    private Button STF;
    @FXML
    private Button NTS;
    @FXML
    private AnchorPane ancPane;
    @FXML
    private AnchorPane scoreBox;
    @FXML
    private AnchorPane inventoryPane;
// initialize the screen by loading scorebox, inventorypane etc
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scoreBox.getChildren().add(App.getScoreLabel());
        ancPane.getChildren().add(App.getConsole());
        inventoryPane.getChildren().add(App.getInventoryBox());
    }
// allows us to go to west from outside
    @FXML
    private void westToPlayground(ActionEvent event) throws IOException {
        App.g.goRoom("west");
    }
// allows us to go east
    @FXML
    private void eastToRecycle(ActionEvent event) throws IOException {
        App.g.goRoom("east");
    }
// allows us to go south
    @FXML
    private void southToForrest(ActionEvent event) throws IOException {
        App.g.goRoom("south");
    }
// allows us to go north
    @FXML
    private void northToStreet(ActionEvent event) throws IOException {
        App.g.goRoom("north");
    }
}
