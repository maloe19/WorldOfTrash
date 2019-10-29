package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    //Attributes
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Trash> trashList;
    
    //Constructors
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        trashList = new ArrayList<Trash>();
    }
    
    //Method(It is a exit to another room)
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    

    public void setTrash(Trash trash) 
    {
        trashList.add(trash);
    }

     public ArrayList<Trash> getTrashList() {
        return trashList; 
     }
    
    public void getTrashName(){
       for (Trash tr : trashList){
           System.out.println(tr.getName());
       }}
  
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

