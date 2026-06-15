public class Person {
    private String name;
    private int alter;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public int getAlter() {
        return alter;
    }

    public void vorstellen() {
        System.out.println("Hallo, ich bin " + name +
                " und bin " + alter + " Jahre alt.");
    }

    public boolean istVolljaehrig() {
        return alter >= 18;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Anna");
        p.setAlter(20);
        p.vorstellen();
        System.out.println("Volljährig: " + p.istVolljaehrig());
    }
}
