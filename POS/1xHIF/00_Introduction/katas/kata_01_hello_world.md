# Kata 1: Hello World in 3 Varianten

## Ziel

Lerne die verschiedenen Ausgabemethoden von Java kennen:
System.out.println(), System.out.print() und System.out.printf().

## Aufgabenstellung

Schreibe ein Programm mit dem Namen `HalloWelt.java`, das:

1. "Hallo Welt!" auf einer eigenen Zeile ausgibt (mit println)
2. "Hallo" und "Welt!" auf derselben Zeile ausgibt (mit print)
3. "Hallo, Welt!" mit printf() formatiert ausgibt

## Beispiel-Output

Dein Programm soll genau diese Ausgabe produzieren:

```
Hallo Welt!
Hallo Welt!
Hallo, Welt!
```

## Hinweise

- println fuegt am Ende einen Zeilenumbruch hinzu, print nicht.
- printf verwendet Format-Strings: %s fuer Strings, %d fuer Zahlen.
- Der erste Teil (Hallo) und der zweite Teil (Welt!) sollen in getrennten print-Befehlen ausgegeben werden.

## Erweiterung (optional)

Gib zusatzlich "Willkommen zu Java!" mit printf aus, wobei "Java" als Variable ubergeben wird.
