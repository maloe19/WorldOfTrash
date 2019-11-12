/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yonus Rafik
 */
public class Recycle extends Room {
    private ArrayList<PlasticTrash> plasticBin;
    private ArrayList<MetalTrash> metalBin;
    private ArrayList<GlassTrash> glassBin;
    private ArrayList<CardboardTrash> cardboardBin;
    private ArrayList<ArrayList> trashBins;

    public Recycle(String description) {
        super(description);
        trashBins = new ArrayList<>();
        
        plasticBin = new ArrayList<>();
        trashBins.add(plasticBin);
        
        glassBin = new ArrayList<>();
        trashBins.add(glassBin);
        
        cardboardBin = new ArrayList<>();
        trashBins.add(cardboardBin);
        
        metalBin = new ArrayList<>();
        trashBins.add(metalBin);
    }
    
    public ArrayList<ArrayList> getTrashBins() {
        return trashBins;
    }
    
    public void printbins(){
        for(ArrayList t : trashBins){
            
        }
    }
    
    public String getBinNames(){

    String bins = "\nThese are the available bins: \n plasticBin \n glassBin \n cardboardBin \n metalBin";
    return bins;
    }
}
