import Helper.Study; // Line 198

import java.util.ArrayList;
import static Helper.Study.*;
import java.util.stream.Stream;

abstract class GeometricShape{

    private int x;
    private int y;
    private static int GeometricShapeCount = 0;

    abstract public String toString();

    GeometricShape(int x, int y){
        setX(x);
        setY(y);
        GeometricShapeCount++;
    }

    protected void setX(int x){
        this.x = x;
    }

    protected void setY(int y){
        this.y = y;
    }

    protected int getX(){
        return this.x;
    }

    protected int getY(){
        return this.y;
    }
}

class Circle extends GeometricShape{

    private int radius;

    Circle(int x, int y, int radius){
        super(x, y);
        this.radius = radius;
    }

    protected void setRadius(int radius){
        this.radius = radius;
    }

    @Override
    public String toString(){
        return "Circle(" + this.getX() + ", " + this.getY() + ", " + this.radius + ")";
    }

}

class Rectangle extends GeometricShape{

    private int length;
    private int width;

    Rectangle(int x, int y, int length, int width){
        super(x, y);
        this.length = length;
        this.width = width;
    }

    protected void setLength(int length){
        this.length = length;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected int getLength(){
        return this.length;
    }

    protected int getWidth(){
        return this.width;
    }

    @Override
    public String toString(){
        return "Rectangle(" + this.getX() + ", " + this.getY() + ", " + this.length + ", " + this.width + ")";
    }

}

@FunctionalInterface
interface Filter{
    boolean f(GeometricShape shape);
}

public class BuilderFactory {

    static boolean isSquare(GeometricShape shape){
        if (shape instanceof Rectangle){
            return ((Rectangle) shape).getLength() == ((Rectangle) shape).getWidth();
        } else {
            return false;
        }
    }

    static class ShapeBuilder{

        private String type;
        private int x = 0;
        private int y = 0;
        private int radius = 0;
        private int length = 0;
        private int width = 0;

        private GeometricShape BuildHelper() throws IllegalArgumentException{
            if (this.type == null){
                throw new IllegalArgumentException();
            } else {
                if (this.type.equalsIgnoreCase("circle")){
                    return new Circle(this.x, this.y, this.radius);
                } else if (this.type.equalsIgnoreCase("rectangle")){
                    return new Rectangle(this.x, this.y, this.length, this.width);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        protected GeometricShape Build(){
            GeometricShape output = BuildHelper();
            reset();
            return output;
        }

        protected void reset(){
            this.x = 0;
            this.y = 0;
            this.radius = 0;
            this.length = 0;
            this.width = 0;
            this.type = null;
        }

        protected ShapeBuilder setType(String type){
            this.type = type;
            return this;
        }

        protected ShapeBuilder setX(int x){
            this.x = x;
            return this;
        }

        protected ShapeBuilder setY(int y){
            this.y = y;
            return this;
        }

        protected ShapeBuilder setRadius(int radius){
            this.radius = radius;
            return this;
        }

        protected ShapeBuilder setLength(int length){
            this.length = length;
            return this;
        }

        protected ShapeBuilder setWidth(int width){
            this.width = width;
            return this;
        }

    }

    public static void main(){
        ArrayList<GeometricShape> list = new ArrayList<>();

        ShapeBuilder build = new ShapeBuilder();
        GeometricShape c1 = null;
        GeometricShape c2 = null;
        GeometricShape r1 = null;
        GeometricShape r2 = null;

        c1 = build.setX(1).setY(2).setRadius(3).setType("circle").Build();
        c2 = build.setX(2).setY(4).setRadius(6).setType("CIRCLE").Build();
        r1 = build.setX(-1).setY(0).setLength(2).setWidth(2).setType("Rectangle").Build();
        r2 = build.setX(4).setY(-4).setLength(3).setWidth(5).setType("Rectangle").Build();

        print(build.x + " " + build.y + " " + build.radius + " " + build.length + " " + build.width);

        list.add(c1);
        list.add(c2);
        list.add(r1);
        list.add(r2);

        list.forEach(Study::print);

        Filter isCircle = (shape) -> shape instanceof Circle;
        Filter isRectangle = (shape) -> shape instanceof Rectangle;

        Stream<GeometricShape> s1 = list.stream().filter(isCircle::f);
        Stream<GeometricShape> s2 = list.stream().filter(isRectangle::f);
        Stream<GeometricShape> s3 = list.stream().filter(BuilderFactory::isSquare);

        printSection("s1");
        s1.forEach(Study::print);
        printSection("s2");
        s2.forEach(System.out::println);
        printSection("s3");
        s3.forEach(obj -> print(obj));



    }
}
