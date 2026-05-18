# Kata 1: Benutzerverwaltung

## Ziel
Benutzer und Gruppen in Linux anlegen, verwalten und löschen.

## Aufgabenstellung
Führen Sie alle Schritte im Terminal Ihrer Ubuntu-VM durch:

1. **Benutzer anlegen**: Erstellen Sie drei Benutzer mit `useradd`:
   <pre><code class="language-bash">sudo useradd -m -s /bin/bash max
sudo useradd -m -s /bin/bash lisa
sudo useradd -m -s /bin/bash tim</code></pre>
2. **Passwörter setzen**: Vergeben Sie Passwörter mit `passwd` für alle drei Benutzer.
3. **Gruppen anlegen**: Erstellen Sie die Gruppen `entwicklung` und `design`:
   <pre><code class="language-bash">sudo groupadd entwicklung
sudo groupadd design</code></pre>
4. **Benutzer zu Gruppen hinzufügen**: Fügen Sie max und tim zu `entwicklung` und lisa zu `design` hinzu.
   <pre><code class="language-bash">sudo usermod -aG entwicklung max
sudo usermod -aG entwicklung tim
sudo usermod -aG design lisa</code></pre>
5. **Überprüfen**: Zeigen Sie die Gruppen aller Benutzer an:
   <pre><code class="language-bash">groups max
groups lisa
groups tim
cat /etc/passwd
cat /etc/group</code></pre>
6. **Benutzer löschen**: Löschen Sie den Benutzer tim inklusive Home-Verzeichnis:
   <pre><code class="language-bash">sudo userdel -r tim</code></pre>

## Hinweise
- Für `useradd`, `userdel`, `usermod` und `groupadd` benötigen Sie root-Rechte (`sudo`).
- Der Parameter `-aG` bei `usermod` fügt einen Benutzer zu einer Gruppe hinzu, ohne ihn aus anderen Gruppen zu entfernen.
- Ohne `-m` bei `useradd` wird kein Home-Verzeichnis erstellt.

## Abgabe
Screenshot der Ausgabe von `cat /etc/passwd` und `groups max lisa` nach Schritt 5.
