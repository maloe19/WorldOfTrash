package com.mycompany.projekt2;

public class CardboardTrash extends Trash {

    // Constructor for Cardboard Trash
    public CardboardTrash(String name) {
        // Defining name and score value of cardboard type
        super(name, 30);
        this.setBinType("cardboard-bin");
    }
}
