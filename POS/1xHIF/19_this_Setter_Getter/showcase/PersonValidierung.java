public class PersonValidierung {
    private String name;
    private int alter;

    public PersonValidierung(String name, int alter) {
        this.name = name;
        setAlter(alter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Fehler: Name darf nicht leer sein!");
        }
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        if (alter > 0 && alter < 150) {
            this.alter = alter;
        } else {
            System.out.println("Fehler: Ungueltiges Alter: " + alter);
        }
    }

    public void printInfo() {
        System.out.println("Name: " + this.name + ", Alter: " + this.alter);
    }

    public static void main(String[] args) {
        PersonValidierung p1 = new PersonValidierung("Anna", 25);
        p1.printInfo();

        PersonValidierung p2 = new PersonValidierung("Bob", -5);
        p2.printInfo();

        p1.setAlter(200);
        p1.setName("");
        p1.printInfo();

        p1.setName("Maria");
        p1.setAlter(30);
        p1.printInfo();
    }
}