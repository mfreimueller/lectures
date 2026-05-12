# Kata 1: Umrechner Celsius - Fahrenheit

## Ziel

Lerne den Umgang mit double-Variablen und arithmetischen Operatoren,
indem du eine Temperatur von Celsius in Fahrenheit umrechnest.

## Aufgabenstellung

Schreibe ein Programm `CelsiusToFahrenheit.java`, das:

1. Eine Variable `celsius` vom Typ double deklariert und mit einem Wert deiner Wahl initialisiert
2. Die Temperatur in Fahrenheit berechnet: F = C * 9/5 + 32
3. Beide Temperaturen formatiert ausgibt

## Beispiel-Output

Bei `celsius = 25.0`:

```
25.0°C = 77.0°F
```

## Hinweise

- Achte auf die Ganzzahldivision: `9/5` ergibt in Java 1, nicht 1.8!
  Verwende stattdessen `9.0 / 5.0`.
- Verwende `printf` mit `%.1f` fuer eine Nachkommastelle.

## Erweiterung (optional)

Rechne zusaetzlich eine Fahrenheit-Temperatur zurueck in Celsius um.
Formel: C = (F - 32) * 5/9
