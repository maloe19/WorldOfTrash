package worldofzuul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {

    //3 attributes and 2 objects 
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Room> roomList;
    Inventory inv = new Inventory();
    Score score = new Score();

    //Constructor that sets up the game (parser, rooms, trash etc.)
    public Game() {
        roomList = new ArrayList();
        createRooms();
        parser = new Parser();
    }

    private void addAll(Room... rooms) {
        for (Room room : rooms) {
            roomList.add(room);
        }
    }

    //Method: creates every element that is default in the game
    private void createRooms() {
        Room outside, recycle, playground, forrest, beach, street;

        Trash bottle_g = new GlassTrash("Bottle");
        Trash can_s = new MetalTrash("Soda");
        Trash straw = new PlasticTrash("Straw");
        Trash newspaper = new CardboardTrash("Newspaper");
        Trash bulb = new GlassTrash("Bulb");
        Trash bag = new CardboardTrash("Bag");
        Trash cardboard = new CardboardTrash("Cardboard");
        Trash bottle_p = new PlasticTrash("Bottle");
        Trash ball = new PlasticTrash("Ball");
        Trash juice = new CardboardTrash("Juicebox");
        Trash can_f = new MetalTrash("Can");

        outside = new Room("outside of your home");
        recycle = new Recycle("in the recycling room");
        playground = new LockedRoom("at the playground", 75);
        forrest = new Room("in the forrest");
        beach = new LockedRoom("at the beach", 150);
        street = new Room("on the street");

        street.setTrash(can_s);
        street.setTrash(bottle_g);
        street.setTrash(newspaper);

        playground.setTrash(juice);
        playground.setTrash(ball);
        playground.setTrash(bag);

        forrest.setTrash(bulb);
        forrest.setTrash(can_f);

        beach.setTrash(straw);
        beach.setTrash(cardboard);
        beach.setTrash(bottle_p);

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
        while (!finished && !isCompleted) {
            isCompleted = gameIsCompleted();
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("\nHope you learned something from this game. \nThank you for playing!");
        System.out.println("Your score was: " + score.getScore());
        System.out.println("KEEP RECYCLING!");
    }

    //Delay in milsec for the intro
    private synchronized void delay(long milsec) {
        try {
            wait(milsec);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Method - intro
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World Of Trash!\n");
        delay(1000);
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
        System.out.println("Hello " + name + "! good luck on your mission to save the world!");
        delay(2000);
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    //Method - Proccessing the commands from input
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.SEARCH) {
            currentRoom.getTrashNames();
        } else if (commandWord == CommandWord.PICKUP) {
            pickUpTrash(command);
        } else if (commandWord == CommandWord.THROW) {
            throwTrash(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    //Method for throwing trash from backpack, into every possible scenario
    public void throwTrash(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Throw what?");
        } else if (!command.hasThirdWord()) {
            String item = command.getSecondWord();
            Trash key = inv.getItemKey(item);
            if (currentRoom instanceof Recycle) {
                if (inv.getBackpack().contains(key)) {
                    System.out.println("throw " + command.getSecondWord() + " in which bin?");
                } else {
                    System.out.println("Your input is invalid.");
                }
            } else {
                item = command.getSecondWord();
                key = inv.getItemKey(item);
                if (inv.getBackpack().contains(key)) {
                    currentRoom.getTrashList().add(key);
                    inv.removeTrash(key);
                    System.out.println("\nYou succesfully threw the " + item);
                } else {
                    System.out.println("Your input is invalid.");
                }
            }
        } else if (command.hasThirdWord()) {
            String item = command.getSecondWord();
            Trash key = inv.getItemKey(item);
            String bin = command.getThirdWord();
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
        }
    }

    //Method for adding trash to backpack, from every possible scenario
    public void pickUpTrash(Command command) {
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
    }

    //Method - For commandword help
    private void printHelp() {
        System.out.println("In a world of extinction, you seek guidance");
        System.out.println("relying on the power of these commands");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();

    }

    //Method: For entering a room - Checks if there is a room, and if the needed points are achieved
    private void goRoom(Command command) {
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

    //Method: Checks whether the player want to quit
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    public boolean gameIsCompleted() {
        for (Room r : roomList ) {
            if (!r.getTrashList().isEmpty()) {
                return false;
            }
        }
        return inv.getBackpack().isEmpty();
    }
}
