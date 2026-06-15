import java.util.Scanner;
import java.util.Random;

public class ShowcaseZahlenraten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int geheimzahl = random.nextInt(10) + 1;

        System.out.println("=== Zahlenraten ===");
        System.out.println("Ich habe eine Zahl zwischen 1 und 10 gewaehlt.");

        System.out.print("Dein Tipp: ");
        int tipp = scanner.nextInt();

        System.out.println();
        System.out.println("Geheimzahl: " + geheimzahl);

        if (tipp == geheimzahl) {
            System.out.println("Richtig! Du hast gewonnen!");
        } else if (tipp < geheimzahl) {
            System.out.println("Falsch. Dein Tipp war zu niedrig.");
        } else {
            System.out.println("Falsch. Dein Tipp war zu hoch.");
        }
    }
}
