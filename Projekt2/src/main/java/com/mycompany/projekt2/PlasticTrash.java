package com.mycompany.projekt2;

// A sub type of Trash, so we can have different types of trash
public class PlasticTrash extends Trash {

    // Constructor - defining plasticTrash and assigning it a score value 
    public PlasticTrash(String name) {
        super(name, 40);
        this.setBinType("Plastic-bin");
    }
}
