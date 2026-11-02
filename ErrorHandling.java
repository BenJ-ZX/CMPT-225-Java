import static Helper.Study.*;

/*
ArithmeticError	Occurs when a numeric calculation goes wrong
ArrayIndexOutOfBoundsException	Occurs when trying to access an index number that does not exist in an array
ClassNotFoundException	Occurs when trying to access a class that does not exist
FileNotFoundException	Occurs when a file cannot be accessed
InputMismatchException	Occurs when entering wrong input (e.g. text in a numerical input)
IOException	Occurs when an input or output operation fails
NullPointerException	Occurs when trying to access an object referece that is null
NumberFormatException	Occurs when it is not possible to convert a specified string to a numeric type
StringIndexOutOfBoundsException	Occurs when trying to access a character in a String that does not exist
*/

// LowIQException<T> not allowed
class LowIQException extends Exception{

    // Not allowed since the super constructor needs to be called first
    // final String msg = "This Programmer is RETARDED!!!";

    int num;

    protected static String msg(){
        return "This Programmer is RETARDED!!!";
    }

    LowIQException(){
        this(msg());
    }

    LowIQException(String error){
        // Pass a message to exception
        super(error);
    }

    LowIQException(int i){
        this(msg() + " Cannot Divide by " + i);
        this.num = i;
    }
}


public class ErrorHandling {

    private static int f(int x, int y){
        if (x < 0 && y < 0){
            throw new ArithmeticException("Cannot allow two negative integers as input cause Fuck you");
        } else {
            return x * y;
        }
    }

    private static int g(int x, int y) throws LowIQException{
        if (y == 0){
            throw new LowIQException(y);
        } else {
            return x / y;
        }
    }

    public static void main(String[] args){

        int x = 5;
        print("First Line");

        int y;
        x = 10;

        print("Second Line");

        int z = f(x, y = 5);
        int w = f(y = 6, x);

        print(z + "\n" + w);

        try{

            int[] array = new int[3];
            // print("LOL".charAt(5)); // Triggers StringIndexOutOfBoundsException
            // print(array[10]); // Triggers ArrayIndexOutOfBoundsException

        } catch (ArrayIndexOutOfBoundsException e) {

            print("ArrayIndeOutOfBoundsException");

        } catch (ArithmeticException e) {

            print("ArithmaticException");

        } catch (StringIndexOutOfBoundsException | NullPointerException e){ // two case

            print(new NullPointerException("you are retarded"));

        } catch (Exception e){ // General Error

            print(e);

        } finally {

            print("Try-Catch block finished");

        }

        // int u = f(-1, -2);
        printSection("Custom Exception");
        try {
            int v = g(2, 0);
        } catch (LowIQException e){
            print(LowIQException.msg());
            print(e.toString());
            print(e.num);

            StackTraceElement[] s = e.getStackTrace();
            printIndexed(s);

            // e.printStackTrace(); -> red message

            //for (StackTraceElement elt : s){
            //    print(elt.toString());
            //}

        }
    }

}
