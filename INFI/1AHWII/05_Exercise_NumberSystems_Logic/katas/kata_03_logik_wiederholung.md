# Kata 3: Logik-Wiederholung

## Ziel
Das Erstellen von Wahrheitstabellen und die Anwendung der De Morganschen Gesetze wiederholen.

## Aufgabenstellung
1. Erstelle eine Wahrheitstabelle für den Ausdruck $(A \land B) \lor (\lnot C)$.

2. Erstelle eine Wahrheitstabelle für den Ausdruck $(A \lor B) \land (A \lor C)$ und zeige, dass er äquivalent zu $A \lor (B \land C)$ ist.

3. Wende die De Morganschen Gesetze an, um folgende Ausdrücke umzuformen:
   - $\lnot (A \land B)$
   - $\lnot (A \lor (B \land C))$
   - $\lnot (\lnot A \lor B)$

## Hinweise
- Die Tabelle hat $2^n$ Zeilen, wobei $n$ die Anzahl der Variablen ist.
- Arbeite Schritt für Schritt: Berechne zuerst die inneren Ausdrücke.
- Bei De Morgan: Negation "verteilen", UND ↔ ODER tauschen.
- Beispiel: $\lnot (A \land B) \equiv (\lnot A) \lor (\lnot B)$.
