# K3: Ampelschaltung

**Konzepte:** Zustandsautomat, IN/OUT, Delay, Port-Adressen, Bit-Muster
**Dauer:** 25 min

---

## Aufgabe 1: Bit-Muster bestimmen

Eine Ampel hat drei Lampen, die &uuml;ber ein Byte an Port 378h gesteuert werden:

| Bit | Lampe       |
|-----|-------------|
| 0   | Rot         |
| 1   | Gelb        |
| 2   | Gr&uuml;n   |

Gib das Bit-Muster (bin&auml;r und hexadezimal) f&uuml;r jeden Zustand an:

| Zustand        | Bin&auml;r (Bit 2-0) | Hexadezimal |
|----------------|----------------------|-------------|
| Aus (alle aus) | 000b                 | 00h         |
| Rot            | 001b                 | 01h         |
| Rot-Gelb       |                      |             |
| Gr&uuml;n      |                      |             |
| Gelb           |                      |             |

---

## Aufgabe 2: Programm-Code vervollst&auml;ndigen

Erg&auml;nze das folgende Programm f&uuml;r eine vollst&auml;ndige Ampelschaltung:

```nasm
ORG 100h

.DATA
    PORT EQU 378h
    rot    EQU 01h
    gelb   EQU ____
    gruen  EQU ____
    rotgelb EQU ____

.CODE
start:
    MOV DX, PORT

ampel_loop:
    ; Zustand Rot
    MOV AL, rot
    ____ DX, AL       ; Ausgabe an Port
    CALL delay_lang

    ; Zustand Rot-Gelb
    MOV AL, rotgelb
    OUT DX, AL
    CALL ____          ; kurze Verz&ouml;gerung

    ; Zustand Gr&uuml;n
    MOV AL, ____
    OUT DX, AL
    CALL delay_lang

    ; Zustand Gelb
    MOV AL, gelb
    OUT DX, AL
    CALL delay_kurz

    JMP ____           ; zur&uuml;ck zum Schleifenanfang

; Hilfsfunktionen
delay_kurz:
    MOV CX, 0FFFFh
kurz_loop:
    NOP
    ____ kurz_loop     ; LOOP-Befehl
    RET

delay_lang:
    MOV BX, 10
lang_outer:
    MOV CX, 0FFFFh
lang_inner:
    NOP
    LOOP lang_inner
    ____ BX            ; BX--
    ____ lang_outer    ; JNZ
    RET
```

---

## Aufgabe 3: Ampelschaltung mit Fu&szlig;g&auml;ngerampel

Erweitere die Ampelschaltung um eine Fu&szlig;g&auml;ngerampel, die zus&auml;tzlich an Port 379h angeschlossen ist (Bit 0 = Fu&szlig;g&auml;nger-Rot, Bit 1 = Fu&szlig;g&auml;nger-Gr&uuml;n).

Erg&auml;nze das Programm so, dass die Fu&szlig;g&auml;ngerampel immer gegenl&auml;ufig zur Hauptampel schaltet:

- Hauptampel Rot &rArr; Fu&szlig;g&auml;ngerampel Gr&uuml;n
- Hauptampel Gr&uuml;n &rArr; Fu&szlig;g&auml;ngerampel Rot

```nasm
; Deine L&ouml;sung:

```

---

## Aufgabe 4: Fehlersuche

Das folgende Programm soll eine Ampel steuern, hat aber Fehler. Finde und korrigiere sie.

```nasm
ORG 100h

.DATA
    PORT EQU 378h

.CODE
start:
    MOV DX, 378h

loop:
    OUT AL, DX       ; Fehler 1?
    MOV AL, 01h

    CALL delay

    JMP loop

delay:
    MOV CX, FFFFh
delay_loop:
    LOOP delay_loop
    RET
```

Fehler 1: ___________________________________________________

Fehler 2: ___________________________________________________

Fehler 3: ___________________________________________________

---

## Aufgabe 5: Reflexion

Beantworte kurz:

1. Welche Rolle spielt der OUT-Befehl in der Ampelschaltung?

2. Warum muss die Verz&ouml;gerungsschleife an die CPU-Taktfrequenz angepasst werden?

3. Was passiert, wenn der Z&auml;hler in der Delay-Schleife zu gro&szlig; oder zu klein ist?
