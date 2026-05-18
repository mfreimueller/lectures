# K3: Einfaches Programm

**Konzepte:** ORG, .DATA, .CODE, DB/DW, Label, INT 21h, RET
**Dauer:** 20 min

---

## Aufgabe 1: Programm vervollst&auml;ndigen

Das folgende Assembler-Programm soll die Werte 15 und 27 addieren und das Ergebnis in einer Variable speichern. Erg&auml;nze die fehlenden Teile.

```nasm
ORG 100h

.DATA
    zahl1 DB 15
    zahl2 DB ____
    ergebnis DW ____

.CODE
start:
    MOV AL, [zahl1]
    ____ AL, [zahl2]
    MOV [ergebnis], AX

    MOV AH, 4Ch
    INT 21h
```

---

## Aufgabe 2: Eigenes Programm schreiben

Schreibe ein vollst&auml;ndiges Assembler-Programm, das:

1. Drei Zahlen (10, 20, 30) im Datensegment als DB definiert
2. Die Summe der drei Zahlen berechnet
3. Das Ergebnis in einer Variable `summe` (DW) speichert
4. Das Programm mit INT 21h beendet

```nasm
; Schreibe dein Programm hier:


```

---

## Aufgabe 3: Programm analysieren

Analysiere das folgende Programm. Was steht am Ende in CX?

```nasm
ORG 100h

.DATA
    a DB 5
    b DB 3

.CODE
start:
    MOV AL, [a]
    MOV BL, [b]
    ADD AL, BL
    MOV CL, AL
    SUB CL, 2
    MOV CH, 0

    MOV AH, 4Ch
    INT 21h
```

Ergebnis: CX = ________ (dezimal)

---

## Aufgabe 4: Fehler finden

Das folgende Programm enth&auml;lt drei Fehler. Markiere sie und schreibe die korrigierte Version.

```nasm
ORG 100h

DATA
    wert DB 100

CODE
start:
    MOV AX, wert
    ADD AX, 50
    MOV [wert], AX

    MOV AH, 4Ch
    INT 21h
```

Fehler 1: ___________________________________________________

Fehler 2: ___________________________________________________

Fehler 3: ___________________________________________________
