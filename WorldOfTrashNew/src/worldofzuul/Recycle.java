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
    private ExtendedArrayList<PlasticTrash> plasticBin;
    private ExtendedArrayList<MetalTrash> metalBin;
    private ExtendedArrayList<GlassTrash> glassBin;
    private ExtendedArrayList<CardboardTrash> cardboardBin;
    private ArrayList<ExtendedArrayList> trashBins;
    

    public Recycle(String description) {
        super(description);
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
    
    public ArrayList<ExtendedArrayList> getTrashBins() {
        return trashBins;
    }
    
    public void printbins(){
        for(ExtendedArrayList t : trashBins){
            System.out.println(" "+t.getType());
        }
    }}
