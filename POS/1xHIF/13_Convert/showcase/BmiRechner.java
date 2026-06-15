import java.util.Scanner;

public class BmiRechner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib dein Gewicht in kg ein: ");
        String gewichtText = scanner.nextLine();
        gewichtText = gewichtText.replace(',', '.');
        double gewicht = Double.parseDouble(gewichtText);

        System.out.print("Gib deine Größe in Metern ein: ");
        String groesseText = scanner.nextLine();
        groesseText = groesseText.replace(',', '.');
        double groesse = Double.parseDouble(groesseText);

        double bmi = gewicht / (groesse * groesse);
        System.out.printf("Dein BMI: %.2f%n", bmi);

        String kategorie;
        if (bmi < 18.5) {
            kategorie = "Untergewicht";
        } else if (bmi < 25) {
            kategorie = "Normalgewicht";
        } else if (bmi < 30) {
            kategorie = "Übergewicht";
        } else {
            kategorie = "Adipositas";
        }
        System.out.println("Kategorie: " + kategorie);

        scanner.close();
    }
}
