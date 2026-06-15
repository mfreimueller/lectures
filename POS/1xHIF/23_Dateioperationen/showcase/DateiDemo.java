import java.io.*;
import java.util.Scanner;

public class DateiDemo {

    public static void dateiLesen(String dateiname) {
        try (BufferedReader br = new BufferedReader(new FileReader(dateiname))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + dateiname);
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
    }

    public static void dateiSchreiben(String dateiname, String[] zeilen) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(dateiname))) {
            for (String zeile : zeilen) {
                pw.println(zeile);
            }
            System.out.println("Datei geschrieben: " + dateiname);
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    public static void dateiAnhaengen(String dateiname, String zeile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(dateiname, true))) {
            pw.println(zeile);
            System.out.println("Zeile angehaengt.");
        } catch (IOException e) {
            System.out.println("Fehler beim Anhaengen: " + e.getMessage());
        }
    }

    public static void dateiKopieren(String quelle, String ziel) {
        try (BufferedReader br = new BufferedReader(new FileReader(quelle));
             PrintWriter pw = new PrintWriter(new FileWriter(ziel))) {

            String line = br.readLine();
            while (line != null) {
                pw.println(line);
                line = br.readLine();
            }
            System.out.println("Datei kopiert von " + quelle + " nach " + ziel);

        } catch (FileNotFoundException e) {
            System.out.println("Quelldatei nicht gefunden: " + quelle);
        } catch (IOException e) {
            System.out.println("Fehler beim Kopieren: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Datei schreiben ===");
        String[] texte = {"Erste Zeile", "Zweite Zeile", "Dritte Zeile"};
        dateiSchreiben("demo.txt", texte);

        System.out.println("\n=== Datei lesen ===");
        dateiLesen("demo.txt");

        System.out.println("\n=== Datei anhaengen ===");
        dateiAnhaengen("demo.txt", "Vierte Zeile");

        System.out.println("\n=== Datei nach Anhaengen ===");
        dateiLesen("demo.txt");

        System.out.println("\n=== Datei kopieren ===");
        dateiKopieren("demo.txt", "kopie.txt");

        System.out.println("\n=== Kopie lesen ===");
        dateiLesen("kopie.txt");

        System.out.println("\n=== Nicht vorhandene Datei ===");
        dateiLesen("nicht_da.txt");
    }
}