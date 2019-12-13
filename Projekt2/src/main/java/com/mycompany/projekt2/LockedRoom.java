package com.mycompany.projekt2;

import com.mycompany.projekt2.Room;

public class LockedRoom extends Room {
// attribute for the score limit
    private int scorelimit;
// constructor for lockedroom, so that some rooms are locked and can only access them by collecting a X amount of points
    public LockedRoom(String description, String name, int scoreLimit) {
        super(description, name);
        this.scorelimit = scoreLimit;
    }
// getter method for scorelimit
    public int getScorelimit() {
        return this.scorelimit;
    }
}
