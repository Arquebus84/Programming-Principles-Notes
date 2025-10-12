import java.util.Scanner;
public class ScannerClass{

    /**
     * 
     * //NOTE: A token is what's read by the Scanner from the user input:
     *              * The scanner breaks down the user input using a delimiter pattern (white space is default)
     * 
                Scanner
        - buffer : char[ ]  
        + Scanner(Readable)                 //Creates a new Scanner class (use System.in as Readable for user input, more on file reading in IOBinary)
        + Scanner(String)               
                                        //NOTE: The has- functions first skip any input with delimiter pattern, and then attempt to return the next token
        + hasNext( ) : boolean              //Checks if there is another token in the input (usually as a String with no white spaces (a word***))
        + hasNextBoolean( ) : boolean       //Checks if there is another boolean token in input
        + hasNextDouble( ) : boolean        //Checks if there is another double token in input
        + hasNextInt( ) : boolean           //Checks if there is another integer token in input
        + hasNextLine( ) : boolean          //Checks if there is another line of token in input
        + next( ) : String                  //Reads the next complete token from the input
        + nextBoolean( ) : boolean          //Reads the next token as a boolean
        + nextDouble( ) : double            //Reads the next token as a double
        + nextInt( ) : int                  //Reads the next token as a integer
        + nextLine( ) : String              //Reads an entire next line of input (includes white spaces (a sentence****) until a seperator is encountered)


                    NOTE: The hasNext() and next() functions may block waiting for further input
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer:");
        System.out.println("Check:" + input.hasNextInt());   //If User doesn't enter an integer, it prints false

        System.out.println("Entered Something:");
        System.out.println("Check:" + input.hasNext());   //Regardless, will be true if user enters anything (will be converted into a String)

        input.close();
    }
}
