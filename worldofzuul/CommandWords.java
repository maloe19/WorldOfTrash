package worldofzuul;
import java.util.HashMap;


public class CommandWords
{
    //Attributes (HashMap)
    private HashMap<String, CommandWord> validCommands;

    //Constructor
    public CommandWords()
    {
        //Makes a new Object called validCommands
        validCommands = new HashMap<String, CommandWord>();
        //For each loop
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    //Method
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    //Method(Checks whether aString is included in the HashMap)
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    //Method(Prints out every valid commands)
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
