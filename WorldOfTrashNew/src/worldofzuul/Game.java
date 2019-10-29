package worldofzuul;

import java.util.ArrayList;
import java.util.Arrays;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    //Constructors
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    //Method
    private void createRooms()
    {
        Room outside, recycle, playground, forrest, beach, street;
        Trash bottle = new Trash("Bottle");
        Trash can = new Trash("Can");
        Trash straw = new Trash("Straw");
        
        outside = new Room("outside of your home");
        recycle = new Room("in the recycling room");
        playground = new Room("at the playground");
        forrest = new Room("in the forrest");
        beach = new Room("at the beach");
        street = new Room("on the street");
        
        street.setTrash(can);
        street.setTrash(bottle);
        
        beach.setTrash(straw);
        
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
    }

    //Method
    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Hope you learned something from this game. \nThank you for playing!");
        System.out.println("KEEP RECYCLING!");
    }

    //Method(intro)
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World Of Trash!");
        System.out.println("World Of Trash is text-based \nlearning game about the enviroment");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    //Method(Proccessing the commands)
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if(commandWord == CommandWord.SEARCH) {
            System.out.println("This is what you found: ");
            currentRoom.getTrashName();
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    //Method(for help)
    private void printHelp() 
    {
        System.out.println("In a world of extinction, you seek guidance");
        System.out.println("relying on the power of these commands");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    //Method
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    //Method
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
