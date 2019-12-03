

package WorldOfTrash;

public class Command
{
    //Attributes defining user input
    private CommandWord commandWord;
    private String secondWord;
    private String thirdWord;

    //Constructor defining the attributes (in instance of two user inputs) 
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }
    
    //Constructor defining the attributes (in instance of three user inputs) 
   public Command(CommandWord commandWord, String secondWord, String thirdWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    } 
    
    //Method returning first user input (a command)
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    //Method returning second user input
    public String getSecondWord()
    {
        return secondWord;
    }
    
    // Method returning third user input
    public String getThirdWord() {
        return thirdWord;
    }
    
    //Method(return either false or true if CommandWord is Unknown or not)
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    //Method, which returns false or true based on if user input has second word
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
    
    //Method, which returns false or true based on if user input has second word
    public boolean hasThirdWord(){
        return (thirdWord != null);
    }
}
