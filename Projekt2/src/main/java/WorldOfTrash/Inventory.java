/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldOfTrash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Yonus Rafik
 */
public class Inventory {
    private ArrayList<Trash> backpack;

    public ArrayList<Trash> getBackpack() {
        return backpack;
    }
    
    public static int BACKCAP = 3;

    public int getBACKCAP() {
        return BACKCAP;
    }

    public Inventory()
    {
        backpack = new ArrayList<>();
    }
    
    public void addTrash (Trash key) {
            backpack.add(key);
              System.out.println("\n"+key.getName()+ " has been added to your backpack.");
        }
    
    public void removeTrash (Trash trash) {
        backpack.remove(trash);
    }
    
     public Trash getItemKey(String name){
         
         Trash trash = null;
         for(Trash tr : backpack){
             if (tr.getName().equalsIgnoreCase(name)){
                 trash = tr;
             }
         }
         return trash;
         
    }
  
    public void printInventory (){
        for(Trash tr : backpack){
            System.out.println(tr.getName());
        }
    }       
}
