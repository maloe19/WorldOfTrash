package com.mycompany.projekt2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class EndscreenController implements Initializable {
// FXML attributes
    @FXML
    private TextArea endscreentext;
// when you have completed the game, this will initialize and the text will then be represented
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        endscreentext.setText("Congratulations!\n"
                + "\n"
                + "You succesfully managed to save the world by recycling!\n"
                + "\n"
                + "Hope you learned something from this game. Thank you for playing!\n"
                + "\n"
                + "Your score was:" + App.g.score.getScore() + " \n"
                + "\n"
                + "And remember to\n"
                + "KEEP RECYCLING!");
    }

}
