import static Helper.Study.*;

public class Loops {

    public static void main(String[] args){

        Integer[] A = buildRandomArray();

        System.out.print("A = ");
        printArray(A);

        // if (cond1) { ... }
        // else if (cond2) { ... }
        // else if (cond3) { ... }
        // ...
        // else { ... }

        boolean cond1 = A[0] == 7;
        boolean cond2 = A[0] == 8;
        boolean cond3 = A[0] == 0;

        printSection("if / else if / else");

        if (cond1){
            print("First Cond");
        } else if (cond2) {
            print("Second Cond");
        } else if (cond3) {
            print("Third Cond");
        } else {
            print("Else case");
        }

        printSection("Switch");

        // This integer switch selects a matching case. With colon-style cases,
        // break prevents execution from falling through into the next case.
        // A String switch compares string contents, not reference identity.

        // switch (var){
        //      cond1: ...
        //      cond2: ...
        //      ...
        //      default: ...
        // }

        switch (A[0]) {
            case 7:
                print("First Cond");
                break;
            case 8:
                print("Second Cond");
                break;
            case 0:
                print("Third Cond");
                break;
            default:
                print("Default Case");
        }

        printSection("while: check before running");

        // while (cond) { ... }

        int j = 0;
        while (j < A.length) {
            print("numbers[" + j + "] = " + A[j]);
            j++;
        }

        printSection("do-while: run before checking");

        // do { ... } while (cond);
        // Run the block code at least once

        j = 0;
        do {
            j++;
            print("j: " + j);
        } while (j < 0);
        // This condition is false but the body still runs once

        printSection("For Loop");

        // for (var var_name : array_name) { ... }
        printSection("enhanced for : visit each element");
        for (int i : A){
            print(i);
        }

        printSection("Indexed for : visit every element");

        // for (statement1; statement2; statement3) { ... }
        // statement1 : run one time before execution
        // statement2 : condition for loop to run
        // statement3 : runs after each loop

        for (int i = 0; i < A.length; i = i + 2){
            System.out.print(" " + A[i] + " ");
        }

    }

}
