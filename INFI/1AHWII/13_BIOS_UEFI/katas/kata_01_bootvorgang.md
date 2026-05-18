# Kata 1: Der Bootvorgang

## Ziel
Die Schritte des Bootvorgangs eines Computers in die richtige Reihenfolge bringen und jeden Schritt beschreiben können.

## Aufgabenstellung
1. Bringe die folgenden Schritte des Bootvorgangs in die richtige Reihenfolge (1 bis 8):
   - ( ) Der Bootloader lädt den OS-Kernel (z. B. `vmlinuz` oder `ntoskrnl.exe`)
   - ( ) Das Netzteil erhält das Power-Good-Signal und startet alle Spannungen
   - ( ) Der Benutzer meldet sich am Betriebssystem an
   - ( ) BIOS/UEFI initialisiert die Hardware und führt POST durch
   - ( ) Systemdienste und Treiber werden geladen, die GUI startet
   - ( ) Der Power-Button wird gedrückt
   - ( ) BIOS/UEFI durchsucht die Boot-Medien in der Bootreihenfolge
   - ( ) Der Bootloader (z. B. GRUB, Windows Boot Manager) wird in den RAM geladen

2. Schreibe zu jedem Schritt eine kurze Erklärung (1–2 Sätze).

3. Beantworte die folgenden Fragen:
   - Was passiert, wenn der POST einen Fehler in der RAM-Initialisierung erkennt?
   - Warum kann das System nicht booten, wenn kein gültiger Bootloader gefunden wird?
   - Welche Rolle spielt die CMOS-Batterie während des Bootvorgangs?

## Hinweise
- Der Bootvorgang beginnt mit dem Drücken des Power-Buttons.
- Der POST findet statt, bevor das BIOS nach einem Bootmedium sucht.
- Der Bootloader ist ein kleines Programm, das den Kernel lädt.
- Ohne gültigen Bootloader erscheint eine Fehlermeldung wie "No bootable device".
