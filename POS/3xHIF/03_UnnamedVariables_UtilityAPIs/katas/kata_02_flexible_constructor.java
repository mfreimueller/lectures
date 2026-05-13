public class FlexibleConstructor {
    public static void main(String[] args) {
        var pd = new PositiveDouble(3.14);
        System.out.println(pd.doubleValue());
        System.out.println(pd.intValue());

        try {
            var invalid = new PositiveDouble(-1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid: " + e.getMessage());
        }
    }
}
