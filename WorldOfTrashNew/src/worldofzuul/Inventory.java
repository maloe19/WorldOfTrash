/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;

/**
 *
 * @author Yonus Rafik
 */
public class Inventory {
    private ArrayList<String> backpack;

    public ArrayList<String> getBackpack() {
        return backpack;
    }
    
    public static int BACKCAP = 3;

    public Inventory()
    {
        backpack = new ArrayList<>();
    }
    
    public void addTrash (String trash) {
        if(backpack.size()<BACKCAP)
        {
        backpack.add(trash);  
            System.out.println("\n"+trash + " has been added to your backpack.");
            
        }
        else {
            System.out.println("Your backpack is full.");
        }
    }
    
    public void removeTrash (String trash) {
        backpack.remove(trash);
    }
   
    
    public void printInventory (){
        for(String i : backpack){
            System.out.println(i);
        }
    }
}
