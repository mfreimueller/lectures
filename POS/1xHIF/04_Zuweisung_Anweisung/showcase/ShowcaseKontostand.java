public class ShowcaseKontostand {
    public static void main(String[] args) {
        double konto = 1000.0;
        int transaktionen = 0;

        System.out.println("=== Kontostand-Simulation ===");
        System.out.println("Start: " + konto + " EUR");
        System.out.println();

        konto += 250.0;
        transaktionen++;
        System.out.println("Nach Einzahlung (+250): " + konto + " EUR");

        konto -= 80.0;
        transaktionen++;
        System.out.println("Nach Auszahlung (-80): " + konto + " EUR");

        konto *= 1.02;
        transaktionen++;
        System.out.println("Nach Zinsen (x1.02): " + konto + " EUR");

        konto -= 5.50;
        transaktionen++;
        System.out.println("Nach Gebuehren (-5.50): " + konto + " EUR");

        System.out.println();
        System.out.println("Endstand: " + konto + " EUR");
        System.out.println("Transaktionen: " + transaktionen);
    }
}
