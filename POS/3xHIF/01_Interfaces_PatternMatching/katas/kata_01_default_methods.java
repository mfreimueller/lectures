public class DefaultMethods {
    public static void main(String[] args) {
        var animals = java.util.List.of(
            new Dog("Buddy"),
            new Cat("Luna"),
            new Robot("R2D2")
        );

        for (var animal : animals) {
            System.out.println(animal.name() + " says: " + animal.speak());
        }
    }
}
