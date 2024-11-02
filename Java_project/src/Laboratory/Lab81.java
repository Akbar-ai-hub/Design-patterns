package Laboratory;

interface IPaymentProcessor {
    void processPayment(double amount);
    void refundPayment(double amount);
}

class InternalPaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " via internal system.");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding payment of " + amount + " via internal system.");
    }
}

class ExternalPaymentSystemA {
    public void makePayment(double amount) {
        System.out.println("Making payment of " + amount + " via ExternalPaymentSystemA.");
    }

    public void makeRefund(double amount) {
        System.out.println("Making refund of " + amount + " via ExternalPaymentSystemA.");
    }
}

class ExternalPaymentSystemB {
    public void sendPayment(double amount) {
        System.out.println("Sending payment of " + amount + " via ExternalPaymentSystemB.");
    }

    public void processRefund(double amount) {
        System.out.println("Processing refund of " + amount + " via ExternalPaymentSystemB.");
    }
}

class PaymentAdapterA implements IPaymentProcessor {
    private ExternalPaymentSystemA externalPaymentSystemA;

    public PaymentAdapterA(ExternalPaymentSystemA externalPaymentSystemA) {
        this.externalPaymentSystemA = externalPaymentSystemA;
    }

    @Override
    public void processPayment(double amount) {
        externalPaymentSystemA.makePayment(amount);
    }

    @Override
    public void refundPayment(double amount) {
        externalPaymentSystemA.makeRefund(amount);
    }
}

class PaymentAdapterB implements IPaymentProcessor {
    private ExternalPaymentSystemB externalPaymentSystemB;

    public PaymentAdapterB(ExternalPaymentSystemB externalPaymentSystemB) {
        this.externalPaymentSystemB = externalPaymentSystemB;
    }

    @Override
    public void processPayment(double amount) {
        externalPaymentSystemB.sendPayment(amount);
    }

    @Override
    public void refundPayment(double amount) {
        externalPaymentSystemB.processRefund(amount);
    }
}

class PaymentProcessorFactory {
    public static IPaymentProcessor getPaymentProcessor(String currency, String region) {
        if ("USD".equals(currency) && "US".equals(region)) {
            return new InternalPaymentProcessor();
        } else if ("EUR".equals(currency) || "EU".equals(region)) {
            return new PaymentAdapterA(new ExternalPaymentSystemA());
        } else if ("JPY".equals(currency) || "ASIA".equals(region)) {
            return new PaymentAdapterB(new ExternalPaymentSystemB());
        } else {
            throw new IllegalArgumentException("No payment processor available for the specified currency and region.");
        }
    }
}


public class Lab81 {
    public static void main(String[] args) {
        IPaymentProcessor internalProcessor = PaymentProcessorFactory.getPaymentProcessor("USD", "US");
        internalProcessor.processPayment(100.0);
        internalProcessor.refundPayment(50.0);

        IPaymentProcessor externalProcessorA = PaymentProcessorFactory.getPaymentProcessor("EUR", "EU");
        externalProcessorA.processPayment(200.0);
        externalProcessorA.refundPayment(100.0);

        IPaymentProcessor externalProcessorB = PaymentProcessorFactory.getPaymentProcessor("JPY", "ASIA");
        externalProcessorB.processPayment(300.0);
        externalProcessorB.refundPayment(150.0);
    }
}
