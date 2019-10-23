package worldofzuul;

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
        Room outside, recycle, playground, forrest, beach;
      
        outside = new Room("outside of your home");
        recycle = new Room("in the recycling room");
        playground = new Room("at the playground");
        forrest = new Room("in the forrest");
        beach = new Room("at the beach");
        
        outside.setExit("east", recycle);
        outside.setExit("south", forrest);
        outside.setExit("west", playground);

        recycle.setExit("west", outside);

        playground.setExit("east", outside);

        forrest.setExit("north", outside);
        forrest.setExit("east", beach);

        beach.setExit("west", forrest);

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
        System.out.println("Thank you for playing.  Good bye.");
    }

    //Method(intro)
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
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
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    //Method(for help)
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
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
