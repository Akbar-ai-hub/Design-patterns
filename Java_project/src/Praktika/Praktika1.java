package Praktika;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void startEngine(){
        System.out.println("Запуск двигателя.");
    }

    public void stopEngine(){
        System.out.println("Остановка двигателя.");
    }
    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ")";
    }

}

class Car extends Vehicle {
    private int doors;
    private String transmission;

    public Car(String brand, String model, int year, int doors, String transmission){
        super(brand, model, year);
        this.doors = doors;
        this.transmission = transmission;
    }

}

class Motorcycle extends Vehicle {
    private String bodyType;
    private boolean box;

    public Motorcycle(String brand, String model, int year, String bodyType, boolean box){
        super(brand, model, year);
        this.bodyType = bodyType;
        this.box = box;
    }

}

class Garage{
    List<Vehicle> transports = new ArrayList<>();

    public void addTransport(Vehicle vehicle){
        transports.add(vehicle);
    }

    public void removeTransport(Vehicle vehicle){
        transports.remove(vehicle);
    }
}

class Fleet{
    private List<Garage> garages = new ArrayList<>();

    public void addGarage(Garage garage){
        garages.add(garage);
    }

    public void removeGarage(Garage garage){
        garages.remove(garage);
    }

    public void searchTransport(String name){
        for (Garage garage : garages) {
            for (Vehicle vehicle : garage.transports) {
                if (vehicle.toString().contains(name)) {
                    System.out.println("Найдено: " + vehicle);
                }
            }
        }
    }
}

public class Praktika1 {
    public static void main(String[] args){
        Car car1 = new Car("Toyota", "Camry", 2020, 4, "Автомат");
        Car car2 = new Car("Honda", "Civic", 2018, 4, "Механика");
        Motorcycle bike1 = new Motorcycle("Yamaha", "MT-07", 2019, "Спортбайк", false);
        Motorcycle bike2 = new Motorcycle("Harley-Davidson", "Touring", 2021, "Круизер", true);

        Garage garage1 = new Garage();
        Garage garage2 = new Garage();

        garage1.addTransport(car1);
        garage1.addTransport(bike1);
        garage2.addTransport(car2);
        garage2.addTransport(bike2);

        Fleet fleet = new Fleet();
        fleet.addGarage(garage1);
        fleet.addGarage(garage2);

        fleet.searchTransport("Camry");

        garage1.removeTransport(car1);
    }
}
