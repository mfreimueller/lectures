import java.util.Scanner;

public class TextAnalyseDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib einen Satz ein: ");
        String satz = scanner.nextLine();

        System.out.println("Laenge: " + satz.length());

        System.out.print("Erstes Zeichen: ");
        System.out.println(satz.charAt(0));

        System.out.print("Letztes Zeichen: ");
        System.out.println(satz.charAt(satz.length() - 1));

        int leerzeichen = 0;
        for (int i = 0; i < satz.length(); i++) {
            if (satz.charAt(i) == ' ') {
                leerzeichen++;
            }
        }
        System.out.println("Leerzeichen: " + leerzeichen);

        System.out.println("Beginnt mit \"Wie\": " + satz.startsWith("Wie"));
        System.out.println("Endet mit ?: " + satz.endsWith("?"));

        scanner.close();
    }
}
