# Kata 3: PCIe-Erweiterungsslots und Bandbreiten

## Ziel
Die verschiedenen PCIe-Versionen und Lane-Konfigurationen kennen und Bandbreiten berechnen können.

## Aufgabenstellung
1. Recherchiere die theoretischen Bandbreiten pro Lane für PCIe 3.0, 4.0 und 5.0.
   - Trage die Werte in eine Tabelle ein (Version, GT/s, GB/s pro Lane, GB/s bei x16).
2. Berechne folgende Szenarien:
   - Eine NVMe-SSD nutzt PCIe 4.0 x4. Welche maximale Bandbreite steht zur Verfügung?
   - Eine Grafikkarte ist an PCIe 5.0 x16 angeschlossen. Welche Bandbreite hat sie maximal?
   - Ein WLAN-Modul ist an PCIe 3.0 x1 angeschlossen. Reicht das für 2,5 Gbit/s LAN-Durchsatz? (Hinweis: 1 Byte = 8 Bit)
3. Eine Grafikkarte benötigt mindestens 8 GB/s Bandbreite. Welche PCIe-Versionen mit x8 sind ausreichend? Welche Kombination ist mindestens nötig?

## Hinweise
- Bandbreite (GB/s) = (Lanes × Transferrate pro Lane) / 8 (Bit zu Byte)
- GT/s (Giga-Transfers pro Sekunde) ist die Rohdatenrate.
- Bei PCIe 3.0 sind 8 GT/s ≈ 1 GB/s pro Lane (durch 8b/10b-Kodierung).
- Bei PCIe 4.0 sind 16 GT/s ≈ 2 GB/s pro Lane.
- Bei PCIe 5.0 sind 32 GT/s ≈ 4 GB/s pro Lane.
