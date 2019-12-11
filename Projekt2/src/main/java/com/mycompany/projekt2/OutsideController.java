/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class OutsideController implements Initializable {
   
    @FXML
    private Button WTP;
    @FXML
    private Button ETR;
    @FXML
    private Button STF;
    @FXML
    private Button NTS;
    //@FXML
    //private ImageView backgroundImage;
    
        
    //Image beach;
    @FXML
    private Pane pane;
    @FXML
    private AnchorPane ancPane;
    @FXML
    private ImageView backgroundImage;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ancPane.getChildren().add(App.getConsole());
        App.getConsole().appendText("you are outside of your home \n");

    }    
    
    @FXML
    private void westToPlayground(ActionEvent event) throws IOException {
    App.g.goRoom("west");
    }

    @FXML
    private void eastToRecycle(ActionEvent event) throws IOException {
        App.g.goRoom("east");
    }

    @FXML
    private void southToForrest(ActionEvent event) throws IOException {
        App.g.goRoom("south");
    }

    @FXML
    private void northToStreet(ActionEvent event) throws IOException {
        App.g.goRoom("north");
    }


}
