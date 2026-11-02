package Helper;

@FunctionalInterface
public interface CompareFunction<T>{
    int CompareBy(T self, T other);

    CompareFunction<ExampleClass.Point> CompareByDistance =
            (ExampleClass.Point self, ExampleClass.Point other)
                    -> (self.getDistance().compareTo(other.getDistance()));

    CompareFunction<ExampleClass.Point> CompareByX =
            (ExampleClass.Point self, ExampleClass.Point other)
                    -> (self.getX().compareTo(other.getX()));

    CompareFunction<ExampleClass.Point> CompareByY =
            (ExampleClass.Point self, ExampleClass.Point other)
                    -> (self.getY().compareTo(other.getY()));

    CompareFunction<ExampleClass.GeometricShape> CompareByArea =
            (ExampleClass.GeometricShape self, ExampleClass.GeometricShape other)
                    -> (self.getArea().compareTo(other.getArea()));

    CompareFunction<ExampleClass.GeometricShape> CompareByPerimeter =
            (ExampleClass.GeometricShape self, ExampleClass.GeometricShape other)
                    -> (self.getPerimeter().compareTo(other.getPerimeter()));
}