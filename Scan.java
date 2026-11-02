import java.util.Scanner;
import static Helper.Study.*;

/*
nextBoolean()	Reads a boolean value from the user
nextByte()	    Reads a byte value from the user
nextDouble()	Reads a double value from the user
nextFloat()  	Reads a float value from the user
nextInt()   	Reads a int value from the user
nextLine()	    Reads a String value from the user
nextLong()  	Reads a long value from the user
nextShort()  	Reads a short value from the user
*/

public class Scan {

    public static void main(String[] args){

        Scanner input =new Scanner(System.in);
        print("Input: ");

        // reads input as a string
        String first = input.nextLine();
        // reads input as an int
        int number = input.nextInt();

        print(first + "\n" + number);

    }
}
