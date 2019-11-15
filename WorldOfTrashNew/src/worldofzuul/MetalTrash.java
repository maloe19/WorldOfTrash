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
public class MetalTrash extends Trash {
    
    public MetalTrash (String name) {
        super(name, 50);
        this.setBinType("Metal-bin");
    }
    
}
