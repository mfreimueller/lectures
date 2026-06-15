public class ShowcaseMiniCalculator {
    public static void main(String[] args) {
        int a = 15;
        int b = 4;

        System.out.println("=== Mini Calculator ===");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();

        System.out.println("Addition: " + a + " + " + b + " = " + (a + b));
        System.out.println("Subtraktion: " + a + " - " + b + " = " + (a - b));
        System.out.println("Multiplikation: " + a + " * " + b + " = " + (a * b));
        System.out.println();

        System.out.println("int-Division: " + a + " / " + b + " = " + (a / b));

        double c = 15.0;
        double d = 4.0;
        System.out.println("double-Division: " + c + " / " + d + " = " + (c / d));

        System.out.println();
        System.out.println("Merke: int / int = int (Nachkommastellen fallen weg)");
    }
}
