package Homework;

import java.util.Scanner;

abstract class Beverage {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void brew();
    protected abstract void addCondiments();

    protected boolean customerWantsCondiments() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like condiments? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();

        while (!answer.equals("yes") && !answer.equals("no")) {
            System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            answer = scanner.nextLine().toLowerCase();
        }

        return answer.equals("yes");
    }
}

class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

class HotChocolate extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Mixing chocolate powder with water");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding whipped cream");
    }
}

public class Homework71 {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();
        Beverage hotChocolate = new HotChocolate();

        System.out.println("Making tea...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();

        System.out.println("\nMaking hot chocolate...");
        hotChocolate.prepareRecipe();
    }
}

