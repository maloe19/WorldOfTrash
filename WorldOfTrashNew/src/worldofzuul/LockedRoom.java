/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author athiksawmy
 */
public class LockedRoom extends Room{
    private int scorelimit;
    
    public LockedRoom(String description, int scoreLimit) {
        super(description);
        this.scorelimit = scoreLimit;
    }

    public int getScorelimit() {
        return this.scorelimit;
    }
    
    
    
}
