/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projekt2;

import com.mycompany.projekt2.Room;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yonus Rafik
 */
// Attributes for each of the trashbins.
public class Recycle extends Room {
    private ExtendedArrayList<PlasticTrash> plasticBin;
    private ExtendedArrayList<MetalTrash> metalBin;
    private ExtendedArrayList<GlassTrash> glassBin;
    private ExtendedArrayList<CardboardTrash> cardboardBin;
    private ArrayList<ExtendedArrayList> trashBins;
    
    // Constructors - making the different trashbin objects and giving them names and adding them to the overall trashbin class
    public Recycle(String description, String name) {
        super(description, name);
        trashBins = new ArrayList<ExtendedArrayList>();
        
        plasticBin = new ExtendedArrayList<PlasticTrash>();
        plasticBin.setType("Plastic-bin");
        trashBins.add(plasticBin);
        
        glassBin = new ExtendedArrayList<GlassTrash>();
        glassBin.setType("Glass-bin");
        trashBins.add(glassBin);
        
        cardboardBin = new ExtendedArrayList<CardboardTrash>();
        cardboardBin.setType("Cardboard-bin");
        trashBins.add(cardboardBin);
        
        metalBin = new ExtendedArrayList<MetalTrash>();
        metalBin.setType("Metal-bin");
        trashBins.add(metalBin);
    }
    // Method - returns trashBins
    public ArrayList<ExtendedArrayList> getTrashBins() {
        return trashBins;
    }
    // Method - printing out the names of the trashbins inside the recycling room
    public void printbins(){
        for(ExtendedArrayList t : trashBins){
            System.out.println(" "+t.getType());
        }
    }}
