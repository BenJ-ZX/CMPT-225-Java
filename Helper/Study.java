package Helper;

import java.util.List;
import java.util.Random;

public final class Study{

    public static final double pi = 3.14d;

    private Study() {}

    // Draw a line with a title
    public static void printSection(String title){
        System.out.println("\n________" + title + "________\n");
    }

    // Overloading : same method name, different parameter lists.
    public static void printSection(){ System.out.println("\n________________\n"); }

    public static void print(Object obj){
        System.out.println(obj);
    }

    public static void printIndexed(Object[] elements){
        for (int index = 0; index < elements.length; index++){
            System.out.println("arg[" + index + "] = " + elements[index]);
        }
    }

    // Iterable<?> can hold elements of an unknown type, read here as Object
    public static void printIndexed(Iterable<?> elements){
        int index = 0;
        for (Object element : elements){
            System.out.println("arg[" + index + "] = " + element);
            index++;
        }
    }

    // List is also Iterable. This overload delegates to avoid duplicating logic
    public static void printIndexed(List<?> elements){

        printIndexed((Iterable<?>) elements);

        // for (int index = 0; index < elements.size(); index++){
        //    System.out.println("arg[" + index + "] = " + elements.get(index));
        // }
    }

    // Build an array of random integers of a certain length
    public static Integer[] buildRandomArray(int length){

        if (length < 0){
            throw new IllegalArgumentException("Arrat length must be non-negative");
        }

        Random random = new Random(60);
        Integer[] numbers = new Integer[length];

        for (int index = 0; index < length; index++){
            numbers[index] = random.nextInt(length);
        }

        return numbers;
    }

    // Build an array of random integers of length 10
    public static Integer[] buildRandomArray(){
        return buildRandomArray(10);
    }

    // print objects of an array in the form of (1, 2, 3, ...)
    public static void printArray(Object[] elements){
        System.out.print("( ");
        for (int index = 0; index < elements.length; index++){
            if (index > 0){
                System.out.print(", ");
            }
            System.out.print(elements[index]);
        }
        System.out.print(" )\n");
    }

    public static double Square(Number n){ return n.doubleValue() * n.doubleValue();}

}