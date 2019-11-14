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
    // attributes for the name with the type of String, and a recyclability with the type of int.
    private String name;
    private int recyclability;
    
    // Constructor - assigning name and recyclability to itself
    public Trash (String name, int recyclability)
    {
        this.name = name;
        this.recyclability = recyclability;
    }
    // Method - returning recyclability, represented as score value.
    public int getRecyclability() {
        return recyclability;
    }
    // Method - returning the name value
    public String getName() 
    {
        return name; 
    }
   
}

