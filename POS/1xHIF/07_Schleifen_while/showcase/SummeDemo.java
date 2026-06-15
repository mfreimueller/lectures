public class SummeDemo {
    public static void main(String[] args) {
        int n = 100;
        int summe = 0;
        int i = 1;

        while (i <= n) {
            summe = summe + i;
            i++;
        }

        System.out.println("Summe 1.." + n + " = " + summe);
    }
}
