/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author Yonus Rafik
 */
public class GlassTrash extends Trash {

    public GlassTrash(String name) {
        super(name, 40);
        this.setBinType("glass-bin");
    }
}
