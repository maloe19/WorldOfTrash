package com.mycompany.projekt2;

import com.mycompany.projekt2.Room;
import java.util.ArrayList;

// Attributes for each of the trashbins.
public class Recycle extends Room {
// attributes for the recycle room
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
// method - return metalbin
    public ExtendedArrayList<MetalTrash> getMetalBin() {
        return metalBin;
    }
// return plasticbin
    public ExtendedArrayList<PlasticTrash> getPlasticBin() {
        return plasticBin;
    }
// returns glassbin
    public ExtendedArrayList<GlassTrash> getGlassBin() {
        return glassBin;
    }
// return cardboardbin
    public ExtendedArrayList<CardboardTrash> getCardboardBin() {
        return cardboardBin;
    }
}
