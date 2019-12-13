package com.mycompany.projekt2;

import com.mycompany.projekt2.Room;

public class LockedRoom extends Room {

    private int scorelimit;

    public LockedRoom(String description, String name, int scoreLimit) {
        super(description, name);
        this.scorelimit = scoreLimit;
    }

    public int getScorelimit() {
        return this.scorelimit;
    }
}
