# Kata 3: Dateirechte

## Ziel
Linux-Dateirechte verstehen und mit chmod und chown ändern.

## Aufgabenstellung
Führen Sie alle Schritte im Terminal Ihrer Ubuntu-VM durch:

1. Erstellen Sie einen Ordner `rechte_test` und wechseln Sie hinein.
2. Erstellen Sie eine Datei `skript.sh` mit folgendem Inhalt:
   <pre><code class="language-bash">#!/bin/bash
   echo "Hallo, ich bin ein Skript!"</code></pre>
3. Zeigen Sie die aktuellen Rechte mit `ls -l skript.sh` an.
4. Ändern Sie die Rechte mit `chmod`:
   - `chmod 755 skript.sh` – was hat sich geändert?
   - `chmod u+x skript.sh` – was passiert?
   - `chmod go-w skript.sh` – wem wird das Schreibrecht entzogen?
5. Führen Sie das Skript aus: `./skript.sh`
6. Erstellen Sie eine zweite Datei `geheim.txt` mit beliebigem Inhalt.
7. Setzen Sie die Rechte so, dass nur der Besitzer lesen und schreiben kann (600).
8. Versuchen Sie, `geheim.txt` mit `cat geheim.txt` zu lesen.
9. (Optional) Ändern Sie den Besitzer mit `sudo chown root geheim.txt` und zeigen Sie das Ergebnis.

## Hinweise
- Die oktale Notation: r=4, w=2, x=1
  - 755 = rwxr-xr-x (Besitzer alles, Gruppe/Andere lesen+ausführen)
  - 644 = rw-r--r-- (Besitzer lesen+schreiben, andere nur lesen)
  - 600 = rw------- (nur Besitzer darf lesen und schreiben)
- Ohne `sudo` können Sie den Besitzer nicht ändern.
- Mit `chown -R` ändern Sie Besitzer rekursiv für ganze Ordner.

## Abgabe
Screenshot mit `ls -l` nach Schritt 7.
