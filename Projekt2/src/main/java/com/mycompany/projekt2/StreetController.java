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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void southToOutside(ActionEvent event) throws IOException {
        App.g.goRoom("south");
    }

    private void pickUpNewspaper(ActionEvent event) throws IOException {
        System.out.println("Newspaper clicked");
    //App.g.pickUpTrash("newspaper");
    }

    @FXML
    private void pickUpNewspaper(MouseEvent event) throws IOException {
    //App.g.pickUpTrash("Newspaper");
    System.out.println("Newspaper clicked");
    }

    @FXML
    private void pickUpJar(MouseEvent event) {
    //App.g.pickUpTrash("jar");
    System.out.println("Jar clicked");
    }

    @FXML
    private void pickUpSodaCan(MouseEvent event) {
    //App.g.pickUpTrash("soda");
    System.out.println("Soda clicked");
    }
    
}
