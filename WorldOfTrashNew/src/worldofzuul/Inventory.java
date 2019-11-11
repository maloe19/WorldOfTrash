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

    public int getBACKCAP() {
        return BACKCAP;
    }

    public Inventory()
    {
        backpack = new HashMap<>();
    }
    
    public void addTrash (Trash key,String item) {
            backpack.put(key, item);
              System.out.println("\n"+item + " has been added to your backpack.");
        }
    
    public void removeTrash (String trash) {
        backpack.remove(trash);
    }
    
     public Trash getItemKey(String name){
        Trash key = null;
        for (Map.Entry<Trash, String> tr : backpack.entrySet()){
        if(tr.getValue().equalsIgnoreCase(name)==false){     
        }
        else if (tr.getValue().equalsIgnoreCase(name)==true){
           key = tr.getKey();
        }}
        return key;
    }
  
    
    public void printInventory (){
        Iterator it = backpack.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getValue());
        }
    }
}
