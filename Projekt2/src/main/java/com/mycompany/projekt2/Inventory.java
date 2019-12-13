package com.mycompany.projekt2;

import java.util.ArrayList;

public class Inventory {
// attributes for our backpack
    private ArrayList<Trash> backpack;
// returns the backpack as a arraylist
    public ArrayList<Trash> getBackpack() {
        return backpack;
    }
// a final variable in order to restrict how much trash you are allowed to have in your inventory
    public final int BACKCAP = 3;
// return the back capacity
    public int getBACKCAP() {
        return BACKCAP;
    }
// backpack object created
    public Inventory() {
        backpack = new ArrayList<>();
    }
// add trash in inventory
    public void addTrash(Trash key) {
        backpack.add(key);
    }
// remove trash in inventory
    public void removeTrash(Trash trash) {
        backpack.remove(trash);
    }
// this method finds the represented trash for a given String
    public Trash getItemKey(String name) {

        Trash trash = null;
        for (Trash tr : backpack) {
            if (tr.getName().equalsIgnoreCase(name)) {
                trash = tr;
            }
        }
        return trash;

    }
}
