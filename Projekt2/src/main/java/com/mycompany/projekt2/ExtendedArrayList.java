package com.mycompany.projekt2;

import java.util.ArrayList;

//Class created to add the possibility to give each ArrayList a type it can recieve
public class ExtendedArrayList<E> extends ArrayList<E> {

    //Attribute for arraylist
    private String type;

    //Returns type of trashbin
    public String getType() {
        return type;
    }

    //Sets type of the bin
    public void setType(String type) {
        this.type = type;
    }
}
