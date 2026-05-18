# Kata 2: BIOS vs. UEFI

## Ziel
Die Unterschiede zwischen Legacy-BIOS und UEFI verstehen und bewerten können.

## Aufgabenstellung
1. Erstelle eine Vergleichstabelle mit mindestens 8 Merkmalen. Verwende folgende Kategorien:
   - Oberfläche und Bedienung
   - Partitionierungsverfahren (MBR/GPT)
   - Bootgeschwindigkeit
   - Maximale Festplattengröße
   - Bootloader-Speicherort und -Größe
   - Treiber-Schnittstelle (16-Bit vs. 64-Bit)
   - Sicherheitsfunktionen
   - Kompatibilitätsmodus (CSM)

2. Entscheide für jedes Szenario, ob BIOS oder UEFI verwendet wird:
   - Ein älterer PC von 2008 mit Windows XP
   - Ein moderner Gaming-PC mit Windows 11 und einer 4-TB-SSD
   - Ein Dual-Boot-System mit Linux und Windows 10
   - Ein Server mit 12 TB Speicherkapazität

3. Erkläre in 3–4 Sätzen, warum UEFI heutzutage Standard ist.

## Hinweise
- Legacy-BIOS arbeitet im 16-Bit-Real-Mode – das limitiert die Bootgeschwindigkeit.
- UEFI kann sowohl im 32-Bit- als auch im 64-Bit-Mode betrieben werden.
- CSM (Compatibility Support Module) erlaubt den Betrieb von Legacy-Betriebssystemen auf UEFI-Systemen.
- Secure Boot ist nur unter UEFI verfügbar.
