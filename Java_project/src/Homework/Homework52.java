package Homework;

import java.util.ArrayList;
import java.util.List;

interface Cloneable<T> {
    T clone();
}

class Product implements Cloneable<Product> {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public Product clone() {
        return new Product(name, price, quantity);
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }
}

class Discount implements Cloneable<Discount> {
    private String code;
    private double percentage;

    public Discount(String code, double percentage) {
        this.code = code;
        this.percentage = percentage;
    }

    public String getCode() {
        return code;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public Discount clone() {
        return new Discount(code, percentage);
    }

    public void setPercentage(double v) {
        this.percentage = v;
    }
}

class Order implements Cloneable<Order> {
    private List<Product> products;
    private double shippingCost;
    private List<Discount> discounts;
    private String paymentMethod;

    public Order(List<Product> products, double shippingCost, List<Discount> discounts, String paymentMethod) {
        this.products = products;
        this.shippingCost = shippingCost;
        this.discounts = discounts;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public Order clone() {
        List<Product> clonedProducts = new ArrayList<>();
        for (Product product : products) {
            clonedProducts.add(product.clone());
        }

        List<Discount> clonedDiscounts = new ArrayList<>();
        for (Discount discount : discounts) {
            clonedDiscounts.add(discount.clone());
        }

        return new Order(clonedProducts, shippingCost, clonedDiscounts, paymentMethod);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}





public class Homework52 {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99, 1);
        Product product2 = new Product("Mouse", 19.99, 2);

        Discount discount1 = new Discount("SUMMER2024", 10.0);
        Discount discount2 = new Discount("WELCOME2024", 5.0);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        List<Discount> discounts = new ArrayList<>();
        discounts.add(discount1);
        discounts.add(discount2);

        Order originalOrder = new Order(products, 50.0, discounts, "Credit Card");

        Order clonedOrder = originalOrder.clone();

        originalOrder.getProducts().get(0).setQuantity(2);
        originalOrder.getDiscounts().get(0).setPercentage(15.0);

        System.out.println("Original Order Product 1 Quantity: " + originalOrder.getProducts().get(0).getQuantity());
        System.out.println("Cloned Order Product 1 Quantity: " + clonedOrder.getProducts().get(0).getQuantity());
        System.out.println("Original Order Discount 1 Percentage: " + originalOrder.getDiscounts().get(0).getPercentage());
        System.out.println("Cloned Order Discount 1 Percentage: " + clonedOrder.getDiscounts().get(0).getPercentage());
    }
}
