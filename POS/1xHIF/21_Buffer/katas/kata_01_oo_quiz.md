# Kata 1: OO-Quiz

| Feld | Wert |
|------|------|
| Konzepte | OO-Grundlagen (Klasse, Objekt, Attribut, Methode, Konstruktor, Referenz, null) |
| Schwierigkeit | 1/5 |
| Dauer | ca. 15 min |

### Aufgabenstellung

Beantworte die folgenden Multiple-Choice Fragen zu den OO-Grundlagen. Kreuze die richtige(n) Antwort(en) an.

---

**Frage 1:** Was ist eine Klasse in Java?
- [ ] Ein konkretes Objekt im Speicher
- [x] Ein Bauplan oder eine Vorlage fur Objekte
- [ ] Eine Variable
- [ ] Eine Methode

**Frage 2:** Was ist ein Objekt in Java?
- [ ] Ein Datentyp
- [x] Eine Instanz einer Klasse
- [ ] Eine Methode
- [ ] Ein Konstruktor

**Frage 3:** Welche Sichtbarkeit macht Attribute nur innerhalb derselben Klasse zuganglich?
- [ ] public
- [x] private
- [ ] protected
- [ ] static

**Frage 4:** Wozu dient ein Konstruktor?
- [ ] Zum Zerstoren eines Objekts
- [ ] Zum Andern von Attributen
- [x] Zum Initialisieren eines neuen Objekts
- [ ] Zum Ausgeben von Text

**Frage 5:** Was bedeutet der Wert null bei einer Objektvariable?
- [ ] Die Variable hat den Wert 0
- [x] Die Variable zeigt auf kein Objekt
- [ ] Die Variable wurde noch nicht deklariert
- [ ] Die Variable ist ein primitiver Typ

**Frage 6:** Was passiert bei folgendem Code?
```
String s = null;
System.out.println(s.length());
```
- [ ] Es wird 0 ausgegeben
- [ ] Es wird null ausgegeben
- [x] Es wird eine NullPointerException geworfen
- [ ] Der Code ubersetzt nicht

**Frage 7:** Welche der folgenden Typen sind primitive Typen in Java?
- [x] int
- [ ] String
- [x] boolean
- [ ] Auto

**Frage 8:** Was gibt folgender Code aus?
```
int a = 5;
int b = a;
b = 10;
System.out.println(a);
```
- [x] 5
- [ ] 10
- [ ] 15
- [ ] Der Code ubersetzt nicht

**Frage 9:** Was gibt folgender Code aus?
```
class Person { String name; }
Person p1 = new Person();
p1.name = "Anna";
Person p2 = p1;
p2.name = "Maria";
System.out.println(p1.name);
```
- [ ] Anna
- [x] Maria
- [ ] null
- [ ] Fehler

**Frage 10:** Wozu dienen Getter und Setter?
- [x] Zum kontrollierten Zugriff auf private Attribute
- [ ] Zum Loschen von Objekten
- [ ] Zum Erstellen von Objekten
- [ ] Zum Ubersetzen des Codes
