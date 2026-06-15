import java.util.Scanner;

public class ReplDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("> ");
            String eingabe = scanner.nextLine().trim();
            String[] teile = eingabe.split(" ", 2);
            String befehl = teile[0].toLowerCase();

            switch (befehl) {
                case "echo":
                    if (teile.length > 1) {
                        System.out.println(teile[1]);
                    }
                    break;
                case "add":
                    if (teile.length > 1) {
                        String[] zahlen = teile[1].split(" ");
                        if (zahlen.length == 2) {
                            try {
                                double a = Double.parseDouble(zahlen[0]);
                                double b = Double.parseDouble(zahlen[1]);
                                System.out.println("= " + (a + b));
                            } catch (NumberFormatException e) {
                                System.out.println("Fehler: Ungültige Zahlen");
                            }
                        }
                    }
                    break;
                case "exit":
                    running = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Unbekannter Befehl: " + befehl);
                    break;
            }
        }

        scanner.close();
    }
}
