public class ArrayDemo {
    public static void main(String[] args) {
        int[] zahlen = new int[5];

        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = (i + 1) * 10;
        }

        System.out.println("Array-Inhalt:");
        for (int i = 0; i < zahlen.length; i++) {
            System.out.println("Index " + i + ": " + zahlen[i]);
        }

        System.out.println("Laenge des Arrays: " + zahlen.length);
    }
}
