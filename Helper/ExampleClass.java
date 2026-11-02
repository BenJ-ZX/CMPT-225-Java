package Helper;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public final class ExampleClass {

    public static class Point implements Comparable<Point>{

        // Constructor
        public Point (Number x, Number y){
            this.x = x;
            this.y = y;
            updateDistance();
        }
        public Point() {this(0,0);}

        /* Instance Variables */

        private Number x;
        private Number y;
        private Double distance;

        /* Instance Methods */

        // Get Instance Attributes
        public Double getX(){ return this.x.doubleValue();}
        public Double getY(){ return this.y.doubleValue();}
        public Double getDistance(){ return this.distance;}

        // Set Instance Attributes
        public void setX(Number x){ this.x = x;updateDistance();}
        public void setY(Number y){ this.y = y;updateDistance();}

        @Override
        public int compareTo(Point other){
            return ComparePoint.CompareBy(this, other);
        }

        public String toString(){
            return "(" + this.x + ", " + this.y + ") -> " + this.distance;
        }

        // Helper
        private void updateDistance(){
            this.distance = Math.sqrt(Study.Square(this.x) + Study.Square(this.y));
        }

        /* Static Variables */

        // CompareFunction
        private static CompareFunction<Point> ComparePoint;

        // Random Generator Variables
        private static Random r;
        private static int bound;

        /* Static Method */

        // Set CompareFunction
        public static void setComparePoint(CompareFunction<Point> CompareFunc){
            ComparePoint = CompareFunc;
        }

        // Set Seed
        public static void setSeed(int seed, int bound){
            Point.r = new Random(seed);
            Point.bound = bound;
        }

        // Random Generator
        public static Point Build(){ return new Point(nextInt(), nextInt());}

        // Helper
        private static Integer nextInt(){
            return Point.r.nextInt(bound);
        }

    }

    public abstract static class GeometricShape{

        // Constructor
        protected GeometricShape(Number x, Number y){
            this.centre = new Point(x, y);
            GeometricShapeCount++;
        }
        protected GeometricShape(Point centre){
            this.centre = centre;
            GeometricShapeCount++;
        }

        /* Instance Variables */
        private Point centre;

        // Set Instance Attributes
        protected void moveTo(Number x, Number y){
            centre.setX(x);
            centre.setY(y);
        }
        protected void moveTo(Point newPoint){ this.centre = newPoint;}

        // Get Instance Attributes
        protected Point getCentre(){ return this.centre; }

        /* Static Variables */
        private static int GeometricShapeCount = 0;

        /* Static Methods */
        public static int numberOfGeometricShapes() {return GeometricShapeCount;}

        // Abstract
        abstract public Double getArea();
        abstract public Double getPerimeter();

    }

    public static class Circle extends GeometricShape implements Comparable<Circle>{

        // Constructors
        public Circle(Number x, Number y, Number radius){
            super(x, y);
            this.radius = radius;
            CircleShapeCount++;
        }
        public Circle(Point centre, Number radius){
            super(centre);
            this.radius = radius;
            CircleShapeCount++;
        }

        /* Instance Variables */
        private Number radius;

        /* Instance Method */

        // Get Instance Attributes
        public Number getRadius(){ return this.radius;}

        // Set Instance Attributes
        public void setRadius(Number radius){
            this.radius = radius;
        }

        // Circle Properties
        @Override
        public Double getArea(){
            return Study.pi * Study.Square(this.getRadius());
        }
        @Override
        public Double getPerimeter(){
            return 2 * Study.pi * this.getRadius().doubleValue();
        }

        @Override public int compareTo(Circle other){
            return CompareCircle.CompareBy(this, other);
        }

        public String toString(){
            return "Circle( " +
                    this.getCentre().toString() + ", " + this.getRadius() + ")";
        }

        /* Static Variables */

        private static int CircleShapeCount = 0;

        // CompareFunction
        private static CompareFunction<Circle> CompareCircle;

        // Random Generator Variables
        private static Random r;
        private static int bound;

        /* Static Methods */

        public static int getCircleShapeCount() {return CircleShapeCount;}

        // set CompareFunction
        public static void setCompareCircle(CompareFunction<Circle> CompareFunc){
            CompareCircle = CompareFunc;
        }

        // set Seed
        public static void setSeed(int seed, int bound){
            Circle.r = new Random(seed);
            Circle.bound = bound;
        }

        // Random Generator
        public static Circle Build(){
            return new Circle(Point.Build(), Circle.nextInt());
        }

        // Helper
        private static Integer nextInt(){
            return Circle.r.nextInt(Circle.bound);
        }

    }

    public static class Rectangle extends GeometricShape implements Comparable<Rectangle>{

        // Constructor
        public Rectangle(Number x, Number y, Number length, Number width){
            super(x, y);
            this.length = length;
            this.width = width;
            RectangleShapeCount++;
        }
        public Rectangle(Point centre, Number length, Number width){
            super(centre);
            this.length = length;
            this.width = width;
            RectangleShapeCount++;
        }

        /* Instance Variables */
        private Number length;
        private Number width;

        /* Instance Methods */

        // Get Instance Attributes
        public Number getLength(){ return this.length; }
        public Number getWidth() {return this.width; }

        // Set Instance Attributes
        public void setLength(Number length){ this.length = length; }
        public void setWidth(Number width){ this.width = width;}

        // Rectangle Properties
        @Override
        public Double getArea(){ return this.length.doubleValue() * this.width.doubleValue();}
        @Override
        public Double getPerimeter(){ return 2 * (this.length.doubleValue() + this.width.doubleValue());}

        @Override
        public int compareTo(Rectangle other){
            return CompareRectangle.CompareBy(this, other);
        }

        public String toString(){
            return "Rectangle( " + this.getCentre().toString() + ", "
                    + this.getLength() + ", " + this.getWidth() + " )";
        }

        /* Static Variables */

        private static int RectangleShapeCount = 0;

        // CompareFunction
        private static CompareFunction<Rectangle> CompareRectangle;

        // Random Generator Variables
        private static Random r;
        private static int bound;

        /* Static Methods */

        public static int getRectangleShapeCount() {return RectangleShapeCount;}

        // Set CompareFunction
        public static void setCompareRectangle(CompareFunction<Rectangle> CompareFunc){
            CompareRectangle = CompareFunc;
        }

        // Set Seed
        public static void setSeed(int seed, int bound){
            Rectangle.r = new Random(seed);
            Rectangle.bound = bound;
        }

        // Random Generator
        public static Rectangle Build(){
            return new Rectangle(Point.Build(), Rectangle.nextInt(), Rectangle.nextInt());
        }

        // Helper
        private static Integer nextInt(){
            return Rectangle.r.nextInt(Rectangle.bound);
        }
    }

    public static <T> ArrayList<T> RandomGeometricList(RandomObject<T> func, int len){
        ArrayList<T> output = new ArrayList<>();
        for (int i = 0; i < len; i++){
            output.add(func.build());
        }
        return output;
    }

    public static void main(String[] args){

//        Point.setSeed(67, 20);
//        Circle.setSeed(67, 10);
//        Rectangle.setSeed(67, 15);
//        ArrayList<Point> PointList = RandomGeometricList(RandomObject.PointBuild, 10);
//        ArrayList<Circle> CircleList = RandomGeometricList(RandomObject.CircleBuild, 10);
//        ArrayList<Rectangle> RectangleList = RandomGeometricList(RandomObject.RectangleBuild, 10);
//
//        Study.printIndexed(PointList);
//        Study.printSection();
//
//        Point.setComparePoint(CompareFunction.CompareByDistance);
//        Collections.sort(PointList);
//
//        Study.printIndexed(PointList);

    }
}
