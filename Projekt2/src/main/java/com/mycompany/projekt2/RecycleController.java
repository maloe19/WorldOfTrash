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
/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class RecycleController implements Initializable {


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
    private TextArea ancPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ancPane.getChildren().add(App.getConsole());
    }    
    
    @FXML
    private void westToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("west");
    }

    @FXML
    private void plasticthrown(MouseEvent event) {
        System.out.println("plastic clicked");
    }

    @FXML
    private void metalthrown(MouseEvent event) {
    System.out.println("metal clicked");
    }

    @FXML
    private void cardboardthrown(MouseEvent event) {
    System.out.println("cardboard clicked");
    }

    @FXML
    private void glassthrown(MouseEvent event) {
    System.out.println("glass clicked");
    }

}
