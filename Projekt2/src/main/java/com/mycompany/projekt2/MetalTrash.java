package com.mycompany.projekt2;

public class MetalTrash extends Trash {
// constructor for metaltrash that extends from the parent class known as trash
    public MetalTrash(String name) {
        super(name, 50);
        this.setBinType("Metal-bin");
    }
}
