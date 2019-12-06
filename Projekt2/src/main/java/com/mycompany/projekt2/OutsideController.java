/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class OutsideController implements Initializable {
    @FXML
    private Button north1;
    @FXML
    private Button WestOutside;
    @FXML
    private Button south2;
    @FXML
    private Button east1;
    public Parser parser;
    //@FXML
    //public Game g = new Game();
    public Room currentRoom;
    public ArrayList<Room> roomList = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void northToStreet(ActionEvent event) throws IOException {
        App.g.goRoom("north");
       //App.g.goRoom(App.g.parser.getCommand("go", "north", " "));
        App.setRoot("street");
    }

    @FXML
    private void westToPlayground(ActionEvent event) throws IOException {
        App.setRoot("playground");
    }

    @FXML
    private void southToForrest(ActionEvent event) throws IOException {
        App.setRoot("forrest");
    }

    @FXML
    private void eastToRecycle(ActionEvent event) throws IOException {
        App.setRoot("recycle");
    }
    
}
