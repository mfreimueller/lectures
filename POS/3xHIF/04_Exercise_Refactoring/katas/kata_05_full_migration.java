import java.util.ArrayList;
import java.util.List;

public class FullMigrationStarter {
    public static void main(String[] args) {
        Order order1 = new Order("ORD-001", 149.99, "PAID");
        Order order2 = new Order("ORD-002", 59.99, "PENDING");
        Order order3 = new Order("ORD-003", 299.00, "CANCELLED");

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            String message = formatOrderMessage(o);
            System.out.println(message);
        }
    }

    static String formatOrderMessage(Order order) {
        String statusMessage;
        if (order.getStatus().equals("PENDING")) {
            statusMessage = "is pending";
        } else if (order.getStatus().equals("PAID")) {
            statusMessage = "has been received. Thank you!";
        } else if (order.getStatus().equals("CANCELLED")) {
            statusMessage = "has been cancelled.";
        } else {
            statusMessage = "has unknown status.";
        }

        return "Order[orderId=" + order.getId()
            + ", amount=$" + String.format("%.2f", order.getAmount())
            + ", status=" + order.getStatus() + "]\n"
            + "Your payment of $" + String.format("%.2f", order.getAmount())
            + " " + statusMessage;
    }
}

class Order {
    private String id;
    private double amount;
    private String status;

    public Order(String id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
