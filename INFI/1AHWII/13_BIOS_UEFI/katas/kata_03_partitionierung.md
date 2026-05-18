# Kata 3: Partitionierung – GPT vs. MBR

## Ziel
Die Unterschiede zwischen GPT und MBR verstehen und die richtige Partitionierung für verschiedene Szenarien auswählen können.

## Aufgabenstellung
1. Vervollständige die folgende Tabelle:

| Merkmal | MBR | GPT |
|---------|-----|-----|
| Maximale Kapazität | | ~9,4 ZB |
| Maximale primäre Partitionen | | |
| Redundanz | | Ja (Kopie am Ende) |
| Fehlererkennung | | CRC32-Prüfsumme |
| Erforderlicher Boot-Modus | Legacy BIOS | |
| Kompatibilität | | Moderne Systeme |

2. Ordne den folgenden Szenarien die passende Partitionierung (MBR oder GPT) zu:
   - Eine 500-GB-SSD für Windows 11
   - Eine 3-TB-HDD für ein NAS
   - Ein USB-Stick, der auch an älteren Computern (vor 2010) booten soll
   - Eine 1-TB-SSD als Systemplatte für Windows 10
   - Eine 250-GB-SSD für ein Linux-System mit UEFI

3. Begründe deine Entscheidungen aus Aufgabe 2.

4. Erkläre den Unterschied zwischen primären, erweiterten und logischen Partitionen bei MBR. Warum wird dieses Konzept bei GPT nicht mehr benötigt?

## Hinweise
- MBR hat ein 2-TB-Limit wegen der 32-Bit-Adressierung (512-Byte-Sektoren).
- GPT verwendet 64-Bit-Adressierung – praktisch unbegrenzt.
- GPT speichert eine redundante Partitionstabelle am Ende der Festplatte.
- MBR erlaubt maximal 4 primäre Partitionen; GPT bis zu 128 unter Windows.
- Ältere Betriebssysteme (Windows XP, Vista 32-Bit) können nicht von GPT booten.
