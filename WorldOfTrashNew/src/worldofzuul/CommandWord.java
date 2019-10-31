package worldofzuul;

public enum CommandWord
{
    //Enums(They are unchangeable variables)
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), SEARCH("search"), PICKUP("pickup"), THROW("throw");
    
    //Attributes
    private String commandString;
    
    //Constructors
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    //Method
    public String toString()
    {
        return commandString;
    }
}
