# Debian

## Background-Informationen

- Erinnerung/Wiederholung:
    - Vergleich mit der Windows-Installation - welche Unterschiede könnt ihr feststellen?
    - Root - was ist das? Wozu brauche ich das? Was ist das Windows-Äquivalent?
    - Verzeichnisstruktur - was ist der Start unserer Verzeichnisse? ( / )
        - Wichtig: alles ist eine Datei!
    - Wozu & was haben wir Partitioniert?
    - Was macht der Installationsprozess im Hintergrund?
    - Was bietet sich nach erfolgreicher Installation an? Überleitung zu:
- Herzstück: Paktmanager apt
    - Gemeinsam, in 2er-Teams, erarbeiten, welche Funktionen ein Paketmanager benötigt, dann im Plenum besprechen
    - Frage: Was benötigt ein Paketmanager (root Rechte)
        - apt update
        - apt upgrade
        - apt remove
        - apt install
- Vergleich stable & rolling Distros
    - Teamarbeit: Welche Anforderungen könnte ich an mein Betriebssystem haben? Vergleich Server & Benutzer-PC
    - Wo brauche ich was?
- immutable/atomic
    - Distros, deren Systemdateien read-only sind
        - Userspace Programme installieren via Flatpak, AppImages oder DistroBox
    - Was sind mögliche Anwendungsfälle?
- Installation von Programmen ist anders als bei Windows
    - Nativ
    - Flatpak
    - Snap

## Recherche-Aufgaben

### User Interface

- Vergleich mit Windows
- Suchen, finden und Screenshots machen von:
    - Einstellungen
    - Benutzerverwaltung
    - Hintergrundbild ändern
    - Updates einspielen (suchen, NICHT machen!!!)
    - Aktive Prozesse auflisten
    - Systemresourcen auflisten

### Terminal / CLI

- Ausprobieren: `Strg + Alt + F1`

- Ausprobieren & schriftlich nach ihrer Funktion dokumentieren:
    - Updates einspielen (was wird geupdatet?)
    - Befehle ausprobieren:
        - `cd Downloads/`
        - ls
        - `ls -lia`
        - `man ls`
        - whoami
        - pwd
        - `ps aux`

- Übung zu `top` (`top` ist interaktiv, `ps aux` ist statisch)
    - Wie viele Prozesse laufen insgesamt?
    - Welcher Benutzer hat die meisten Prozesse gestartet?
    - Was ist der PID und wofür steht diese Abkürzung?
    - Welche CPU-Auslastung zeigt dein System aktuell an?

    - Was ist ein "Zombietask"? -> ein Task, der zwar abgeschlossen ist, aber noch immer in der Tabelle einen Eintrag hat

- Übung zu Services: `sudo systemctl`
    - Wie viele Services sind aktiv?
    - Welche Service-States siehst du?
    - Wiederholung: Wo finde ich sie in Windows? (Screenshots)

- gemeinsame Übung zu Dateien
    1. `cd`
    2. `mkdir infi`
    3. `cd infi`
    4. `touch debian`
    5. `cat debian`
    6. `echo Hallo > debian`
    7. `cat debian`
    8. `nano debian`
    9. `rm debian`
    10. `cd ..`
    11. `rmdir debian`

- Recherche-Aufgabe
    - Unterschied `rmdir` und `rm -rf`? (`rmdir` löscht nur, falls das Verzeichnis leer ist)
    - Was macht `rm -rf /`? (NICHT AUSFÜHREN)

- Recherche-Aufgabe - Verzeichnisstruktur kennenlernen
    - Was liegt in ...
        - /home
        - /bin - essenzielle Programme unseres Systems
        - /etc - Konfigurationsfiles
        - /usr - User Binaries & Dateien (keine System-Binaries -> /bin) - READONLY
        - /var - Bearbeitbare Dateien, wie Logs
        - /dev - Dateien, die Geräte repräsentieren (alles ist eine Datei!)
        - /proc - Ähnlich wie /dev sind hier spezielle Dateien, die System- und Prozessinformationen enthalten
        - /root
        - /lib - Essenzielle geteilte Bibliotheken
        - /media - Entfernbare Speichermedien
        - /mnt - temporäre Mountingpoints
        - /tmp
        - /opt - Optionale Dateien (manche Installationsprogramme installieren dorthin)
    - Was könnt `/dev/null` sein?

- Recherche-Aufgabe: Systemverwaltung
    - Wie starte ich neu?
    - Wie fahre ich herunter?