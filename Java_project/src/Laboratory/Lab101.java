package Laboratory;

import java.util.List;
import java.util.stream.Collectors;

interface IUserService {
    User register(String username, String password);
    User login(String username, String password);
}

interface IProductService {
    List<Product> getProducts();
    Product addProduct(Product product);
}

interface IOrderService {
    Order createOrder(int userId, List<Integer> productIds);
    Order getOrderStatus(int orderId);
}

interface IPaymentService {
    boolean processPayment(int orderId, double amount);
}

interface INotificationService {
    void sendNotification(int userId, String message);
}

class OrderService implements IOrderService {

    private final IProductService productService;
    private final IPaymentService paymentService;
    private final INotificationService notificationService;

    public OrderService(IProductService productService, IPaymentService paymentService, INotificationService notificationService) {
        this.productService = productService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    @Override
    public Order createOrder(int userId, List<Integer> productIds) {
        List<Product> products = productService.getProducts().stream()
                .filter(product -> productIds.contains(product.getId()))
                .collect(Collectors.toList());

        if (products.isEmpty()) {
            throw new RuntimeException("Выбранные товары не найдены.");
        }

        Order order = new Order(userId, products, "Created");

        double totalAmount = products.stream().mapToDouble(Product::getPrice).sum();

        if (paymentService.processPayment(order.getId(), totalAmount)) {
            order.setStatus("Paid");
            notificationService.sendNotification(userId, "Ваш заказ успешно оплачен.");
        } else {
            order.setStatus("Payment Failed");
            notificationService.sendNotification(userId, "Платеж не прошел. Попробуйте снова.");
        }

        return order;
    }

    @Override
    public Order getOrderStatus(int orderId) {
        return new Order(orderId, null, "In Progress");
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private static int counter = 1;
    private final int id;
    private int userId;
    private List<Product> products;
    private String status;

    public Order(int userId, List<Product> products, String status) {
        this.id = counter++;
        this.userId = userId;
        this.products = products;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class User {
    private int id;
    private String username;
    private String password;

    // Конструктор, геттеры и сеттеры
}


public class Lab101 {
}
