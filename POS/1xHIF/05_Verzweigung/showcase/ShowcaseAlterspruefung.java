public class ShowcaseAlterspruefung {
    public static void main(String[] args) {
        int alter = 16;

        System.out.println("Alter: " + alter);

        if (alter >= 18) {
            System.out.println("Volljaehrig.");
            System.out.println("Du darfst waehlen und Auto fahren.");
        } else if (alter >= 16) {
            System.out.println("Jugendlich.");
            System.out.println("Du darfst ab 16 waehlen, aber noch kein Auto fahren.");
        } else if (alter >= 14) {
            System.out.println("Teenager.");
            System.out.println("Du darfst ab 14 leichte Arbeiten ausfuehren.");
        } else {
            System.out.println("Kind.");
            System.out.println("Du bist noch unter 14 Jahre alt.");
        }
    }
}
