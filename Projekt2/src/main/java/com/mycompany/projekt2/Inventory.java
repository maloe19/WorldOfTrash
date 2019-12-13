package com.mycompany.projekt2;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Trash> backpack;

    public ArrayList<Trash> getBackpack() {
        return backpack;
    }

    public final int BACKCAP = 3;

    public int getBACKCAP() {
        return BACKCAP;
    }

    public Inventory() {
        backpack = new ArrayList<>();
    }

    public void addTrash(Trash key) {
        backpack.add(key);
    }

    public void removeTrash(Trash trash) {
        backpack.remove(trash);
    }

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
