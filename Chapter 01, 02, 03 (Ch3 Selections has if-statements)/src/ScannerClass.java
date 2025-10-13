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

    //This is for File class in Chapter 12
    /**
			java.util.Scanner
		+Scanner(source: File)						//Creates Scanner that produces values scanned from the specified file
		+Scanner(source: String)					//Creates Scanner that produces values scanned from the specified String. It's
														interesting to note that a Scanner can scan data from a file as well as from
														a String
		+close()									//Closes the Scanner
		+hasNext(): boolean							//Returns true if this Scanner has more data to read
		+next(): String								//Returns the next token as a String from this Scanner (doesn't count the line-ending
														or line-separator (\r or \n))
		+nextLine(): String							//Returns a line-ending with the line separator from this Scanner
		+nextByte(): byte							//Returns next token as a byte from this Scanner
		+nextShort(): short							//Returns next token as a short from this Scanner
		+nextInt(): int								//Returns next token as a int from this Scanner
		+nextLong(): long							//Returns next token as a long from this Scanner
		+nextFloat(): float							//Returns next token as a float from this Scanner
		+nextDouble(): double						//Returns next token as a double from this Scanner
		**+useDelimiter(pattern: String): Scanner		//Sets this Scanner's delimiting pattern and returns this Scanner (Check below)
	 */
}
