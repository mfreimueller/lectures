import java.util.Scanner;

public class MenuDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int auswahl;

        do {
            System.out.println("=== MENU ===");
            System.out.println("1: Option A");
            System.out.println("2: Option B");
            System.out.println("3: Option C");
            System.out.println("0: Beenden");
            System.out.print("Auswahl: ");
            auswahl = scanner.nextInt();

            if (auswahl == 1) {
                System.out.println("Option A ausgewaehlt");
            } else if (auswahl == 2) {
                System.out.println("Option B ausgewaehlt");
            } else if (auswahl == 3) {
                System.out.println("Option C ausgewaehlt");
            } else if (auswahl == 0) {
                System.out.println("Programm beendet.");
                break;
            } else {
                System.out.println("Ungueltige Auswahl!");
            }
        } while (auswahl != 0);

        scanner.close();
    }
}
