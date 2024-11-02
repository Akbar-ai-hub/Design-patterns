package Laboratory;

interface IBeverage {
    double getCost();
    String getDescription();
}

class BaseBeverage implements IBeverage {
    @Override
    public double getCost() {
        return 50.0;
    }

    @Override
    public String getDescription() {
        return "Кофе";
    }
}

abstract class BeverageDecorator implements IBeverage {
    protected IBeverage beverage;

    public BeverageDecorator(IBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
}

class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }
}

class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", сахар";
    }
}

class ChocolateDecorator extends BeverageDecorator {
    public ChocolateDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", шоколад";
    }
}

class VanillaDecorator extends BeverageDecorator {
    public VanillaDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 8.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", ваниль";
    }
}

class CinnamonDecorator extends BeverageDecorator {
    public CinnamonDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 7.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", корица";
    }
}

public class Lab8 {
    public static void main(String[] args) {
        IBeverage beverage = new BaseBeverage();

        beverage = new MilkDecorator(beverage);
        beverage = new SugarDecorator(beverage);
        beverage = new ChocolateDecorator(beverage);
        beverage = new VanillaDecorator(beverage);
        beverage = new CinnamonDecorator(beverage);

        System.out.println("Описание напитка: " + beverage.getDescription());
        System.out.println("Стоимость напитка: " + beverage.getCost());
    }
}

