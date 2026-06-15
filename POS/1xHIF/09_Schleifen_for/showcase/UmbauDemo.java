public class UmbauDemo {
    public static void main(String[] args) {
        System.out.println("=== while-Version ===");
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        System.out.println("=== for-Version ===");
        for (int j = 1; j <= 10; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        System.out.println("=== rueckwaerts ===");
        for (int j = 10; j >= 1; j--) {
            System.out.print(j + " ");
        }
        System.out.println();

        System.out.println("=== Schrittweite 2 ===");
        for (int j = 0; j <= 10; j += 2) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
