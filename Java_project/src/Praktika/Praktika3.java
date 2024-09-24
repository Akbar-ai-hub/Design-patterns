package Praktika;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class Order {
    private List<Product> products = new ArrayList<>();
    private IPayment payment;
    private IDelivery delivery;
    private INotification notification;
    private double discount = 0;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    public void setDelivery(IDelivery delivery) {
        this.delivery = delivery;
    }

    public void setNotification(INotification notification) {
        this.notification = notification;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total - discount;
    }

    public void applyDiscount(double discountAmount) {
        this.discount = discountAmount;
    }

    public void completeOrder() {
        double totalPrice = calculateTotalPrice();
        payment.processPayment(totalPrice);
        delivery.deliverOrder(this);
        notification.sendNotification("Ваш заказ обработан на сумму: $" + totalPrice);
    }

    @Override
    public String toString() {
        return "Заказ с товарами: " + products;
    }
}

interface IPayment {
    void processPayment(double amount);
}

class CreditCardPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата кредитной картой на сумму: $" + amount);
    }
}

class PayPalPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата через PayPal на сумму: $" + amount);
    }
}

class BankTransferPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата через Банк на сумму: $" + amount);
    }
}

interface IDelivery {
    void deliverOrder(Order order);
}

class CourierDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Доставка курьером. " + order);
    }
}

class PostDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Доставка почтой. " + order);
    }
}

class PickUpPointDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Доставка через пункт выдачи. " + order);
    }
}

interface INotification {
    void sendNotification(String message);
}

class EmailNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Отправка Email: " + message);
    }
}

class SmsNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Отправка SMS: " + message);
    }
}

class DiscountCalculator {
    public double calculateDiscount(Order order) {
        return order.calculateTotalPrice() * 0.10;
    }
}

public class Praktika3 {
    public static void main(String[] args) {
        Product product1 = new Product("Ноутбук", 1000);
        Product product2 = new Product("Мышь", 50);

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);

        order.setPayment(new PayPalPayment());
        order.setDelivery(new CourierDelivery());
        order.setNotification(new EmailNotification());

        DiscountCalculator discountCalculator = new DiscountCalculator();
        double discount = discountCalculator.calculateDiscount(order);
        order.applyDiscount(discount);

        order.completeOrder();
    }
}

