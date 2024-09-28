// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа Single-Responsibility Principle (SRP):
// Рассмотрим класс Invoice, который нарушает принцип SRP, поскольку он занимается как расчетом стоимости, так и сохранением счета-фактуры в базу данных:

/* import java.util.List;
class Invoice {
    private int id;
    private List<Item> items;
    private double taxRate;

    public Invoice(int id, List<Item> items, double taxRate) {
        this.id = id;
        this.items = items;
        this.taxRate = taxRate;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double calculateTotal() {
        double subTotal = 0;

        for (Item item : items) {
            subTotal += item.getPrice();
        }
        return subTotal + (subTotal * taxRate);
    }
}

class InvoiceRepository {
    public void saveToDatabase(Invoice invoice) {
        // Логика для сохранения счета-фактуры в базу данных
    }
}

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
*/


// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа Open-Closed Principle, OCP:
// Рассмотрим пример, в котором класс DiscountCalculator нарушает принцип OCP,поскольку каждый раз при добавлении нового типа скидки нужно изменять существующий код:


/* public abstract class DiscountStrategy {
    public abstract double calculateDiscount(double amount);
}

public class RegularDiscount extends DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount;
    }
}

public class SilverDiscount extends DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.9;
    }
}

public class GoldDiscount extends DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.8;
    }
}

public class DiscountCalculator {
    private DiscountStrategy discountStrategy;

    public DiscountCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(double amount) {
        return discountStrategy.calculateDiscount(amount);
    }
}
*/






// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа Interface Segregation Principle, ISP:
// Рассмотрим пример интерфейса IWorker, который объединяет слишком много методов:

/* public interface IWork{
    void Work();
}
public interface IEat{
    void Eat();
}
public interface ISleep{
    void Sleep();
}
public class HumanWorker implements IWork, IEat, ISleep{
    public void Work(){
        // Логика работы
    }
    public void Eat(){
        // Логика питания
    }
    public void Sleep() {
        // Логика сна
    }
}
public class RobotWorker implements IWork{
    public void Work(){
        // Логика работы
    }
}
*/


// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа Dependency-Inversion Principle, DIP:
// Рассмотрим пример, где класс Notification зависит от конкретной реализации класса EmailService:

/* public interface INotification{
    void send(String message);
}

public class EmailService implements INotification{
    public void send(String message){
        System.out.println("Отправка Email: {message}");
    }
}
public class SmsService implements INotification {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: {message}");
    }
}

public class NotificationService {
    private INotification notification;

    public NotificationService(INotification notification) {
        this.notification = notification;
    }

    public void sendNotification(String message) {
        notification.send(message);
    }
}
*/


public class Lab3 {
}

public void main() {
}
