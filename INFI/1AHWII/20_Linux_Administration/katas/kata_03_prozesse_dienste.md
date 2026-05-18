# Kata 3: Prozesse und Dienste

## Ziel
Prozesse anzeigen, priorisieren und Dienste mit systemd verwalten.

## Aufgabenstellung
Führen Sie alle Schritte im Terminal Ihrer Ubuntu-VM durch:

1. **Alle Prozesse anzeigen**: Zeigen Sie alle laufenden Prozesse an:
   <pre><code class="language-bash">ps aux
ps aux | grep root  # Nur root-Prozesse</code></pre>
2. **Echtzeit-Ansicht**: Starten Sie `top` und beobachten Sie die Prozesse (beenden mit `q`).
3. **Systemd-Dienste**: Zeigen Sie den Status des SSH-Dienstes an:
   <pre><code class="language-bash">systemctl status ssh</code></pre>
4. **Dienst stoppen und starten**: Stoppen und starten Sie den SSH-Dienst:
   <pre><code class="language-bash">sudo systemctl stop ssh
sudo systemctl status ssh   # Sollte "inactive" zeigen
sudo systemctl start ssh
sudo systemctl status ssh   # Sollte "active" zeigen</code></pre>
5. **Autostart**: Überprüfen Sie, ob SSH automatisch startet:
   <pre><code class="language-bash">systemctl is-enabled ssh</code></pre>
6. **Logs anzeigen**: Zeigen Sie die letzten 10 Log-Einträge von SSH an:
   <pre><code class="language-bash">sudo journalctl -u ssh -n 10</code></pre>
7. **Eigenen Prozess**: Starten Sie einen Schlaf-Prozess im Hintergrund:
   <pre><code class="language-bash">sleep 120 &
ps aux | grep sleep
kill %1  # Oder: kill [PID]</code></pre>

## Hinweise
- Dienste (Services) werden mit `systemctl` verwaltet, benötigen oft `sudo`.
- `journalctl -u dienstname` zeigt nur Logs für einen bestimmten Dienst.
- Mit `ps aux | grep prozess` filtern Sie die Prozessliste.
- Der `&` am Ende eines Befehls startet ihn im Hintergrund.

## Abgabe
Screenshot mit der Ausgabe von `systemctl status ssh` (active) und `journalctl -u ssh -n 5`.
