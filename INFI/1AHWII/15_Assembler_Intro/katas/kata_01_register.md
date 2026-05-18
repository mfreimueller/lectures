# K1: Register kennenlernen

**Konzepte:** CPU-Register, AX/BX/CX/DX, IP, SP, Flags, High/Low-Byte
**Dauer:** 15 min

---

## Aufgabe 1: Register-Tabelle ausf&uuml;llen

Erg&auml;nze die folgende Tabelle mit den wichtigsten x86-Registern:

| Register | Gr&ouml;&szlig;e (Bit) | Typ | Kurzbeschreibung |
|----------|---------------------|-----|------------------|
| AX       | 16                  | allgemein |                   |
| BX       |                     |           |                   |
| CX       |                     |           |                   |
| DX       |                     |           |                   |
| IP       |                     |           |                   |
| SP       |                     |           |                   |
| Flags    |                     |           |                   |

---

## Aufgabe 2: Teilregister zuordnen

Trage in der Tabelle ein, welche 8-Bit-Teilregister zu welchem 16-Bit-Register geh&ouml;ren:

| 16-Bit-Register | High-Byte (8 Bit) | Low-Byte (8 Bit) |
|-----------------|-------------------|------------------|
| AX              | AH                | AL               |
| BX              |                   |                   |
| CX              |                   |                   |
| DX              |                   |                   |

---

## Aufgabe 3: Flag-Bits

Welche Aussage zu den folgenden Flags ist richtig?

| Flag | Bedeutung | Wann wird es gesetzt? |
|------|-----------|----------------------|
| ZF   | Zero Flag |                       |
| CF   |           |                       |
| SF   |           |                       |
| OF   |           |                       |

---

## Aufgabe 4: Kurzfragen

1. Welches Register zeigt auf den n&auml;chsten auszuf&uuml;hrenden Befehl?
2. Wie viele Bits hat ein allgemeines Register im 16-Bit-x86-Assembler?
3. Welches Register eignet sich besonders als Schleifenz&auml;hler?
4. Kann der Stack Pointer (SP) f&uuml;r arithmetische Operationen verwendet werden?
