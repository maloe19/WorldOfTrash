package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Room 
{
    //Attributes
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Trash>trashList;
    
 
    
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
    
    public void getTrashNames(){
        
       if(trashList.isEmpty())
       {
           System.out.println("You found nothing here!");
       }
       else 
       {
           System.out.println("\nThis is what you found: ");
           for (Trash tr : trashList){
           System.out.println(tr.getName());
       }}}
    
    public Trash getTrashKey(String name){
        Trash trashName = null;
        for(Trash tr : trashList){
            if (tr.getName().equalsIgnoreCase(name)){
            trashName = tr;
            }  
        }
        return trashName;
    }
    
    //Method
    public String getShortDescription()
    {
        return description;
    }

    //Method (Longer version of previous)
    public String getLongDescription()
    {
        return "\nYou are " + description + ".\n" + getExitString();
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

