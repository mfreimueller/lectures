class Person {
    private String name;
    private int alter;

    public Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void printInfo() {
        System.out.println(name + " (" + alter + ")");
    }
}

public class ReferenzenDemo {

    public static void altern(Person p) {
        p.setAlter(p.getAlter() + 1);
    }

    public static void neuzuweisen(Person p) {
        p = new Person("Neu", 0);
    }

    public static void printPerson(Person p) {
        if (p != null) {
            System.out.println(p.getName());
        } else {
            System.out.println("Keine Person vorhanden");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Aliasing ===");
        Person a = new Person("Anna", 25);
        Person b = a;
        System.out.print("a: ");
        a.printInfo();
        System.out.print("b: ");
        b.printInfo();
        b.setName("Maria");
        System.out.println("Nach Aenderung ueber b:");
        System.out.print("a: ");
        a.printInfo();

        System.out.println("\n=== Objekt als Parameter ===");
        altern(a);
        System.out.print("Nach altern(): ");
        a.printInfo();

        System.out.println("\n=== Neuzuweisung ===");
        neuzuweisen(a);
        System.out.print("Nach neuzuweisen(): ");
        a.printInfo();

        System.out.println("\n=== null ===");
        Person c = null;
        printPerson(c);
    }
}