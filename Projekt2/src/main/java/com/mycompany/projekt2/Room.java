package com.mycompany.projekt2;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    //Attributes for description, exits and trashlist.
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Trash> trashList;
    private String name;

    //Constructors assigning description to itself and making new objects for exits and trashlist
    public Room(String description, String name) {
        this.description = description;
        exits = new HashMap<String, Room>();
        trashList = new ArrayList<Trash>();
        this.name = name;
    }

    //Method(It is a exit to another room)
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    // Method - so that we can add trash to each room
    public void setTrash(Trash trash) {
        trashList.add(trash);
    }

    // Method - so that we can get trashlist for each room.
    public ArrayList<Trash> getTrashList() {
        return trashList;
    }

    // Method - a getter method that return the trash element based on the name input.
    public Trash getTrashKey(String name) {
        Trash trashName = null;
        for (Trash tr : trashList) {
            if (tr.getName().equalsIgnoreCase(name)) {
                trashName = tr;
            }
        }
        return trashName;
    }

    //Method - returns the short description
    public String getShortDescription() {
        return description;
    }

    //Method - return a longer version of the description
    public String getLongDescription() {
        return "You are " + description+"\n\n";
    }
// method- returns name
    public String getName() {
        return name;
    }

    //Method - exiting to the next room. 
    public Room getExit(String direction) {
        return exits.get(direction);
    }

}
