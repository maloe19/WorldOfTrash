package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Room 
{
    //Attributes for description, exits and trashlist.
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Trash>trashList;
    
 
    
    //Constructors assigning description to itself and making new objects for exits and trashlist
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
    // Method - so that we can add trash to each room
    public void setTrash(Trash trash) 
    {
        trashList.add(trash);
    }
    // Method - so that we can get trashlist for each room.
     public ArrayList<Trash> getTrashList() {
        return trashList; 
     }
    // method - a getter method so we can get the names of the trash that we make. 
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
    // Method - a getter method that return the trash element based on the name input.
    public Trash getTrashKey(String name){
        Trash trashName = null;
        for(Trash tr : trashList){
            if (tr.getName().equalsIgnoreCase(name)){
            trashName = tr;
            }  
        }
        return trashName;
    }
    
    //Method - returns the short description
    public String getShortDescription()
    {
        return description;
    }

    //Method - return a longer version of the description
    public String getLongDescription()
    {
        return "\nYou are " + description + ".\n" + getExitString();
    }
    
    

    //Method - a getter method that shows the available exits when entering a new room
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    //Method - exiting to the next room. 
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

