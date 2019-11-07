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
    private HashMap<Trash, String> trashList;
    private ArrayList<PlasticTrash> plasticBin;
    private ArrayList<MetalTrash> metalBin;
    private ArrayList<GlassTrash> glassBin;
    private ArrayList<CardboardTrash> CardboardBin;
 
    
    //Constructors
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        trashList = new HashMap<Trash, String>();
    }   
    
    //Method(It is a exit to another room)
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    public void setBin(){
        
    }

    public void setTrash(Trash trash) 
    {
        trashList.put(trash, trash.getName());
    }

     public HashMap<Trash, String> getTrashList() {
        return trashList; 
     }
    
    public void getTrashNames(){
       if(trashList.isEmpty())
       {
           System.out.println("You found nothing here!");
       }
       else 
       {
           System.out.println("This is what you found: ");
           for (Trash tr : trashList.keySet()){
           System.out.println(tr.getName());
       }}}
    
    public Trash getTrashKey(String name){
        Trash key = null;
        for (Map.Entry<Trash, String> tr : trashList.entrySet()){
        if(tr.getValue().equalsIgnoreCase(name)==false){     
        }
        else if (tr.getValue().equalsIgnoreCase(name)==true){
           key = tr.getKey();
        }}
        return key;
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

