public class PatternSwitchRefactoring {
    public static void main(String[] args) {
        var shapes = java.util.List.of(
            new CircleRef(5.0),
            new RectangleRef(3.0, 4.0)
        );

        for (var shape : shapes) {
            System.out.println("Area: " + calculateArea(shape));
        }
    }

    static double calculateArea(ShapeRef shape) {
        return switch (shape) {
            case CircleRef c -> Math.PI * c.radius() * c.radius();
            case RectangleRef r -> r.width() * r.height();
        };
    }
}
