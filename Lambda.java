import java.util.ArrayList;
import static Helper.Study.*;

@FunctionalInterface
interface func<T>{
    // Could accept more parameters
    // void : because we are using for each (by ArrayList)
    void f(T x);
}

@FunctionalInterface
interface foo<A extends Number, B extends Number>{
    double g(A x, B y);
}

class Pair<T>{
    T first;
    T second;

    Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
}

class PairUpgrade<A extends Number, B extends Number>{

    A x;
    B y;

    PairUpgrade(A x, B y){
        this.x = x;
        this.y = y;
    }
    // ? super A -> A or any superclass of A
    // ? extend A -> A or any subclass of A
    // ? super A -> type represented by A and accepts broader type compared to
    // foo<A, B>
    // since composite takes two Number
    // Accepts an operation whose parameter types are A and B,
    // or supertypes of A and B, within foo's Number bounds.
    // For example, foo<Number, Number> can handle Double and Integer.
    double Action(foo<? super A, ? super B> operation){
        return operation.g(this.x, this.y);
    }

}


public class Lambda {

    public static void main(String[] args){
        // Syntax
        // (parameter1, parameter2) -> expression
        // (parameter1, parameter2) -> {
        //      code block
        //      return result;
        // }
        // Can be stored as a variable
        // A lambda needs a functional interface as its target type:
        // an interface with exactly one abstract method.

        func<Pair<Integer>> f = (x) -> print((x.first) * (x.second));
        ArrayList<Pair<Integer>> array = new ArrayList<>();
        array.add(new Pair<>(1,  2));
        array.add(new Pair<>(3,  4));
        array.add(new Pair<>(5,  6));
        array.forEach( (Pair) -> print(Pair.first + Pair.second));
        // array.forEach((Pair) -> f.f(Pair));
        // Method Referencing
        array.forEach(f::f);

        foo<Number, Number> g = (Number x, Number y) -> (x.doubleValue() * y.doubleValue());
        foo<Number, Number> h = (Number x, Number y) -> (x.doubleValue() + y.doubleValue());
        foo<Number, Number> composite = (x, y)-> {
            double temp = g.g(x, y);
            return h.g(temp, temp);
        };

        PairUpgrade<Double, Integer> obj = new PairUpgrade<>(2.5d, 4);
        print(obj.Action(composite));
    }

}
