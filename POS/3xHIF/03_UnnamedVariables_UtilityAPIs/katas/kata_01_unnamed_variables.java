public class UnnamedVariables {
    public static void main(String[] args) {
        var items = java.util.List.of("a", "b", "c", "d", "e");
        int count = 0;
        for (var _ : items) {
            count++;
        }
        System.out.println("Count: " + count);

        try {
            var result = riskyOperation();
            System.out.println("Result: " + result);
        } catch (Exception _) {
            System.out.println("Operation failed");
        }

        Object obj = "hello";
        if (obj instanceof String _) {
            System.out.println("It's a string!");
        }
    }

    static String riskyOperation() {
        return "done";
    }
}
