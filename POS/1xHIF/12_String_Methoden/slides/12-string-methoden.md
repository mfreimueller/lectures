---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 12 - String Methoden
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: Strings
2. Strings sind Objekte
3. length() - Länge eines Strings
4. equals() - Strings vergleichen

---

## Agenda (2/3)

5. equals() vs. ==
6. charAt() - Zeichenzugriff
7. charAt() mit Schleife
8. startsWith() / endsWith()

---

## Agenda (3/3)

9. startsWith/endsWith: Beispiele
10. Methoden kombinieren
11. Beispiel: Textanalyse

---

## Lernziele

- Ich kann Strings als Objekte verstehen
- Ich kann wichtige String-Methoden (length, equals, charAt) anwenden
- Ich kann equals und == unterscheiden
- Ich kann String-Methoden kombinieren und eine Textanalyse durchführen

---

## Wiederholung: Strings

```java
String name = "Alice";
String gruss = "Hallo Welt!";

System.out.println(name);
System.out.println(gruss);
```

- Bisher: Strings als einfache Textvariablen
- Aber Strings können viel mehr — sie haben **Methoden**

---

## Partneraktivität: Wörter raten mit String-Methoden

<div class="highlight-box">
<p>Eine Person denkt an ein Wort, die andere stellt Ja/Nein-Fragen mit String-Methoden (z. B. «Beginnt es mit A?», «Ist es länger als 5 Zeichen?»). Erratet das Wort in maximal 5 Fragen. Wechselt dann die Rollen.</p>
</div>

---

## Strings sind Objekte

<div class="highlight-box">
<p>In Java ist <code>String</code> eine <strong>Klasse</strong> (kein primitiver Datentyp).</p>
<p>Jeder String ist ein <strong>Objekt</strong> mit eigenen <strong>Methoden</strong>.</p>
</div>

- Eine Methode wird mit einem Punkt aufgerufen: `string.method()`
- Beispiel: `"Hallo".length()` → 5

---

## length() - Länge eines Strings

```java
String text = "Hallo Welt!";
int laenge = text.length();
System.out.println(laenge);  // 11

// Leerer String:
String leer = "";
System.out.println(leer.length());  // 0

// Achtung: length() mit Klammern (Methode)!
// Bei Arrays: length ohne Klammern (Eigenschaft)
```

---

## equals() - Strings vergleichen

<div class="highlight-box">
<p><strong>Strings vergleicht man mit <code>equals()</code>, NICHT mit <code>==</code></strong></p>
</div>

```java
String a = "Hallo";
String b = "Hallo";
System.out.println(a.equals(b));   // true
String c = new String("Hallo");
System.out.println(a == c);        // false!
System.out.println(a.equals(c));   // true
```

---

## equals() vs. ==

- `==` vergleicht **Speicheradressen** (Referenzen)
- `equals()` vergleicht den **Inhalt** der Strings
- Zwei gleiche Wörter können unterschiedliche Speicheradressen haben
- **Faustregel:** Für Strings immer `equals()` verwenden!

---

## charAt() - Zeichenzugriff

```java
String text = "Java";
char c = text.charAt(0);  // 'J'
System.out.println(text.charAt(1));  // 'a'
System.out.println(text.charAt(2));  // 'v'
System.out.println(text.charAt(3));  // 'a'
// StringIndexOutOfBoundsException bei ungültigem Index!
```

- Wie bei Arrays: Der Index beginnt bei **0**

---

## charAt() mit Schleife

```java
String text = "Hallo";

// Jedes Zeichen einzeln ausgeben
for (int i = 0; i < text.length(); i++) {
    char c = text.charAt(i);
    System.out.println("Zeichen " + i + ": " + c);
}

// Ausgabe:
// Zeichen 0: H
// Zeichen 1: a
// Zeichen 2: l
// Zeichen 3: l
// Zeichen 4: o
```

---

## startsWith() / endsWith()

```java
String satz = "Hallo Welt!";
System.out.println(satz.startsWith("Hallo"));   // true
System.out.println(satz.startsWith("Welt"));    // false
System.out.println(satz.endsWith("!"));         // true
System.out.println(satz.endsWith("t"));         // false
```

- Beide Methoden geben `boolean` zurück (true/false)
- Nützlich für Textanalyse und Eingabevalidierung

---

## startsWith/endsWith: Beispiele

```java
// Prüfen, ob ein Befehl mit "gehe" beginnt
String befehl = "gehe norden";
if (befehl.startsWith("gehe")) {
    System.out.println("Bewegungsbefehl erkannt");
}
// Prüfen, ob ein Satz mit einem Fragezeichen endet
String frage = "Wie heißt du?";
if (frage.endsWith("?")) {
    System.out.println("Das ist eine Frage");
}
```

---

## Methoden kombinieren

```java
String text = "  Java Programmierung  ";
String bereinigt = text.trim().toUpperCase();
System.out.println(bereinigt);  // "JAVA PROGRAMMIERUNG"
// Schrittweise:
String getrimmt = text.trim();
String gross = getrimmt.toUpperCase();
```

- Viele String-Methoden geben einen neuen String zurück
- Methoden können **verkettet** werden (`text.trim().toUpperCase()`)

---

## Beispiel: Textanalyse

```java
String satz = "Wie heißt du?";

int laenge = satz.length();
char erstes = satz.charAt(0);
char letztes = satz.charAt(satz.length() - 1);
boolean istFrage = satz.endsWith("?");

System.out.println("Länge: " + laenge);
System.out.println("Erstes Zeichen: " + erstes);
System.out.println("Letztes Zeichen: " + letztes);
System.out.println("Ist eine Frage: " + istFrage);
```

---

## Katas

<div class="highlight-box">
<p>Löst die folgenden Katas in eurer Entwicklungsumgebung:</p>
<ul>
<li><strong>String-Länge</strong> – Bestimmt die Länge von Strings.</li>
<li><strong>Zeichen durchlaufen</strong> – Durchläuft Zeichen mit charAt.</li>
<li><strong>equals vs. ==</strong> – Vergleicht Strings mit equals und ==.</li>
<li><strong>startsWith / endsWith</strong> – Prüft String-Anfänge und -Enden.</li>
</ul>
</div>

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li><code>length()</code> — Länge eines Strings</li>
<li><code>equals()</code> — Inhalt vergleichen (nicht ==)</li>
<li><code>charAt(index)</code> — Zeichen an Position index</li>
<li><code>startsWith(präfix)</code> / <code>endsWith(suffix)</code> — boolean-Prüfung</li>
<li>Methoden können kombiniert werden</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Dungeon Crawler soll Spielerbefehle analysieren können. Der Spieler gibt Kommandos wie "gehe norden", "nimm Schlüssel", "kämpfe". Verwende String-Methoden.</p>
</div>
