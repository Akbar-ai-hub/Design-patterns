package Homework;

import java.util.Scanner;

interface IVehicle{
    void drive();
    void refuel();
}

class Car implements IVehicle{
    private String brand;
    private String model;
    private String typeFuel;

    public Car(String brand, String model, String typeFuel) {
        this.brand = brand;
        this.model = model;
        this.typeFuel = typeFuel;
    }

    @Override
    public void drive() {
        System.out.println("Автомобиль движется");
    }

    @Override
    public void refuel() {
        System.out.println("Заправка автомобиля");
    }
}

class Motorcycle implements IVehicle{
    private String typeMotorcycle;
    private float engineCapacity ;

    public Motorcycle(String type, float engineCapacity) {
        this.typeMotorcycle = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void drive() {
        System.out.println("Мотоцикл движется");
    }

    @Override
    public void refuel() {
        System.out.println("Заправка мотоцикла");
    }
}

class Truck implements IVehicle{
    private int loadCapacity;
    private int numberOfAxles;

    public Truck(int loadCapacity, int axles) {
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = axles;
    }

    @Override
    public void drive() {
        System.out.println("Грузовик движется");
    }

    @Override
    public void refuel() {
        System.out.println("Заправка грузовика");
    }
}

class Bus implements IVehicle {
    private int passengerCapacity;

    public Bus(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void drive() {
        System.out.println("Автобус движется");
    }

    @Override
    public void refuel() {
        System.out.println("Заправка автобуса.");
    }
}

abstract class VehicleFactory{
    public abstract IVehicle CreateVehicle();
}

class CarFactory extends VehicleFactory{
    private String brand;
    private String model;
    private String fuelType;

    public CarFactory(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Car(brand, model, fuelType);
    }
}

class MotorcycleFactory extends VehicleFactory{
    private String typeMotorcycle;
    private float engineCapacity ;

    public MotorcycleFactory(String type, float engineCapacity) {
        this.typeMotorcycle = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Motorcycle(typeMotorcycle, engineCapacity);
    }
}

class TruckFactory extends VehicleFactory{
    private int loadCapacity;
    private int numberOfAxles;

    public TruckFactory(int loadCapacity, int axles) {
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = axles;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Truck(loadCapacity, numberOfAxles);
    }
}

class BusFactory extends VehicleFactory {
    private int passengerCapacity;

    public BusFactory(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Bus(passengerCapacity);
    }
}



public class Homework4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип транспорта: 1. Автомобиль 2. Мотоцикл 3. Грузовик 4. Автобус");
        int choice = scanner.nextInt();

        VehicleFactory factory = null;

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
                System.out.println("Введите грузоподъемность и количество осей:");
                int loadCapacity = scanner.nextInt();
                int axles = scanner.nextInt();
                factory = new TruckFactory(loadCapacity, axles);
                break;
            case 4:
                System.out.println("Введите пассажировместимость:");
                int passengerCapacity = scanner.nextInt();
                factory = new BusFactory(passengerCapacity);
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }

        IVehicle vehicle = factory.CreateVehicle();
        vehicle.drive();
        vehicle.refuel();
    }
}
