/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

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
    private String binType;

    // Constructor - assigning name and recyclability to itself
    public Trash(String name, int recyclability) {
        this.name = name;
        this.recyclability = recyclability;
    }

    // Method - returning recyclability, represented as score value.
    public int getRecyclability() {
        return recyclability;
    }

    // Method - returning the name value
    public String getName() {
        return name;
    }

    // Method - returning the type of bin the trash is compatable with
    public String getBinType() {
        return binType;
    }

    // Method - sets the type of bin the trash is compatable with
    public void setBinType(String binType) {
        this.binType = binType;
    }

    @Override
    public String toString() {
        return getClass().getName() + " name=" + name;
    }

}
