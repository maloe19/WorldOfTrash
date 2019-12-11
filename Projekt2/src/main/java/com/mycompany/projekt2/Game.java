package com.mycompany.projekt2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static javafx.application.Application.launch;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Game {

    //3 attributes and 2 objects 
    public Parser parser;
    private Room currentRoom;
    public ArrayList<Room> roomList;
    Inventory inv;
    Score score = new Score();
   
    //Constructor that sets up the game (parser, rooms, trash etc.)
    public Game() {
        roomList = new ArrayList();
        createRooms();
        parser = new Parser();
        inv = new Inventory();
    }

    public void addAll(Room... rooms) {
        for (Room room : rooms) {
            roomList.add(room);
        }
    }

    //Method: creates every element that is default in the game
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
        playground = new LockedRoom("at the playground", "playground", 0);
        forrest = new Room("in the forrest", "forrest");
        beach = new LockedRoom("at the beach", "beach",0);
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

        addAll(outside, recycle, playground, forrest, beach, street);
    }

    //Method: controls whether the game is running or not - Supplies with needed text when game ended/started
    public void play() {
        printWelcome();

        boolean finished = false;
        boolean isCompleted = false;
        /*while (!finished && !isCompleted) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            isCompleted = gameIsCompleted();
        }

        if (isCompleted) {
            System.out.println("\n- !!! Congratiolations !!! - \nYou saved the world by recycling!\n");
        }
        System.out.println("\nHope you learned something from this game. \nThank you for playing!");
        System.out.println("Your score was: " + score.getScore());
        System.out.println("KEEP RECYCLING!");
        */
    } 
   

    //Delay in milsec for the intro
    public synchronized void delay(long milsec) {
        try {
            wait(milsec);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Method - intro
    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World Of Trash!\n");
       /* delay(1000);
        System.out.println("World Of Trash is a text-based \nLearning game about the enviroment!\n");
        delay(2000);
        System.out.println("The world is at the brink of extinction \nBecause of all the trash lying around\n");
        delay(2000);
        System.out.println("And that is why we need you!\n");
        delay(1500);
        System.out.println("But first what is your name?");
        Scanner obj = new Scanner(System.in);
        System.out.print("> ");
        String name = obj.nextLine();
        delay(400);
        System.out.println("\nHello " + name + "! good luck on your mission to save the world!");
        delay(2000);
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    */}

    //Method - Proccessing the commands from input
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            //goRoom(command);
        } else if (commandWord == CommandWord.SEARCH) {
            currentRoom.getTrashNames();
        } else if (commandWord == CommandWord.PICKUP) {
           // pickUpTrash(command);
        } else if (commandWord == CommandWord.THROW) {
            throwTrash(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    //Method for throwing trash from backpack, into every possible scenario
    public void throwTrash(Command command) {
        String item = command.getSecondWord();
        Trash key = inv.getItemKey(item);
        String bin = command.getThirdWord();

        if (!command.hasSecondWord()) {
            System.out.println("Throw what?");
        } else if (!command.hasThirdWord()) {
            if (!inv.getBackpack().contains(key)) {
                System.out.println("Your input is invalid");
            } else if (currentRoom instanceof Recycle) {
                System.out.println("throw " + command.getSecondWord() + " in which bin?");
            } else {
                currentRoom.getTrashList().add(key);
                inv.removeTrash(key);
                System.out.println("\nYou succesfully threw the " + item);
            }

        } else if (command.hasThirdWord() && currentRoom instanceof Recycle) {
            boolean isValid = false;
            boolean incorrectBin = false;

            for (ExtendedArrayList t : ((Recycle) currentRoom).getTrashBins()) {
                if (command.getThirdWord().equalsIgnoreCase(t.getType())
                        && inv.getBackpack().contains(key)
                        && t.getType().equalsIgnoreCase(key.getBinType())) {

                    t.add(key);
                    inv.removeTrash(key);
                    isValid = true;
                } else if (command.getThirdWord().equalsIgnoreCase(t.getType())
                        && inv.getBackpack().contains(key)
                        && !t.getType().equalsIgnoreCase(key.getBinType())) {
                    incorrectBin = true;
                }
            }
            if (isValid == true) {

                System.out.println(item + " has successfully been thrown in " + bin);
                score.scorePositive(key.getRecyclability());
                System.out.println("\nscore: " + score.getScore());
            } else if (incorrectBin == true) {
                score.scoreNegative(key.getRecyclability());
                System.out.println(item + " has been thrown in the wrong bin \nTry again!");
                System.out.println("\nscore: " + score.getScore());

            } else {
                System.out.println("Invalid input");

            }
        } else {
            System.out.println("Invalid input");
        }
    }

    public boolean pickUpTrash(String trash) {
        Boolean isadded = false;
        
        if (App.g.inv.getBACKCAP() > App.g.inv.getBackpack().size()) { 
        Trash key = App.g.currentRoom.getTrashKey(trash);
        App.g.inv.addTrash(key);
        App.g.currentRoom.getTrashList().remove(key);
        App.getConsole().appendText("you picked up the " + trash + "\n");
        isadded=true;
    } else {
        App.getConsole().appendText("your backpack is full " + trash + " can't be picked up\n");    
        }
        return isadded;
        }
    
    //Method for adding trash to backpack, from every possible scenario
    /*public void pickUpTrash(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Pick up what?");
        } else {
            String item = command.getSecondWord();
            Trash key = currentRoom.getTrashKey(item);
            if (currentRoom.getTrashList().contains(key)) {
                if (inv.getBackpack().size() < inv.getBACKCAP()) {
                    inv.addTrash(key);
                    currentRoom.getTrashList().remove(key);
                } else {
                    System.out.println("Your backpack is full");
                }
            } else {
                System.out.println("Your input is invalid.");
            }
        }
    }*/

    //Method - For commandword help
    public void printHelp() {
        System.out.println("In a world of extinction, you seek guidance");
        System.out.println("relying on the power of these commands");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();

    }

    public void goRoom(String direction) throws IOException {
        Room nextRoom = App.g.currentRoom.getExit(direction);
        
        if (nextRoom instanceof LockedRoom && App.g.score.getScore() < ((LockedRoom) nextRoom).getScorelimit()) {
                System.out.println("This room is locked \n"
                        + ((LockedRoom) nextRoom).getScorelimit() + " Points needed to enter");
            } else {
        App.g.currentRoom = nextRoom;
        App.setRoot(App.g.currentRoom.getName());
        System.out.println(App.g.currentRoom.getLongDescription());
    }}
    //Method: For entering a room - Checks if there is a room, and if the needed points are achieved
    /*public void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            //Checks whether the door has point-lock or not
            if (nextRoom instanceof LockedRoom && score.getScore() < ((LockedRoom) nextRoom).getScorelimit()) {
                System.out.println("This room is locked \n"
                        + ((LockedRoom) nextRoom).getScorelimit() + " Points needed to enter");
            } else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                //Printing bins when entering recycling-room
                if (currentRoom instanceof Recycle) {
                    System.out.println("\n These are the available bins: ");
                    ((Recycle) currentRoom).printbins();
                }
            }
        }

    }
*/
    //Method: Checks whether the player want to quit
    public boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    public boolean gameIsCompleted() {
        for (Room r : roomList) {
            if (!r.getTrashList().isEmpty()) {
                return false;
            }
        }
        return inv.getBackpack().isEmpty();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
