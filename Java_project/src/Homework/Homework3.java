// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа Single-Responsibility Principle (SRP):
// В этом примере класс Order отвечает за несколько вещей: хранение данных о заказе, расчет стоимости заказа с учетом скидок, обработку платежа и отправку уведомления пользователю.
//

/* public class Order {
    private String productName;
    private int quantity;
    private double price;

    public Order(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

public class OrderPricingService {
    public double calculateTotalPrice(Order order) {
        // Логика расчета стоимости с учетом скидки
        return order.getQuantity() * order.getPrice() * 0.9;
    }
}

public class PaymentService {
    public void processPayment(Order order, String paymentDetails) {
        // Логика обработки платежа
        System.out.println("Payment for " + order.getProductName() + " processed using: " + paymentDetails);
    }
}

public class NotificationService {
    public void sendConfirmationEmail(String email) {
        // Логика отправки уведомления
        System.out.println("Confirmation email sent to: " + email);
    }
}
*/


// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа Open-Closed Principle, OCP:
// Расчет зарплаты сотрудников В этом примере класс EmployeeSalaryCalculator нарушает принцип OCP, так как для добавления новой логики расчета зарплаты приходится изменять код метода CalculateSalary.

/* public class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

public interface SalaryCalculator {
    double calculateSalary(Employee employee);
}

public class PermanentEmployeeSalaryCalculator implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 1.2; // 20% бонус
    }
}

public class ContractEmployeeSalaryCalculator implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 1.1; // 10% бонус
    }
}

public class InternEmployeeSalaryCalculator implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 0.8; // 80% от базовой зарплаты
    }
}

public class EmployeeSalaryService {
    private SalaryCalculator salaryCalculator;

    public EmployeeSalaryService(SalaryCalculator salaryCalculator) {
        this.salaryCalculator = salaryCalculator;
    }

    public double calculateSalary(Employee employee) {
        return salaryCalculator.calculateSalary(employee);
    }
}*/



// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа Interface Segregation Principle, ISP:
// Работа с принтерами
// В этом примере интерфейс IPrinter содержит методы для различных типов принтеров:обычного принтера, сканера и факса. Но что если какой-то принтер поддерживает только печать и сканирование, но не поддерживает отправку факсов? Такой принтер будет вынужден реализовывать метод Fax, который ему не нужен.

/* public interface IPrint {
    void print(String content);
}

public interface IScan {
    void scan(String content);
}

public interface IFax {
    void fax(String content);
}

public class AllInOnePrinter implements IPrint, IScan, IFax {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }

    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }

    @Override
    public void fax(String content) {
        System.out.println("Faxing: " + content);
    }
}

public class BasicPrinter implements IPrint {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }
}

public class PrintScanPrinter implements IPrint, IScan {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }

    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }
}*/



// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа Dependency-Inversion Principle, DIP:
// Система уведомлений
// В этом примере класс NotificationService напрямую зависит от конкретных классов EmailSender и SmsSender. Если нужно добавить новый тип уведомления, например, через мессенджер, придётся изменить класс NotificationService.

/* public interface INotificationSender {
    void send(String message);
}

public class EmailSender implements INotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

public class SmsSender implements INotificationSender {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

public class NotificationService {
    private INotificationSender notificationSender;

    public NotificationService(INotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void sendNotification(String message) {
        notificationSender.send(message);
    }
}*/





public void main() {
}
