# KATA 2: NTFS-Berechtigungen

**Dauer:** 20 Minuten

## Ziel
NTFS-Dateiberechtigungen verstehen und effektive Berechtigungen berechnen können.

## Aufgaben

### Aufgabe 1: Berechtigungsarten (5 Min.)

Nennen Sie die sechs wichtigsten NTFS-Standardberechtigungen und beschreiben Sie kurz, was der Benutzer mit jeder Berechtigung tun darf.

### Aufgabe 2: Vererbung (5 Min.)

Ein Benutzer hat folgende Berechtigungen:

- Auf Ordner `C:\Projekte`: **Leseberechtigung** (explizit erteilt)
- Auf Ordner `C:\Projekte\Web`: **Ändern-Berechtigung** (von `C:\Projekte` geerbt)
- Auf Ordner `C:\Projekte\Web`: **Deny – Schreiben** (explizit gesetzt)

Der Ordner `C:\Projekte\Web` erbt standardmäßig von `C:\Projekte`.

a) Welche effektive Berechtigung hat der Benutzer auf `C:\Projekte\Web`?
b) Was ändert sich, wenn die Vererbung für `C:\Projekte\Web` deaktiviert wird (nur explizite Berechtigungen zählen)?

### Aufgabe 3: Berechtigungsberechnung (10 Min.)

Vier Benutzer (Anna, Ben, Carla, David) sind Mitglieder folgender Gruppen:

| Benutzer | Gruppenmitgliedschaften |
|----------|------------------------|
| Anna | Projektleitung, Marketing |
| Ben | Entwicklung, Projektleitung |
| Carla | Marketing |
| David | Entwicklung |

Der Ordner `C:\Projekte\App` hat folgende ACL:

| Benutzer/Gruppe | Berechtigung | Typ |
|-----------------|-------------|-----|
| Entwicklung | Ändern | Allow |
| Projektleitung | Vollzugriff | Allow |
| Marketing | Lesen | Allow |
| David | Deny – Schreiben | Deny |

Bestimmen Sie die effektive Berechtigung für jeden der vier Benutzer auf den Ordner `C:\Projekte\App`.

---

## Lösungshinweise

**Aufgabe 1:**
1. **Vollzugriff** – alles (Lesen, Schreiben, Ausführen, Löschen, Berechtigungen ändern)
2. **Ändern** – Lesen, Schreiben, Ausführen, Löschen (aber nicht Berechtigungen ändern)
3. **Lesen & Ausführen** – Lesen + Ausführen von Programmen
4. **Ordnerinhalt auflisten** – Inhalt des Ordners anzeigen
5. **Lesen** – Dateien öffnen und anzeigen
6. **Schreiben** – Dateien erstellen und ändern

**Aufgabe 2:**
a) Von `C:\Projekte` geerbt: Lesen. Von `C:\Projekte\Web` geerbt: Ändern (Lesen+Schreiben). Explizit: Deny Schreiben → effektiv: Lesen (ohne Schreiben).
b) Ohne Vererbung zählt nur noch die explizite Deny-Schreiben-Berechtigung → effektiv: keine Berechtigung (nur Deny übrig).

**Aufgabe 3:**
- **Anna:** Projektleitung → Vollzugriff (Allow) + Marketing → Lesen (Allow) → **Vollzugriff**
- **Ben:** Entwicklung → Ändern (Allow) + Projektleitung → Vollzugriff (Allow) → **Vollzugriff**
- **Carla:** Marketing → Lesen (Allow) → **Lesen**
- **David:** Entwicklung → Ändern (Allow) + David → Deny Schreiben (Deny) → **Lesen & Ausführen** (Lesen ohne Schreiben)
