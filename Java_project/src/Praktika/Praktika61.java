package Praktika;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface IObserver {
    void update(String stockSymbol, double price);
}

interface ISubject {
    void addObserver(IObserver observer, String stockSymbol);
    void removeObserver(IObserver observer, String stockSymbol);
    void notifyObservers(String stockSymbol, double price);
}

class StockExchange implements ISubject {
    private final Map<String, List<IObserver>> observers = new HashMap<>();
    private final Map<String, Double> stockPrices = new HashMap<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void addObserver(IObserver observer, String stockSymbol) {
        observers.computeIfAbsent(stockSymbol, k -> new ArrayList<>()).add(observer);
        System.out.println("Added observer for stock: " + stockSymbol);
    }

    @Override
    public void removeObserver(IObserver observer, String stockSymbol) {
        List<IObserver> stockObservers = observers.get(stockSymbol);
        if (stockObservers != null) {
            stockObservers.remove(observer);
            System.out.println("Removed observer for stock: " + stockSymbol);
        }
    }

    @Override
    public void notifyObservers(String stockSymbol, double price) {
        List<IObserver> stockObservers = observers.get(stockSymbol);
        if (stockObservers != null) {
            for (IObserver observer : stockObservers) {
                executorService.submit(() -> observer.update(stockSymbol, price));
            }
        }
    }

    public void setStockPrice(String stockSymbol, double newPrice) {
        stockPrices.put(stockSymbol, newPrice);
        System.out.println("Price of " + stockSymbol + " changed to " + newPrice);
        notifyObservers(stockSymbol, newPrice);
    }

    public double getStockPrice(String stockSymbol) {
        return stockPrices.getOrDefault(stockSymbol, 0.0);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

class Trader implements IObserver {
    private final String name;

    public Trader(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Trader " + name + " notified: " + stockSymbol + " price changed to " + price);
    }
}

class TradingRobot implements IObserver {
    private final String robotName;
    private final double threshold;

    public TradingRobot(String robotName, double threshold) {
        this.robotName = robotName;
        this.threshold = threshold;
    }

    @Override
    public void update(String stockSymbol, double price) {
        if (price > threshold) {
            System.out.println(robotName + " is selling " + stockSymbol + " as price exceeded " + threshold);
        } else {
            System.out.println(robotName + " is buying " + stockSymbol + " as price is below " + threshold);
        }
    }
}

public class Praktika61 {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();

        Trader trader1 = new Trader("Alice");
        Trader trader2 = new Trader("Siri");
        TradingRobot robot = new TradingRobot("AutoBot", 150.00);

        stockExchange.addObserver(trader1, "AAPL");
        stockExchange.addObserver(trader2, "AAPL");
        stockExchange.addObserver(robot, "AAPL");

        stockExchange.setStockPrice("AAPL", 145.00);
        stockExchange.setStockPrice("AAPL", 155.00);

        stockExchange.removeObserver(trader2, "AAPL");
        stockExchange.setStockPrice("AAPL", 160.00);

        stockExchange.shutdown();
    }
}
