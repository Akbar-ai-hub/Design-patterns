package Homework;

interface IPaymentProcessor {
    void processPayment(double amount);
}

class PayPalPaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through PayPal.");
    }
}

class StripePaymentService {
    public void makeTransaction(double totalAmount) {
        System.out.println("Processing transaction of " + totalAmount + " through Stripe.");
    }
}

class StripePaymentAdapter implements IPaymentProcessor {
    private StripePaymentService stripePaymentService;

    public StripePaymentAdapter(StripePaymentService stripePaymentService) {
        this.stripePaymentService = stripePaymentService;
    }

    @Override
    public void processPayment(double amount) {
        stripePaymentService.makeTransaction(amount);
    }
}

class SquarePaymentService {
    public void executePayment(double amount) {
        System.out.println("Executing payment of " + amount + " through Square.");
    }
}

class SquarePaymentAdapter implements IPaymentProcessor {
    private SquarePaymentService squarePaymentService;

    public SquarePaymentAdapter(SquarePaymentService squarePaymentService) {
        this.squarePaymentService = squarePaymentService;
    }

    @Override
    public void processPayment(double amount) {
        squarePaymentService.executePayment(amount);
    }
}



public class Homework81 {
    public static void main(String[] args) {
        IPaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        paypalProcessor.processPayment(100.0);

        StripePaymentService stripeService = new StripePaymentService();
        IPaymentProcessor stripeProcessor = new StripePaymentAdapter(stripeService);
        stripeProcessor.processPayment(200.0);

        SquarePaymentService squareService = new SquarePaymentService();
        IPaymentProcessor squareProcessor = new SquarePaymentAdapter(squareService);
        squareProcessor.processPayment(300.0);
    }
}
