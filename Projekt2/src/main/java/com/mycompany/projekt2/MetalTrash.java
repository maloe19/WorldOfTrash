package com.mycompany.projekt2;

public class MetalTrash extends Trash {

    public MetalTrash(String name) {
        super(name, 50);
        this.setBinType("Metal-bin");
    }
}
