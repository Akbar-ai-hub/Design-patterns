package Homework;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

interface IObserver {
    void update(double usdRate, double eurRate);
}

interface ISubject {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}

class CurrencyExchange implements ISubject {
    private double usdRate;
    private double eurRate;
    private List<IObserver> observers;

    public CurrencyExchange() {
        observers = new ArrayList<>();
    }

    public void setRates(double usdRate, double eurRate) {
        this.usdRate = usdRate;
        this.eurRate = eurRate;
        notifyObservers();
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(usdRate, eurRate);
        }
    }
}

class DisplayObserver implements IObserver {
    private String name;

    public DisplayObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(double usdRate, double eurRate) {
        System.out.println(name + " - Обновление курсов: USD: " + usdRate + ", EUR: " + eurRate);
    }
}

class FileObserver implements IObserver {

    @Override
    public void update(double usdRate, double eurRate) {
        try (FileWriter writer = new FileWriter("exchange_rates.txt", true)) {
            writer.write("Курсы обновлены: USD: " + usdRate + ", EUR: " + eurRate + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



public class Homework61 {
    public static void main(String[] args) {
        CurrencyExchange currencyExchange = new CurrencyExchange();

        DisplayObserver displayObserver = new DisplayObserver("Экран 1");
        FileObserver fileObserver = new FileObserver();

        currencyExchange.addObserver(displayObserver);
        currencyExchange.addObserver(fileObserver);

        currencyExchange.setRates(74.50, 88.30);
        currencyExchange.setRates(75.00, 89.00);

        currencyExchange.removeObserver(displayObserver);
        currencyExchange.setRates(76.00, 90.00);
    }
}

