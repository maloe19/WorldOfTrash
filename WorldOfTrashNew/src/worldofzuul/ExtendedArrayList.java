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

    //Class created to add the possibility to give each ArrayList a type it can recieve
public class ExtendedArrayList<E> extends ArrayList<Trash> {
    //Attribute for arraylist
    private String type;
    
    //Returns type of trashbin
    public String getType(){
        return type;
    }
    
    //Sets type of the bin
    public void setType(String type){
     this.type = type;    
    }
    
               
}
