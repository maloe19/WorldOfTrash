/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextArea;
/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class EndscreenController implements Initializable {


    @FXML
    private TextArea endscreentext;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        endscreentext.setText("Congratulations!\n" +
"\n" +
"You succesfully managed to save the world by recycling!\n" +
"\n" +
"Hope you learned something from this game. Thank you for playing!\n" +
"\n" +
"Your score was:"+App.g.score.getScore()+" \n" +
"\n" +
"And remember to\n" +
"KEEP RECYCLING!");
    }    
    
}
