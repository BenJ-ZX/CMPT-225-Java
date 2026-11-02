import static Helper.Study.*;
import java.util.ArrayList;
/*
Java Wrapper Classes

Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.
The table below shows the primitive type and the equivalent wrapper class:

Primitive Data Type	        Wrapper Class
byte	                        Byte
short                       	Short
int	                            Integer
long	                        Long
float                       	Float
double                      	Double
boolean	                        Boolean
char	                        Character
*/

// Generics allow you to write classes, interfaces, and methods that work with different data types
// without having to specify the exact type in advance.

// Generic Class
// extends Number : Integer, Double, Float
class Box<T extends Number>{

    T node;

    Box (T node){
        this.node = node;
    }

    T getNode(){
        return this.node;
    }

    void setNode(T node){
        this.node = node;
    }

    // Generic Method
    // Java automatically identify the type of elements in array
    public static <E> void printArray(E[] array){
        for (E obj : array){
            System.out.print(" " + obj + " ");
        }
        System.out.print("\n");
    }

    // ? : wildcard -> when we don't know the exact type
    public static void printBox(Box<?> B){
        print(B.getNode());
    }

    public static double Sum(ArrayList<? extends Number> array){
        double i = 0.0d;
        for (Number j : array){
            i += j.doubleValue();
        }
        return i;
    }

}

// Can have multiple types
class Dict<A, B> {
    A key;
    B value;

    Dict(A key, B value){
        this.key = key;
        this.value = value;
    }
}

public class Wrapper {

    public static void main(String[] args){
        Box<Integer> num = new Box<>(5);
        Box<Double> price = new Box<>(2.5d);
        // Box<String> txt = new Box<String>("Hello, World");

        print(num.getNode());
        print(price.getNode());
        // print(txt.getNode());

        num.setNode(10);
        price.setNode(7.5);
        // txt.setNode("Bye, World!");

        print(num.getNode());
        print(price.getNode());
        // print(txt.getNode());

        Integer[] numbers = {1, 2, 3, 4, 5};
        String[] vowels = {"a", "e", "i", "o", "u"};

        Box.printArray(numbers);
        Box.printArray(vowels);


        ArrayList<Number> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<Number> list2 = new ArrayList<>();
        list2.add(1.5);
        list2.add(2.5);
        list2.add(3.5);
        printIndexed(list);
        print(Box.Sum(list));
        print(Box.Sum(list2));

    }
}
