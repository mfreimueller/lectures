# Kata 2: Paketmanager

## Ziel
Den apt-Paketmanager unter Ubuntu anwenden.

## Aufgabenstellung
Führen Sie alle Schritte im Terminal Ihrer Ubuntu-VM durch:

1. **Paketliste aktualisieren**: Aktualisieren Sie die Paketliste:
   <pre><code class="language-bash">sudo apt update</code></pre>
2. **System aktualisieren**: Führen Sie ein Upgrade aller installierten Pakete durch:
   <pre><code class="language-bash">sudo apt upgrade -y</code></pre>
3. **Paket suchen**: Suchen Sie nach einem Spiel:
   <pre><code class="language-bash">apt search "snake"</code></pre>
4. **Paket installieren**: Installieren Sie `htop` und `cowsay`:
   <pre><code class="language-bash">sudo apt install htop cowsay -y</code></pre>
5. **Paket testen**: Führen Sie die Programme aus:
   <pre><code class="language-bash">cowsay "Hallo Linux!"
htop  # Beenden mit q</code></pre>
6. **Paketdetails**: Zeigen Sie Details zum Paket htop an:
   <pre><code class="language-bash">apt show htop</code></pre>
7. **Paket entfernen**: Deinstallieren Sie cowsay:
   <pre><code class="language-bash">sudo apt remove cowsay -y</code></pre>
8. **Alle installierten Pakete**: Listen Sie alle installierten Pakete auf:
   <pre><code class="language-bash">dpkg -l | head -20</code></pre>

## Hinweise
- Fast alle apt-Befehle benötigen `sudo` (außer `search` und `show`).
- Mit `-y` werden Bestätigungsfragen automatisch mit Yes beantwortet.
- Für grafische Programme benötigen Sie eine Desktop-Umgebung.
- `dpkg -l` zeigt ALLE installierten Pakete – meist sehr viele.

## Abgabe
Screenshot des Terminals mit der Ausgabe von `cowsay "Hallo Linux!"` und `htop`.
