import static Helper.Study.*;
import static Helper.ExampleClass.*;

public class Variables {

    public static void main(String[] args){

        printSection("Declarations and Initialization");

        // Syntax : type variableName = initialValue;

        int itemCount = 10;
        float approximatePi = 3.14f; // f makes this a float literal
        double approximateE = 2.71d; // d stands for deez nuts
        boolean rizz = false;
        char letterGrade = 'A';
        String studentName = "Chud";

        // Local variables need to be assigned a value before they can be read

        final int studentAge; // Declaration without initialization
        studentAge = 20;
        final int girlfriends = 0;
        // A final variable can be assigned only once and cannot be changed

        int R, G, B;
        R = G = B = 0;
        // R = 0, G = 0, B = 0
        print("RGB: " + R + ", " + G + ". " + B);

        printSection("Primitive values and reference values");

        // Primitive Types
        // byte, short, int, long, float, double, char, boolean
        // Reference Types
        // classes, interface and arrays
        // a reference can also be nul

        printSection("Local type inference with var");

        // var infers a fixed type from the initializer; it's not a dynamic type
        // It cannot be used for fields, method parameters, or an initializer of null alone

        var e = 2.71f;
        var Pair = new Point();
        var vowels = new String[]{"a", "u", "e", "o", "i"};

        printSection("Arrays");

        int[] array1 = {1, 2, 3};
        int[] array2 = new int[3];
        array2[0] = 4;
        array2[1] = 5;
        array2[2] = 6;

        // Arrays have fixed lengths and zero_based indices: 0 through length -1

        // Type Casting
        // Widening Casting  : byte -> short -> char -> int -> long -> float -> double
        // Narrowing Casting : double -> float -> long -> int -> char -> short -> byte

        int prime = 17;
        float primeFloat = prime;

        double decimal = 2.13d;
        int approximation = (int) decimal; // truncates toward zero

    }

}
