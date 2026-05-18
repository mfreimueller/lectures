# K2: Delay-Programmierung

**Konzepte:** Verz&ouml;gerungsschleife, LOOP, NOP, CX, verschachtelte Schleifen
**Dauer:** 15 min

---

## Aufgabe 1: Einfache Verz&ouml;gerung

Analysiere die folgende Verz&ouml;gerungsschleife:

```nasm
delay:
    MOV CX, 5000
loop_start:
    NOP
    LOOP loop_start
    RET
```

1. Wie oft wird die Schleife durchlaufen? ________
2. Welchen Befehl f&uuml;hrt CX beim ersten LOOP-Aufruf aus? ________
3. Was passiert, wenn CX = 0 ist? ________
4. Wozu dient der NOP-Befehl? ________

---

## Aufgabe 2: Verz&ouml;gerungszeit berechnen

Angenommen, ein NOP dauert 3 Taktzyklen und ein LOOP-Befehl dauert 5 Taktzyklen. Die CPU taktet mit 10 MHz (10.000.000 Takte pro Sekunde).

Berechne die Verz&ouml;gerungszeit f&uuml;r folgende Schleife:

```nasm
delay:
    MOV CX, 10000
loop_start:
    NOP
    LOOP loop_start
    RET
```

- Takte pro Durchlauf: ________ (NOP + LOOP)
- Gesamttakte: ________
- Zeit: ________ Sekunden

---

## Aufgabe 3: Verschachtelte Verz&ouml;gerung

Erg&auml;nze die folgende verschachtelte Verz&ouml;gerungsschleife, sodass die &auml;u&szlig;ere Schleife 20-mal durchlaufen wird:

```nasm
delay_long:
    MOV BX, ____      ; &Auml;u&szlig;erer Z&auml;hler (20 Durchl&auml;ufe)
outer_loop:
    MOV CX, 0FFFFh    ; Innerer Z&auml;hler (maximal)
inner_loop:
    NOP
    LOOP inner_loop
    ____ BX           ; BX dekrementieren
    ____ outer_loop   ; Springe, wenn BX != 0
    RET
```

---

## Aufgabe 4: Eigene Delay-Funktion

Schreibe eine vollst&auml;ndige Delay-Funktion, die:

- Mit einem Parameter in CX aufgerufen wird (Anzahl der Durchl&auml;ufe)
- Eine innere Schleife mit 0FFFFh Durchl&auml;ufen hat
- Nach Ablauf der &auml;u&szlig;eren Schleife zur&uuml;ckkehrt

```nasm
; Parameter: CX = Anzahl der &auml;u&szlig;eren Durchl&auml;ufe
custom_delay:
    ; Dein Code:


    RET
```

---

## Aufgabe 5: Kurzfragen

1. Warum reicht eine einzelne Schleife mit LOOP oft nicht f&uuml;r lange Verz&ouml;gerungen?

2. Welches Register wird von LOOP automatisch dekrementiert?

3. Wie kann man LOOP ersetzen, wenn man einen anderen Z&auml;hler (z. B. BX) verwenden m&ouml;chte?
