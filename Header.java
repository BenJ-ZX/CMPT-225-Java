// An interface defines a contract that implementing classes must satisfy

public interface Header {

    // Interface fields are implicitly public static final and need initializers
    int MINIMUM_VALUE = 0;

    // A method without a body is implicitly public abstract here
    int getMinimumValue();

    // A default method belongs to an instance; an implementing class may override it.
    // extends to the classes that implement it
    default void printMinimumValue() {
        printLabel();
        System.out.println(getMinimumValue());
    }

    // Private interface methods share implementation internally
    // They are not inherited by implementing classes and cannot be overridden
    private void printLabel() {
        System.out.print("Minimum value: ");
    }

    // Call this as Header.print(value). Static interface methods are not inherited
    // Static methods cannot be overridden
    static void print(Object obj) { System.out.print(obj); }
}
// Interfaces have no constructor or per-instance fields/
// Abstract classes can have constructors, instance fields, and concrete methods.
// Interface methods cannot be protected or package-private