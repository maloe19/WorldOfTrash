package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    //Attributes
    private String description;
    private HashMap<String, Room> exits;

    //Constructors
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    //Method(It is a exit to another room)
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    //Method
    public String getShortDescription()
    {
        return description;
    }

    //Method (Longer version of previous)
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    //Method(Multiple exits)
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    //Method(Exits to the direction)
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

