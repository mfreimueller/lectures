# K2: Erste Assembler-Befehle

**Konzepte:** MOV, ADD, SUB, JMP, CMP, Operanden, Syntax
**Dauer:** 15 min

---

## Aufgabe 1: Registerverfolgung (Tracing)

F&uuml;hre die folgende Befehlsequenz Schritt f&uuml;r Schritt aus. Trage nach jedem Befehl die aktuellen Werte der Register AX, BX, CX und DX ein.

Startwerte: AX = 0000h, BX = 0000h, CX = 0000h, DX = 0000h

```nasm
MOV AX, 10
MOV BX, 20
ADD AX, BX
MOV CX, 5
SUB BX, CX
MOV DX, AX
ADD DX, BX
```

| Schritt | Befehl          | AX    | BX    | CX    | DX    |
|---------|-----------------|-------|-------|-------|-------|
| 0       | (Start)         | 0000h | 0000h | 0000h | 0000h |
| 1       | MOV AX, 10      |       |       |       |       |
| 2       | MOV BX, 20      |       |       |       |       |
| 3       | ADD AX, BX      |       |       |       |       |
| 4       | MOV CX, 5       |       |       |       |       |
| 5       | SUB BX, CX      |       |       |       |       |
| 6       | MOV DX, AX      |       |       |       |       |
| 7       | ADD DX, BX      |       |       |       |       |

---

## Aufgabe 2: Ergebnisse bestimmen

Welcher Wert steht nach der Ausf&uuml;hrung in AX?

```nasm
MOV AX, 100
MOV BX, 50
SUB AX, BX
ADD AX, 25
```

Antwort: ________ (dezimal) / ________ (hexadezimal)

---

## Aufgabe 3: Befehl L&uuml;cken f&uuml;llen

Erg&auml;nze die fehlenden Befehle, sodass folgende Werte in den Registern stehen:

Ziel: AX = 42, BX = 42, CX = 84

```nasm
MOV AX, 42
____ BX, AX
MOV CX, AX
____ CX, BX
```

---

## Aufgabe 4: CMP und Sprung

Analysiere diesen Code. Was passiert, wenn AX = 10 ist? Was, wenn AX = 20 ist?

```nasm
MOV AX, 10
CMP AX, 15
JE  gleich
JMP ungleich

gleich:
    MOV BX, 1
    JMP ende

ungleich:
    MOV BX, 0

ende:
    RET
```

- AX = 10: BX = ____
- AX = 20: BX = ____
