package com.mycompany.projekt2;

public class GlassTrash extends Trash {
// constructor that uses the super-keyword from the main trash class
    public GlassTrash(String name) {
        super(name, 40);
        this.setBinType("glass-bin");
    }
}
