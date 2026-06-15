/**
 * Ein einfaches Bankkonto mit Ein- und Auszahlungen.
 * Das Konto hat einen Kontoinhaber, einen Kontostand
 * und ein Überziehungslimit.
 *
 * @author Max Mustermann
 * @since 2024
 */
class Bankkonto {
    /** Der Name des Kontoinhabers */
    private String kontoinhaber;
    /** Der aktuelle Kontostand */
    private double kontostand;
    /** Das maximale Überziehungslimit (negativ) */
    private double ueberzugsLimit;

    /**
     * Erzeugt ein neues Bankkonto.
     *
     * @param kontoinhaber   Der Name des Kontoinhabers
     * @param ueberzugsLimit Das erlaubte Überziehungslimit
     */
    public Bankkonto(String kontoinhaber, double ueberzugsLimit) {
        this.kontoinhaber = kontoinhaber;
        this.kontostand = 0.0;
        this.ueberzugsLimit = ueberzugsLimit;
    }

    /**
     * Zahlt einen Betrag auf das Konto ein.
     *
     * @param betrag Der einzuzahlende Betrag (muss positiv sein)
     */
    public void einzahlen(double betrag) {
        if (betrag > 0) {
            kontostand += betrag;
        }
    }

    /**
     * Hebt einen Betrag vom Konto ab.
     *
     * @param betrag Der abzuhebende Betrag
     * @return true wenn die Abhebung erfolgreich war, sonst false
     */
    public boolean abheben(double betrag) {
        if (betrag > 0 && kontostand - betrag >= -ueberzugsLimit) {
            kontostand -= betrag;
            return true;
        }
        return false;
    }

    /**
     * Gibt den aktuellen Kontostand zurück.
     *
     * @return Der aktuelle Kontostand
     */
    public double getKontostand() {
        return kontostand;
    }
}

/**
 * Demo-Klasse zur Veranschaulichung von JavaDoc.
 *
 * @author Max Mustermann
 * @since 2024
 */
public class JavaDocDemo {

    /**
     * Berechnet die Summe aller Zahlen in einem Array.
     *
     * @param zahlen Ein Array mit ganzen Zahlen
     * @return Die Summe aller Elemente
     * @see java.util.Arrays
     */
    public static int summe(int[] zahlen) {
        int sum = 0;
        for (int z : zahlen) {
            sum += z;
        }
        return sum;
    }

    /**
     * Einstiegspunkt der Anwendung.
     *
     * @param args Kommandozeilen-Argumente (nicht verwendet)
     */
    public static void main(String[] args) {
        Bankkonto konto = new Bankkonto("Anna", 500);
        konto.einzahlen(1000);
        System.out.println("Kontostand: " + konto.getKontostand());

        int[] zahlen = {3, 7, 2, 9, 5};
        System.out.println("Summe: " + summe(zahlen));
    }
}