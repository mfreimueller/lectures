# KATA 1: Prozesszustände

**Dauer:** 20 Minuten

## Ziel
Verstehen der drei Prozesszustände (Running, Ready, Blocked) und deren Übergänge.

## Aufgaben

### Aufgabe 1: Zustandsübergänge (10 Min.)

Zeichnen Sie ein Zustandsdiagramm mit den drei Zuständen **Running**, **Ready** und **Blocked**. Kennzeichnen Sie alle sechs möglichen Übergänge zwischen diesen Zuständen und beschriften Sie diese mit den jeweiligen Auslösern.

Erklären Sie kurz, bei welchen Ereignissen die folgenden Übergänge stattfinden:

| Übergang | Ereignis |
|----------|----------|
| Ready → Running | |
| Running → Ready | |
| Running → Blocked | |
| Blocked → Ready | |

### Aufgabe 2: Praxis-Szenario (5 Min.)

Ein Textverarbeitungsprogramm wird gestartet. Es lädt eine Datei von der Festplatte. Beschreiben Sie die Zustandsübergänge, die dieser Prozess durchläuft. Beginnen Sie beim Start des Programms und enden Sie, wenn der Benutzer den ersten Buchstaben tippen kann.

### Aufgabe 3: PCB (5 Min.)

Ein Process Control Block (PCB) speichert wichtige Informationen über einen Prozess. Nennen Sie mindestens **fünf** Informationen, die im PCB gespeichert werden, und erklären Sie kurz, warum der PCB im Kernel-Space gespeichert sein muss.

---

## Lösungshinweise

**Aufgabe 1:**
| Übergang | Ereignis |
|----------|----------|
| Ready → Running | Scheduler wählt Prozess aus (Dispatch) |
| Running → Ready | Zeitquantum abgelaufen (Preemption) |
| Running → Blocked | Prozess wartet auf I/O (z. B. Festplattenzugriff) |
| Blocked → Ready | E/A-Vorgang abgeschlossen |

**Aufgabe 2:**
1. Programmstart → New → **Ready** (wartet auf CPU)
2. CPU frei → **Running** (Programmcode wird ausgeführt)
3. Datei laden → **Blocked** (wartet auf Festplatte)
4. Ladevorgang abgeschlossen → **Ready**
5. CPU wieder frei → **Running** (Benutzeroberfläche wird angezeigt)
6. Warten auf Tastatureingabe → **Blocked**

**Aufgabe 3:** Siehe Folien: PID, Zustand, Program Counter, CPU-Register, Speicherverwaltungs-Infos, geöffnete Dateien, Priorität. Der PCB muss im Kernel-Space gespeichert sein, da er sicherheitskritische Daten enthält und vor Zugriff durch User-Prozesse geschützt werden muss.
