public class PatternMatching {
    public static void main(String[] args) {
        var shapes = java.util.List.of(
            new Circle(5.0),
            new Rectangle(3.0, 4.0)
        );

        for (var shape : shapes) {
            if (shape instanceof Circle c) {
                System.out.println("Circle radius: " + c.radius() + ", area: " + c.area());
            } else if (shape instanceof Rectangle r) {
                System.out.println("Rectangle: " + r.width() + " x " + r.height() + ", area: " + r.area());
            }
        }
    }
}
