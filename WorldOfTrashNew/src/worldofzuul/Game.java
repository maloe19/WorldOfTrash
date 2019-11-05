package worldofzuul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    Inventory inv = new Inventory();
    
    
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
        Trash bottle_g = new GlassTrash("Beer bottle");
        Trash can_s = new MetalTrash("Can soda");
        Trash straw = new PlasticTrash("Straw");
        Trash newspaper = new CardboardTrash("Newspaper");
        Trash bulb = new GlassTrash("Light bulb");
        Trash bag = new CardboardTrash("Paper bag");
        Trash cardboard = new CardboardTrash("Cardboard");
        Trash bottle_p = new PlasticTrash("Plastic bottle");
        Trash ball = new PlasticTrash ("Deflated ball");
        Trash juice = new CardboardTrash ("Juice box");
        Trash can_f = new MetalTrash ("Food can");
                
        outside = new Room("outside of your home");
        recycle = new Room("in the recycling room");
        playground = new Room("at the playground");
        forrest = new Room("in the forrest");
        beach = new Room("at the beach");
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
        
        recycle.setBin();
        
        
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

    private synchronized void delay(long milsec){
        try {
            wait(milsec);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Method(intro)
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World Of Trash!\n");
        delay(2000);
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
        delay(800);
        System.out.println("Hello " + name + "! good luck on your mission to save the world!");
        delay(2000);
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
            currentRoom.getTrashNames();
        }
        else if(commandWord == CommandWord.PICKUP) {
            pickUpTrash(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }
    
      public void pickUpTrash(Command command)
    {
        if (!command.hasSecondWord())
        {
            System.out.println("Pick up what?");
        }
        else 
        {
            String item = command.getSecondWord();
            Trash key = currentRoom.getTrashKey(item);
            if(currentRoom.getTrashList().containsKey(key)){
            inv.addTrash(item);
            currentRoom.getTrashList().remove(key);
            } else {
                System.out.println("Your input is invalid.");
            }
            
        }
           
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
