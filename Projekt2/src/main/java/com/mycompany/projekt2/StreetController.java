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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ancPane.getChildren().add(App.getConsole());
       scoreBox.getChildren().add(App.getScoreLabel());
       inventoryPane.getChildren().add(App.getInventoryBox());
       App.getConsole().appendText("you are on the street \n");
       

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
            //newspaper.setEffect(App.getBorderglow()); 
        }
    }

    @FXML
    private void pickUpJar(MouseEvent event) {
        if (App.g.pickUpTrash("Jar") == 1) {
        App.getInventoryBox().getChildren().add(jar);
        trashPaneS.getChildren().remove(jar);
        } else if (App.g.pickUpTrash("jar") == 2) {
            //Hvad end der nu skal ske :)
        }
    }

    @FXML
    private void pickUpSodaCan(MouseEvent event) {
        if (App.g.pickUpTrash("Soda") == 1) {
        App.getInventoryBox().getChildren().add(sodacan);
        trashPaneS.getChildren().remove(sodacan);
        }
        
    }
    
}
