package Homework;

interface Beveragee {
    double getCost();
    String getDescription();
}

class Espresso implements Beveragee {
    @Override
    public double getCost() {
        return 60.0;
    }

    @Override
    public String getDescription() {
        return "Эспрессо";
    }
}

class Tea1 implements Beveragee {
    @Override
    public double getCost() {
        return 40.0;
    }

    @Override
    public String getDescription() {
        return "Чай";
    }
}

class Latte implements Beveragee {
    @Override
    public double getCost() {
        return 80.0;
    }

    @Override
    public String getDescription() {
        return "Латте";
    }
}

class Mocha implements Beveragee {
    @Override
    public double getCost() {
        return 90.0;
    }

    @Override
    public String getDescription() {
        return "Мокка";
    }
}

abstract class BeverageDecorator implements Beveragee {
    protected Beveragee beverage;

    public BeverageDecorator(Beveragee beverage) {
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

class Milk extends BeverageDecorator {
    public Milk(Beveragee beverage) {
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

class Sugar extends BeverageDecorator {
    public Sugar(Beveragee beverage) {
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

class WhippedCream extends BeverageDecorator {
    public WhippedCream(Beveragee beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", взбитые сливки";
    }
}

class Syrup extends BeverageDecorator {
    public Syrup(Beveragee beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 12.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", сироп";
    }
}

public class Homework8 {
    public static void main(String[] args) {
        Beveragee beverage = new Espresso();

        beverage = new Milk(beverage);
        beverage = new Sugar(beverage);
        beverage = new Syrup(beverage);
        beverage = new WhippedCream(beverage);

        System.out.println("Описание напитка: " + beverage.getDescription());
        System.out.println("Стоимость напитка: " + beverage.getCost() + " руб.");
    }
}