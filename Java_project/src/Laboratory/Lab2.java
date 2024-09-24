package Laboratory;/*Произведите корректную (правильную) по вашему мнению реализацию с применениемпринципа DRY:
Использование методов для устранения дублирования кода */
/*class OrderService {
    private void processOrder(String action, String productName, int quantity, double price) {
        double totalPrice = quantity * price;
        System.out.println("Order for " + productName + " " + action + ". Total: " + totalPrice);
    }

    public void createOrder(String productName, int quantity, double price) {
        processOrder("created", productName, quantity, price);
    }

    public void updateOrder(String productName, int quantity, double price) {
        processOrder("updated", productName, quantity, price);
    }
}*/

//Использование общих базовых классов

/*class Vehicles {
    protected String vehicle;

    public Vehicles(String vehicle){
        this.vehicle = vehicle;
    }

    public void Start() {
        System.out.println("{vehicle} is starting");
    }

    public void Stop() {
        System.out.println("{vehicle} is stopping");
    }
}

class Cars extends Vehicles {
    public Cars(){
        super("Car");
    }
}

class Truck extends Vehicles {
    public Truck(){
        super("Truck");
    }
}*/

//Произведите корректную (правильную) по вашему мнению реализацию с применением принципа KISS:Избегание чрезмерного использования абстракций

/*class Calculator {
    public void add(int a, int b) {
        System.out.println(a + b);
    }
}*/

//Избегание избыточного использования шаблонов проектирования

/*class Service {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

class Client {
    public void execute() {
        Service service = new Service();
        service.doSomething();
    }
}*/

//Произведите корректную (правильную) по вашему мнению реализацию с применением принципа YAGNI:Избыточное создание абстракций

/*class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }
}*/

//Излишняя параметризация методов

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public void logResult(int result) {
        System.out.println("Result: " + result);
    }
}

public class Lab2 {
    public static void main(String[] args) {
        MathOperations mathOps = new MathOperations();

        int result = mathOps.add(5, 3);
        mathOps.logResult(result);
    }
}
