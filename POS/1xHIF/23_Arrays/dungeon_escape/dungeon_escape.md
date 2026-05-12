# Dungeon Escape - Woche 23: Array-basierte Raum-Verweise

## Aufgabe

Ersetze die vier einzelnen Richtungs-Attribute (norden, sueden, osten, westen) in der Klasse Raum durch ein Array vom Typ `Raum[4]`.

### Anforderungen

1. **Index-Konstanten**
   Definiere in der Klasse Raum folgende Konstanten:
   ```java
   public static final int NORDEN = 0;
   public static final int SUEDEN = 1;
   public static final int OSTEN = 2;
   public static final int WESTEN = 3;
   ```

2. **Array fur Ausgange**
   ```java
   private Raum[] ausgaenge = new Raum[4];
   ```

3. **Methoden**
   - `void setAusgang(int richtung, Raum raum)`: Setzt den Ausgang in die angegebene Richtung
   - `Raum getAusgang(int richtung)`: Gibt den Raum in der angegebenen Richtung zuruck (oder null)
   - `boolean hatAusgang(int richtung)`: Gibt true zuruck, wenn in dieser Richtung ein Ausgang existiert
   - `String getAusgaenge()`: Gibt einen String mit allen verfugbaren Richtungen zuruck (z. B. "Norden, Osten")

4. **Spieler anpassen**
   - Passe `geheNorden()`, `geheSueden()`, `geheOsten()`, `geheWesten()` an, um die neuen Methoden zu verwenden
   - Beispiel: `aktuellerRaum.getAusgang(Raum.NORDEN)` statt `aktuellerRaum.getNorden()`

### Beispiel

```java
// Vorher:
start.setNorden(wald);
wald.setSueden(start);

// Nachher:
start.setAusgang(Raum.NORDEN, wald);
wald.setAusgang(Raum.SUEDEN, start);

// Navigation:
if (aktuellerRaum.hatAusgang(Raum.NORDEN)) {
    aktuellerRaum = aktuellerRaum.getAusgang(Raum.NORDEN);
}
```
