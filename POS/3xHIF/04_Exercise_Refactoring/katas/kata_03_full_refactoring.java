import java.util.*;

public class FullRefactoring {
    public static void main(String[] args) {
        var items = List.of(
            new OrderItemFull("Laptop", 1200.0, 1),
            new OrderItemFull("Mouse", 25.0, 2)
        );

        var order = new OrderFull(1, "Alice", items, OrderStatusFull.PENDING);
        System.out.println("Order " + order.id() + " total: " + order.total());
        System.out.println("Status: " + order.statusLabel());
    }
}
