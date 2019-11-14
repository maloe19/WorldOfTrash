/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;
import java.util.ArrayList;
/**
 *
 * @author Yonus Rafik
 */
// A sub type of Trash, so we can have different types of trash
public class PlasticTrash extends Trash {
    // Constructor - defining plasticTrash and assigning it a score value 
    public PlasticTrash (String name) {
        super(name, 40);
    }
}
