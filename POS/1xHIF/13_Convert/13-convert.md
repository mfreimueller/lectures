---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 13 - Convert
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: String-Methoden
2. Warum Convert?
3. Integer.parseInt
4. Integer.parseInt - Beispiel

---

## Agenda (2/2)

5. Double.parseDouble
6. Double.parseDouble - Beispiel
7. Boolean.parseBoolean
8. Fehlerhafte Eingaben (Exceptions)

---

## Lernziele

- Ich kann Strings mit parseInt und parseDouble in andere Datentypen konvertieren
- Ich kann fehlerhafte Eingaben erkennen und behandeln

---

## Wiederholung: String-Methoden

- `length()` — Länge eines Strings
- `equals()` — Vergleich von Strings
- `charAt()` — Zeichen an einer Position
- `startsWith()` / `endsWith()` — Präfix/Suffix

---

## Partnerdiskussion: Was passiert bei falscher Eingabe?

<div class="highlight-box">
<p>Was passiert, wenn ein Benutzer «Hallo» eingibt, wo eine Zahl erwartet wird? Diskutiert: Soll das Programm abstürzen, nochmal fragen oder einen Standardwert verwenden? Was wäre in einer Banking-App die richtige Strategie?</p>
</div>

---

## Warum Convert?

- `Scanner.nextLine()` liefert immer einen `String`
- Für Berechnungen brauchen wir aber Zahlen (`int`, `double`)
- Lösung: Convert-Methoden wandeln Strings in Zahlen um

<div class="highlight-box">
<p><strong>Merke:</strong> Eingabe ist Text — Verarbeitung braucht Zahlen.</p>
</div>

---

## Integer.parseInt

- Wandelt einen `String` in einen `int`-Wert um
- Syntax: `int zahl = Integer.parseInt(text);`
- Der String muss eine gültige Ganzzahl enthalten (z. B. "42")
- Leerzeichen werden nicht automatisch entfernt

---

## Integer.parseInt - Beispiel

```java
System.out.print("Gib dein Alter ein: ");
String eingabe = scanner.nextLine();
int alter = Integer.parseInt(eingabe);

if (alter >= 18) {
    System.out.println("Volljährig");
} else {
    System.out.println("Nicht volljährig");
}
```

---

## Double.parseDouble

- Wandelt einen `String` in einen `double`-Wert um
- Syntax: `double zahl = Double.parseDouble(text);`
- Dezimaltrennzeichen ist der Punkt (wie im Englischen)
- Bei deutscher Eingabe (Komma) vorher ersetzen: `text.replace(',', '.')`

---

## Double.parseDouble - Beispiel

```java
System.out.print("Gib deine Größe in Metern ein: ");
String eingabe = scanner.nextLine();
eingabe = eingabe.replace(',', '.');
double groesse = Double.parseDouble(eingabe);

int zentimeter = (int) (groesse * 100);
System.out.println("Das sind " + zentimeter + " cm");
```

---

## Boolean.parseBoolean

- Wandelt einen `String` in einen `boolean`-Wert um
- Syntax: `boolean wert = Boolean.parseBoolean(text);`
- Gibt `true` nur bei `"true"` (Groß-/Kleinschreibung egal) zurück
- Bei allen anderen Eingaben: `false`

```java
String eingabe = scanner.nextLine();
boolean zustimmen = Boolean.parseBoolean(eingabe);
if (zustimmen) {
    System.out.println("Du stimmst zu.");
}
```

---

## Fehlerhafte Eingaben (Exceptions)

- Was passiert bei `Integer.parseInt("Hallo")`?
- Das Programm stürzt mit einer Exception ab!
- Exception = Fehler zur Laufzeit
- Später lernen wir `try-catch`, um Fehler abzufangen

<div class="highlight-box">
<p><strong>Merke:</strong> Ungültige Eingaben führen zu Programmabstürzen — fange sie ab!</p>
</div>

---

## Katas

<div class="highlight-box">
<p>Löst die folgenden Katas in eurer Entwicklungsumgebung:</p>
<ul>
<li><strong>String to Int</strong> – Wandelt Strings mit Integer.parseInt in int um.</li>
<li><strong>String to Double</strong> – Wandelt Strings mit Double.parseDouble in double um.</li>
<li><strong>Boolean.parseBoolean</strong> – Nutzt Boolean.parseBoolean für boolean-Werte.</li>
</ul>
</div>

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li><code>Integer.parseInt()</code> — String → int</li>
<li><code>Double.parseDouble()</code> — String → double</li>
<li><code>Boolean.parseBoolean()</code> — String → boolean</li>
<li>Bei ungültigen Eingaben: Exception (Programmabsturz)</li>
<li>Komma durch Punkt ersetzen bei deutscher Eingabe</li>
</ul>
</div>

---

## Ausblick

<div class="highlight-box"><p>Nächste Woche lernen wir <code>switch-case</code> kennen — eine übersichtliche Alternative zu langen <code>if</code>-<code>else</code>-Kaskaden.</p></div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Baue die Convert-Methoden in deinen Dungeon Crawler ein.</p>
</div>
