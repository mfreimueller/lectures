# KATA 3: Verwaltungstools

**Dauer:** 15 Minuten

## Ziel
Die wichtigen Windows-Verwaltungstools und deren Einsatzzweck kennen.

## Aufgaben

### Aufgabe 1: Tools zuordnen (8 Min.)

Ordnen Sie jedem Werkzeug den richtigen Befehl (MMC-Name) und die richtige Beschreibung zu:

| Tool | Befehl | Beschreibung |
|------|--------|-------------|
| Task-Manager | | |
| Datenträgerverwaltung | | |
| Geräte-Manager | | |
| Ereignisanzeige | | |
| Computerverwaltung | | |
| Lokale Benutzer und Gruppen | | |

**Befehle zur Auswahl:** `taskmgr.exe`, `diskmgmt.msc`, `devmgmt.msc`, `eventvwr.msc`, `compmgmt.msc`, `lusrmgr.msc`

**Beschreibungen zur Auswahl:**
A. Übersicht aller installierten Hardware-Komponenten und Treiberverwaltung
B. Prozesse, Leistung und Autostart verwalten
C. Sammlung mehrerer Verwaltungstools in einem Fenster
D. Partitionen und Volumes verwalten
E. System-, Sicherheits- und Anwendungsereignisse protokollieren und analysieren
F. Lokale Benutzerkonten und Gruppen anlegen und verwalten

### Aufgabe 2: Fehlerszenario (4 Min.)

Ein Benutzer berichtet, dass sein Drucker nicht funktioniert. Beschreiben Sie eine systematische Vorgehensweise mit den Windows-Verwaltungstools, um das Problem zu diagnostizieren. Nennen Sie mindestens drei Tools, die Sie einsetzen würden.

### Aufgabe 3: Kurzfrage (3 Min.)

Was ist der Unterschied zwischen der Datenträgerverwaltung (`diskmgmt.msc`) und dem Geräte-Manager (`devmgmt.msc`)? Geben Sie jeweils ein konkretes Einsatzbeispiel.

---

## Lösungshinweise

**Aufgabe 1:**
| Tool | Befehl | Beschreibung |
|------|--------|-------------|
| Task-Manager | `taskmgr.exe` | B |
| Datenträgerverwaltung | `diskmgmt.msc` | D |
| Geräte-Manager | `devmgmt.msc` | A |
| Ereignisanzeige | `eventvwr.msc` | E |
| Computerverwaltung | `compmgmt.msc` | C |
| Lokale Benutzer und Gruppen | `lusrmgr.msc` | F |

**Aufgabe 2:** Mögliche Schritte:
1. **Geräte-Manager** → Drucker im Gerätebaum suchen (gelbes Ausrufezeichen?)
2. **Ereignisanzeige** → Systemprotokoll nach Drucker-Fehlern durchsuchen
3. **Dienste** (services.msc) → Prüfen, ob der Drucker-Spooler läuft
4. **Datenträgerverwaltung** → Ausreichend Speicherplatz für Spool-Ordner?

**Aufgabe 3:** Die Datenträgerverwaltung arbeitet auf Partitionsebene (logische Volumes, Laufwerksbuchstaben), der Geräte-Manager arbeitet auf Hardware-Ebene (physische Komponenten, Treiber). Beispiel: Datenträgerverwaltung → neue Partition erstellen; Geräte-Manager → Grafikkarten-Treiber aktualisieren.
