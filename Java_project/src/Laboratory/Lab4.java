package Laboratory;

import java.util.Scanner;

interface ITransport{
    void move();
    void fuelUp();
}

class Car implements ITransport {
    private String brand;
    private String model;
    private String typeFuel;

    public Car(String brand, String model, String typeFuel) {
        this.brand = brand;
        this.model = model;
        this.typeFuel = typeFuel;
    }

    @Override
    public void move() {
        System.out.println("Автомобиль движется");
    }

    @Override
    public void fuelUp() {
        System.out.println("Заправка автомобиля");
    }
}

class Motorcycle implements ITransport {
    private String typeMotorcycle;
    private float engineCapacity ;

    public Motorcycle(String type, float engineCapacity) {
        this.typeMotorcycle = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void move() {
        System.out.println("Мотоцикл движется");
    }

    @Override
    public void fuelUp() {
        System.out.println("Заправка мотоцикла");
    }
}

class Plane implements ITransport {
    private int passengerCapacity;
    private int crew;

    public Plane(int passengerCapacity, int crew) {
        this.passengerCapacity = passengerCapacity;
        this.crew = crew;
    }

    @Override
    public void move() {
        System.out.println("Самолет движется");
    }

    @Override
    public void fuelUp() {
        System.out.println("Заправка самолета");
    }
}

class Bicycle implements ITransport {
    private int wheelSize;
    private String type;

    public Bicycle(int wheelSize, String type) {
        this.wheelSize = wheelSize;
        this.type = type;
    }

    @Override
    public void move() {
        System.out.println("Велосипед движется");
    }

    @Override
    public void fuelUp() {
        System.out.println("Зарядка велосипеда");
    }
}

abstract class TransportFactory{
    public abstract ITransport CreateTransport();
}

class CarFactory extends TransportFactory {
    private String brand;
    private String model;
    private String fuelType;

    public CarFactory(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public ITransport CreateTransport() {
        return new Car(brand, model, fuelType);
    }
}

class MotorcycleFactory extends TransportFactory {
    private String typeMotorcycle;
    private float engineCapacity ;

    public MotorcycleFactory(String type, float engineCapacity) {
        this.typeMotorcycle = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public ITransport CreateTransport() {
        return new Motorcycle(typeMotorcycle, engineCapacity);
    }
}

class PlaneFactory extends TransportFactory {
    private int passengerCapacity;
    private int crew;

    public PlaneFactory(int passengerCapacity, int crew) {
        this.passengerCapacity = passengerCapacity;
        this.crew = crew;
    }

    @Override
    public ITransport CreateTransport() {
        return new Plane(passengerCapacity, crew);
    }
}

class BicycleFactory extends TransportFactory {
    private int wheelSize;
    private String type;

    public BicycleFactory(int wheelSize, String type) {
        this.wheelSize = wheelSize;
        this.type = type;
    }

    @Override
    public ITransport CreateTransport() {
        return new Bicycle(wheelSize, type);
    }
}



public class Lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип транспорта: 1. Автомобиль 2. Мотоцикл 3. Самолет 4. Велосипед");
        int choice = scanner.nextInt();

        TransportFactory factory = null;

        switch (choice) {
            case 1:
                System.out.println("Введите марку, модель и тип топлива:");
                String brand = scanner.next();
                String model = scanner.next();
                String fuelType = scanner.next();
                factory = new CarFactory(brand, model, fuelType);
                break;
            case 2:
                System.out.println("Введите тип мотоцикла (спортивный/туристический) и объем двигателя:");
                String type = scanner.next();
                float engineCapacity = scanner.nextFloat();
                factory = new MotorcycleFactory(type, engineCapacity);
                break;
            case 3:
                System.out.println("Введите количество пассажиров и количество людей, управляющих самолетом:");
                int passengerCapacity = scanner.nextInt();
                int crew = scanner.nextInt();
                factory = new PlaneFactory(passengerCapacity, crew);
                break;
            case 4:
                System.out.println("Введите размер колес и тип велосипеда(горный/городской/шоссейный/BMX/складной):");
                int wheelSize = scanner.nextInt();
                String typeBicycle = scanner.next();
                factory = new BicycleFactory(wheelSize, typeBicycle);
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }

        ITransport transport = factory.CreateTransport();
        transport.move();
        transport.fuelUp();
    }
}

