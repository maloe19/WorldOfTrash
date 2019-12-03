package WorldOfTrash;

public enum CommandWord
{
    //Enums - unchangeable variables
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), SEARCH("search"), PICKUP("pickup"), THROW("throw");
    
    //Attributes
    private String commandString;
    
    //Constructor for CommandWord
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    //Method returning the command string
    public String toString()
    {
        return commandString;
    }
}
