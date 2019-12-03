package WorldOfTrash;

import java.util.HashMap;

public class CommandWords {

    //HashMap for valid commands
    private HashMap<String, CommandWord> validCommands;

    //Constructor
    public CommandWords() {
        //Makes a new Object called validCommands
        validCommands = new HashMap<String, CommandWord>();
        //Adds valid commands to Hashmap
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    //Method: returns commandWord based on if valid or not 
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }

    //Method: Checks whether a string is valid or not (known or unknown)
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    //Method - Prints out every valid command
    public void showAll() {
        for (String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
