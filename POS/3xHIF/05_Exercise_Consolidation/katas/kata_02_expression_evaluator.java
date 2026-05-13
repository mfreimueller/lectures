public class ExpressionEvaluator {
    public static void main(String[] args) {
        // (3 + 4) * 2
        Expr expr = new Multiply(new Add(new Constant(3), new Constant(4)), new Constant(2));
        System.out.println(eval(expr));
        System.out.println(toExprString(expr));
    }

    static int eval(Expr expr) {
        return switch (expr) {
            case Constant c -> c.value();
            case Add a -> eval(a.left()) + eval(a.right());
            case Multiply m -> eval(m.left()) * eval(m.right());
        };
    }

    static String toExprString(Expr expr) {
        return switch (expr) {
            case Constant c -> String.valueOf(c.value());
            case Add a -> "(" + toExprString(a.left()) + " + " + toExprString(a.right()) + ")";
            case Multiply m -> toExprString(m.left()) + " * " + toExprString(m.right());
        };
    }
}
