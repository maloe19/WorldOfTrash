package worldofzuul;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser 
{
    //Attributes
    private CommandWords commands;
    private Scanner reader;

    //Constructor(That makes 2 new objects)
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    //Method (Our input = inputLine, also calls commands based on the string input)
    public Command getCommand() 
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> "); 

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next(); 
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    //Method
    public void showCommands()
    {
        commands.showAll();
    }
}
