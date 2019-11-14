/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Yonus Rafik
 */

public class Trash {
    private String name;
    private int recyclability;
    
    public Trash (String name, int recyclability)
    {
        this.name = name;
        this.recyclability = recyclability;
    }

    public int getRecyclability() {
        return recyclability;
    }
    
    public String getName() 
    {
        return name; 
    }
   
}

