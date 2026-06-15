import java.util.Scanner;

public class Wochentag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib eine Zahl (1-7) ein: ");
        int tag = scanner.nextInt();

        String name;
        switch (tag) {
            case 1:
                name = "Montag";
                break;
            case 2:
                name = "Dienstag";
                break;
            case 3:
                name = "Mittwoch";
                break;
            case 4:
                name = "Donnerstag";
                break;
            case 5:
                name = "Freitag";
                break;
            case 6:
                name = "Samstag";
                break;
            case 7:
                name = "Sonntag";
                break;
            default:
                name = "Ungültige Eingabe!";
                break;
        }
        System.out.println(name);

        scanner.close();
    }
}
