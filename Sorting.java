import static Helper.Study.*;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.Iterator;

// We want to sort object, but we have aids
// Therefore we make sure our class implements Comparable<T> interface
// Array.sort( ... )
// Collections.sort( ... )
// Comparable interface has only one method
// int compareTo(T other);
// neg -> The object itself is smaller
// pos -> The object itself is bigger
// zero -> we all gonna die

class Student implements Comparable<Student>{

    final String name;
    int grade;
    static final Random r = new Random(67);

    Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString(){
        return this.name + " : " + this.grade;
    }

    @Override
    public int compareTo(Student other){
        return this.grade - other.grade;

        // this.grade - other.grade < 0 -> this < other
        // this.grade - other.grade = 0 -> this = other
        // this.grade - other.grade > 0 -> this > other
    }

    public static Student RandomStudentGenerator(){

        int bound = 'z' - 'a' + 1;
        int len = 3 + r.nextInt(5);
        String fname = "";

        for (int i = 0; i < len; i++){
            fname += (char) (r.nextInt(bound) + 'a');
        }

        return new Student(fname, r.nextInt(100) + 1);
    }

    public static Student[] RandomStudentArray(int len){
        Student[] output = new Student[len];

        for (int i = 0; i < len; i++){
            output[i] = Student.RandomStudentGenerator();
        }

        return output;

    }

    public static ArrayList<Student> RandomStudentList(int len){
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < len; i++){
            list.add(Student.RandomStudentGenerator());
        }
        return list;
    }

    public void change(){
        this.grade = r.nextInt(100) + 1;
    }

    public boolean StudentA(){
        return this.grade >= 86;
    }

    public boolean StudentF(){
        return this.grade < 50;
    }

}

public class Sorting {

    public static void main(String[] args){

        Student[] array1 = Student.RandomStudentArray(5);
        ArrayList<Student> list1 = Student.RandomStudentList(5);
        Iterator<Student> iter1 = list1.iterator();
        Stream<Student> stream1 = list1.stream();

        // printArray(array1);
        // printIndexed(list1);

        // Arrays.sort(array1);
        // Collections.sort(list1);

        // printArray(array1);
        // printIndexed(list1);

    }

}
