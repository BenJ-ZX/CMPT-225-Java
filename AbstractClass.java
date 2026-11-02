import static Helper.Study.*;

// A superclass that supplies shared state and requires a subclass operation

public abstract class AbstractClass {

    protected String description;
    private static int createdGroupCount = 0;

    // Note: a 'final' abstract class field variable need to be initialized in the abstract class constructor

    // An abstract class cannot be instantiated directly, but its constructor
    // runs when a concrete subclass is instantiated.

    protected AbstractClass(String description){
        this.description = description;
        createdGroupCount++;
    }

    protected void printDescription() { print("Description: " + description);}

    // Static state is shared by instances, including instances of subclasses (and obviously their class)
    public static int getCreatedGroupCount() {return createdGroupCount; }

    // Fields cannot be abstract. An abstract method has no body;
    // A concrete subclass must implement its inherited abstract methods
    // need to declare 'abstract'
    public abstract void setDescription(String description);
    // public void setDescription()

}
