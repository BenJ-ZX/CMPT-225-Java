import static Helper.Study.*;

public class HelloWorld {

    public static void main(String[] args){
        print("Hello, World!");

        printSection();

        System.out.print("print does not add a newline. ");
        System.out.println("println adds one after its text. ");

        printSection();

        printIndexed(args);

        String upper_case = "Hello, World!";
        String lower_case = "hello, world!";
        print(upper_case.equalsIgnoreCase(lower_case));

    }

}

// Java always passes arguments by value.
// For primitives, the primitive value is copied.
// For objects, the reference value is copied—not the object.
// Objects and arrays are allocated on the heap.
// Method calls create stack frames containing parameters and local variables.
// A local reference variable refers to an object on the heap.
// Unlike typical C/C++ memory management, Java uses a garbage collector (GC)
// (It also stands for Get Cancer, which the compiler will tell you everytime it runs )
// to automatically reclaim heap memory from objects that are no longer reachable.

// cd ./src

// javac HelloWorld.java
// java -cp . HelloWorld
// java -cp out HelloWorld

// java HelloWorld.java *arguments_passed*

// java HelloWorld.java