public class SwitchExpressions {
    public static void main(String[] args) {
        var levels = java.util.List.of(1, 2, 3, 4, 5);
        for (var level : levels) {
            System.out.println(level + " -> " + priorityLabel(level));
        }
    }

    static String priorityLabel(int level) {
        return switch (level) {
            case 1 -> "Low";
            case 2 -> "Medium";
            case 3 -> "High";
            case 4 -> "Critical";
            default -> "Unknown";
        };
    }
}
