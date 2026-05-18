# K1: Zustandsautomat Ampel

**Konzepte:** Zustandsautomat, Zust&auml;nde, &Uuml;berg&auml;nge, Port-Ausgabe
**Dauer:** 15 min

---

## Aufgabe 1: Zust&auml;nde definieren

Eine Fu&szlig;g&auml;nger-Ampel hat nur zwei Lampen: Rot und Gr&uuml;n. Erg&auml;nze die Tabelle.

| Zustand | Farbe            | Port-Bits (Bit0=Rot, Bit1=Gr&uuml;n) | Dauer (Sekunden) |
|---------|------------------|--------------------------------------|------------------|
| 0       | Rot              | 00000001b                            | 20               |
| 1       | Rot-Gr&uuml;n?   |                                      |                  |
| 2       | Gr&uuml;n         |                                      | 15               |
| 3       | Gr&uuml;n blinkt |                                      | 5                |

&Uuml;berlege: Gibt es bei einer Fu&szlig;g&auml;nger-Ampel &uuml;berhaupt einen Rot-Gr&uuml;n-Zustand? Zeichne den korrekten Ablauf.

---

## Aufgabe 2: Zustandsdiagramm zeichnen

Zeichne ein Zustandsdiagramm f&uuml;r eine Fu&szlig;g&auml;nger-Ampel mit folgenden Zust&auml;nden:

- **Rot** (Fu&szlig;g&auml;nger warten)
- **Gr&uuml;n** (Fu&szlig;g&auml;nger d&uuml;rfen gehen)
- **Gr&uuml;n blinkt** (Vorbereitung zum Wechsel)
- **Rot** (zur&uuml;ck zu Rot)

Verwende Pfeile f&uuml;r die &Uuml;berg&auml;nge und notiere die Bedingung (z. B. Timer abgelaufen).

```
   +-------+
   |       |
   +-------+
        |
        v
   +-------+
   |       |
   +-------+
        |
        v
   +-------+
   |       |
   +-------+
        |
        v
   +-------+
   |       |
   +-------+
```

---

## Aufgabe 3: Zustandstabelle f&uuml;r eine Kreuzung

Eine Kreuzung hat zwei Ampeln (Ampel 1 = Nord-S&uuml;d, Ampel 2 = Ost-West). Es gibt 4 Zust&auml;nde. Erg&auml;nze die Tabelle mit den korrekten Farben.

| Zustand | Ampel 1 (NS) | Ampel 2 (OW) | Dauer  |
|---------|--------------|--------------|--------|
| 0       | Rot          | Gr&uuml;n    | 30 s   |
| 1       |              |              | 3 s    |
| 2       | Gr&uuml;n    | Rot          | 30 s   |
| 3       |              |              | 3 s    |

---

## Aufgabe 4: Bedingungen & &Uuml;berg&auml;nge

Beantworte die folgenden Fragen:

1. Was l&ouml;st den &Uuml;bergang von einem Zustand zum n&auml;chsten aus?

2. Darf ein Zustandsautomat in den vorherigen Zustand zur&uuml;ckspringen?

3. Wie viele Zust&auml;nde hat eine einfache Fu&szlig;g&auml;nger-Ampel (ohne Blinken)?
