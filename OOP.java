import static Helper.Study.*;

// A class extends one superclass and can implement multiple interfaces
// A final class cannot be extended
// Only a nested class can be declared static (DUh?)
public class OOP extends AbstractClass implements Header, Cloneable {

    // Field Variables (Attributes)

    private int x;
    private int y;
    private int z;

    // A blank final instance field must be assigned during construction
    private final int initialSum;

    // final prevents replace this reference; array elements remain mutable
    final Integer[] savedNumbers = new Integer[3];
    static int createdObjectCount = 0;

    // Constructor
    public OOP(int x, int y, int z){
        super("A group of three numbers");

        // super( ... ) --> calls parents constructor
        // super has to be the first statement in the subclass constructor
        // 'this' distinguishes instance fields from parameters with the same names

        setNumbers(x, y, z);

        savedNumbers[0] = x; savedNumbers[1] = y; savedNumbers[2] = z;
        initialSum = x + y + z;

        createdObjectCount++;
        // createdGroupCount : not accessible (private)
    }

    // Constructor overloading:
    public OOP(int x, int y){
        this(x, y, 0);
    }

    // Method / Functions
    // Access-Modifier return_type method_name(*args)


    // public : accessible whenever the containing class is accessible (Like your MO...)
    public String getInfo(){
        return super.description + ": initial sum = " + getInitialSum() + ", current sum = " + getCurrentSum();
        // super.method() calls the superclass implementation of method(),
        // this.method() calls the class implementation of method()
    }

    // No access modifier means package-private: same package, not subpackages
    void printCurrentSum() {
        print(getCurrentSum());
    }

    // private : accessible only withing the declared class and outer classes
    private int getInitialSum(){
        return this.initialSum;
    }

    public int getCurrentSum(){
        return x + y + z;
    }

    // protected : same-package access, + subclass access with restrictions
    // on the receiver when the subclass is in another package
    protected void setNumbers(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // static method : belongs to the class no instant of an object is needed
    public static int getCreatedObjectCount(){
        return createdObjectCount;
    }

    // If not implemented -> checks if they reference to the same object
    // (Inherited from Object - superclass of every class)
    // '==' : operator checks if they reference to the same object
    public boolean equals(OOP other){
        return this.getInitialSum() == other.getInitialSum();
    }

    // Not implemented by default
    // The class need to implement cloneable
    // need to be overridden
    // Note: If there is an object which is a reference type then it need to be cloned separately
    // otherwise they will affect each other
    @Override
    public OOP clone(){
        try{
            // Not supported (next line) because the array is 'final'
            // cloned.savedNumbers = new Integer[3];
            return (OOP) super.clone();

        } catch (CloneNotSupportedException E){
            throw new AssertionError(E);
        }
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getMinimumValue(){
        return MINIMUM_VALUE;
    }

    public static void main(String[] args){

        OOP numberGroup = new OOP(1, 2, 3);
        OOP numberGroupClone = numberGroup.clone();

        print(numberGroup.getClass());
        print(numberGroup.getClass().getName());
        printIndexed(numberGroup.getClass().getDeclaredFields());

        print(numberGroup instanceof OOP);                 // Class itself
        print(numberGroup instanceof AbstractClass);       // Superclass
        print(numberGroup instanceof Header);              // Implementation

        printSection("Fields, constructors, and inherited methods");
        numberGroup.printDescription();
        print(numberGroup.getInfo());
        printArray(numberGroup.savedNumbers);

        printSection("Initial state versus current state");
        numberGroup.setNumbers(4, 5, 6);
        numberGroup.setDescription("Updated number group");
        print(numberGroup.getInfo());
        numberGroup.printCurrentSum();

        printSection("Interfaces and static methods");
        numberGroup.printMinimumValue();
        Header.print("Objects created: ");
        print(OOP.getCreatedObjectCount());
        print("Groups Created: " + AbstractClass.getCreatedGroupCount());

        OOP numberGroup2 = new OOP(7, 8, 9);
        Header.print("Objects created: ");
        print(numberGroup.getCreatedObjectCount());
        print("Groups Created: " + numberGroup2.getCreatedGroupCount());

    }

}
