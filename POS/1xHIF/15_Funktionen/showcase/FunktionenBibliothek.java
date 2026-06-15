public class FunktionenBibliothek {

    public static void main(String[] args) {
        System.out.println("30°C = " + celsiusToFahrenheit(30) + "°F");
        System.out.println("86°F = " + fahrenheitToCelsius(86) + "°C");
        System.out.println("Max von (3, 7, 5) = " + max(3, 7, 5));
        System.out.println("2024 ist ein Schaltjahr: " + isLeapYear(2024));
        System.out.println("2025 ist ein Schaltjahr: " + isLeapYear(2025));
        System.out.println("5! = " + factorial(5));
    }

    public static double celsiusToFahrenheit(double c) {
        return c * 9.0 / 5.0 + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5.0 / 9.0;
    }

    public static int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
