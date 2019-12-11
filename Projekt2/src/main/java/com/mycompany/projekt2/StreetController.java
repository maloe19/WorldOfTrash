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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class StreetController implements Initializable {
 //@FXML
    //private TextArea txtbox;

    @FXML
    private Button STO;
    @FXML
    private Label newspaper1;
    @FXML
    private Label jar1;
    @FXML
    private Label sodacan;
    @FXML
    private AnchorPane ancPane;
    @FXML
    private AnchorPane scoreBox;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ancPane.getChildren().add(App.getConsole());
       scoreBox.getChildren().add(App.getScoreLabel());
       App.getConsole().appendText("you are on the street \n");

    }    
    
    @FXML
    private void southToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("south");
       
    }

    private void pickUpNewspaper(ActionEvent event) throws IOException {
        App.g.pickUpTrash("Newspaper");
    }

    @FXML
    private void pickUpNewspaper(MouseEvent event) throws IOException {
        App.g.pickUpTrash("Newspaper");
        App.g.score.scorePositive(10);
        
    }

    @FXML
    private void pickUpJar(MouseEvent event) {
        App.g.pickUpTrash("Jar");
       
    }

    @FXML
    private void pickUpSodaCan(MouseEvent event) {
        App.g.pickUpTrash("Soda");
        
    }
    
}
