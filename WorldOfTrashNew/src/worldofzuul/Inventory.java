/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Yonus Rafik
 */
public class Inventory {
    private HashMap<Trash, String> backpack;

    public HashMap<Trash, String> getBackpack() {
        return backpack;
    }
    
    public static int BACKCAP = 3;

    public Inventory()
    {
        backpack = new HashMap<>();
    }
    
    public void addTrash (Trash key,String item) {
        if(backpack.size()<BACKCAP)
        {
        backpack.put(key, item);  
            System.out.println("\n"+item + " has been added to your backpack.");
            
        }
        else {
            System.out.println("Your backpack is full.");
        }
    }
    
    public void removeTrash (String trash) {
        backpack.remove(trash);
    }
   
    
    public void printInventory (){
        Iterator it = backpack.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getValue());
        }
    }
}
