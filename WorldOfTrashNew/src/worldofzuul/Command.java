/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two parts: a CommandWord and a string
 * (for example, if the command was "take map", then the two parts
 * are TAKE and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the CommandWord is UNKNOWN.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

package worldofzuul;

public class Command
{
    //Attributes
    private CommandWord commandWord;
    private String secondWord;
    private String thirdWord;

    //Constructors
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }
    
    
    public String getThirdWord() {
        return thirdWord;
    }
   
   public Command(CommandWord commandWord, String secondWord, String thirdWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    } 
    
    //Method
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    //Method
    public String getSecondWord()
    {
        return secondWord;
    }
    
    //Method(return either false or true if CommandWord is Unknown or not)
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    //Method(returns false or true if secondWord is, or is not equal to null)
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
    public boolean hasThirdWord(){
        return (thirdWord != null);
    }
}
