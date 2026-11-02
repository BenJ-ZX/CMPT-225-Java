package Helper;

@FunctionalInterface
public interface RandomObject<T>{
    T build();

    RandomObject<ExampleClass.Point> PointBuild = ExampleClass.Point::Build;
    RandomObject<ExampleClass.Circle> CircleBuild = ExampleClass.Circle::Build;
    RandomObject<ExampleClass.Rectangle> RectangleBuild = ExampleClass.Rectangle::Build;
}
