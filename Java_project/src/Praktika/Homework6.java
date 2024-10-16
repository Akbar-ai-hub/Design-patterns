package Homework;

interface IPaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " с помощью банковской карты.");
    }
}

class PayPalPayment implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " через PayPal.");
    }
}

class CryptoPayment implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " с помощью криптовалюты.");
    }
}

class PaymentContext {
    private IPaymentStrategy paymentStrategy;

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("Не выбрана стратегия оплаты.");
        }
    }
}

public class Homework6 {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.pay(100.00);

        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.pay(250.50);

        paymentContext.setPaymentStrategy(new CryptoPayment());
        paymentContext.pay(500.00);
    }
}
