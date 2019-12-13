package com.mycompany.projekt2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Label;

public class Game {

//Attributes and objects 
    private Room currentRoom;
    private ArrayList<Room> roomList;
    Inventory inv;
    Score score = new Score();
    private String chosenTrash;
    private Label chosenLabel;
// method to get our room list
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    //Constructor that sets up the game 
    public Game() {
        roomList = new ArrayList();
        createRooms();
        inv = new Inventory();
    }

    //Method: creates every element that is default in the game and sets them in the designated places
    public void createRooms() {
        Room outside, recycle, playground, forrest, beach, street;

        Trash jar = new GlassTrash("Jar");
        Trash can_s = new MetalTrash("Soda");
        Trash straw = new PlasticTrash("Straw");
        Trash newspaper = new CardboardTrash("Newspaper");
        Trash bulb = new GlassTrash("Bulb");
        Trash bag = new CardboardTrash("Bag");
        Trash cardboard = new CardboardTrash("Cardboard");
        Trash bottle = new PlasticTrash("Bottle");
        Trash ball = new PlasticTrash("Ball");
        Trash juice = new CardboardTrash("Juicebox");
        Trash can_f = new MetalTrash("Can");

        outside = new Room("outside of your home", "outside");
        recycle = new Recycle("in the recycling room", "recycle");
        playground = new LockedRoom("at the playground", "playground", 75);
        forrest = new Room("in the forrest", "forrest");
        beach = new LockedRoom("at the beach", "beach", 150);
        street = new Room("on the street", "street");

        street.setTrash(can_s);
        street.setTrash(jar);
        street.setTrash(newspaper);

        playground.setTrash(juice);
        playground.setTrash(ball);
        playground.setTrash(bag);

        forrest.setTrash(bulb);
        forrest.setTrash(can_f);

        beach.setTrash(straw);
        beach.setTrash(cardboard);
        beach.setTrash(bottle);

        outside.setExit("east", recycle);
        outside.setExit("south", forrest);
        outside.setExit("west", playground);
        outside.setExit("north", street);

        recycle.setExit("west", outside);

        playground.setExit("east", outside);

        forrest.setExit("north", outside);
        forrest.setExit("east", beach);

        beach.setExit("west", forrest);

        street.setExit("south", outside);

        currentRoom = outside;

        Collections.addAll(roomList, outside, recycle, playground, forrest, beach, street);
    }
// this method will trigger when you have completed the game. You complete the game by collecting all the trash and throws them in the bins
    public void isEndGame() throws IOException {
        if (gameIsCompleted()) {
            App.setRoot("endscreen");
        }
    }
// method that allows us to throw the trash. It will check whether you threw it in the right bin, and checks the score system
    public boolean throwTrash(String trash, ExtendedArrayList bin) throws IOException {
        Trash key = App.g.inv.getItemKey(trash);
        boolean isValid = false;
        if (App.g.chosenTrash == null) {
            App.getConsole().appendText("pick a trash to throw\n\n");
        } else if (key.getBinType().equalsIgnoreCase(bin.getType())) {
            App.g.score.scorePositive(key.getRecyclability());
            App.g.inv.removeTrash(key);
            isValid = true;
            App.getConsole().appendText("Good job!\nYou threw the " + trash + " in the right bin\n\n");
        } else if (!key.getBinType().equalsIgnoreCase(bin.getType())) {
            App.g.score.scoreNegative(key.getRecyclability());
            App.getConsole().appendText("Oh! - You threw the " + trash + "in the wrong bin\nPick a trash again\n\n");
        }
        App.g.setChosenTrash(null);
        return isValid;
    }
// allows us to pick up the trash. It will look in our inventory to see if there are room to pick up the trash. Otherwise, it will not allow us to pick it up
    public int pickUpTrash(String trash) {
        int occasion = 3;

        if (App.g.inv.getBACKCAP() > App.g.inv.getBackpack().size()
                && App.g.currentRoom.getTrashList().contains(App.g.currentRoom.getTrashKey(trash))) {
            Trash key = App.g.currentRoom.getTrashKey(trash);
            App.g.inv.addTrash(key);
            App.g.currentRoom.getTrashList().remove(key);
            App.getConsole().appendText("you picked up the " + trash + "\n\n");
            occasion = 1;
        } else if (!App.g.currentRoom.getTrashList().contains(App.g.currentRoom.getTrashKey(trash))) {
            App.g.setChosenTrash(trash);
            occasion = 2;
        } else {
            App.getConsole().appendText("your backpack is full\n" + trash + " can't be picked up\n\n");
        }
        return occasion;
    }
// allows us to go in the different rooms 
    public void goRoom(String direction) throws IOException {
        Room nextRoom = App.g.currentRoom.getExit(direction);

        if (nextRoom instanceof LockedRoom && App.g.score.getScore() < ((LockedRoom) nextRoom).getScorelimit()) {
            App.getConsole().appendText("This room is locked \n"
                    + ((LockedRoom) nextRoom).getScorelimit() + " Points needed to enter");
        } else {
            App.g.currentRoom = nextRoom;
            App.setRoot(App.g.currentRoom.getName());
            App.getConsole().appendText(App.g.getCurrentRoom().getLongDescription());
        }
    }
// Method that will finish the game when the requirements is met
    public boolean gameIsCompleted() {
        for (Room r : App.g.getRoomList()) {
            if (!r.getTrashList().isEmpty()) {
                return false;
            }
        }
        return App.g.inv.getBackpack().isEmpty();
    }
// getter method that lets us get the current room we are in
    public Room getCurrentRoom() {
        return currentRoom;
    }
// constructor - sets the current room
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
// constructor for chosen label
    public void setChosenLabel(Label chosenLabel) {
        this.chosenLabel = chosenLabel;
    }
// method that gets the chosen label
    public Label getChosenLabel() {
        return chosenLabel;
    }
// method that gets the chosen trash as string
    public String getChosenTrash() {
        return chosenTrash;
    }
// constructor that sets the chosen trash
    public void setChosenTrash(String chosenTrash) {
        this.chosenTrash = chosenTrash;
    }
}