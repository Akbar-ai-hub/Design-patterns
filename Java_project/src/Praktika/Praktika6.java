package Praktika;

interface ICostCalculationStrategy{
    double Calculate(int passenger, int typeClass, boolean bag);
}

class AirplaneTravel implements ICostCalculationStrategy{
    double cost = 0;
    @Override
    public double Calculate(int passenger, int typeClass, boolean bag) {
        if(typeClass == 1){
            cost = passenger * 1000.6574;
        } else if (typeClass == 2) {
            cost = passenger * 900.6547;
        }
        else {
            cost = passenger * 600.6547;
        }
        if (bag){
            cost = cost * 2;
        }
        return cost;
    }
}

class TrainTravel implements ICostCalculationStrategy{
    double cost = 0;
    @Override
    public double Calculate(int passenger, int typeClass, boolean bag) {
        if(typeClass == 1){
            cost = passenger * 700.6574;
        } else if (typeClass == 2) {
            cost = passenger * 500.6547;
        }
        else {
            cost = passenger * 400.6547;
        }
        if (bag){
            cost = cost * 2;
        }
        return cost;
    }
}

class BusTravel implements ICostCalculationStrategy{
    double cost = 0;
    @Override
    public double Calculate(int passenger, int typeClass, boolean bag) {
        if(typeClass == 1){
            cost = passenger * 500.6574;
        } else if (typeClass == 2) {
            cost = passenger * 300.6547;
        }
        else {
            cost = passenger * 250.6547;
        }
        if (bag){
            cost = cost * 2;
        }
        return cost;
    }
}

class TravelBookingContext{
    private ICostCalculationStrategy calculationStrategy;
    public void ChangeCalculation(ICostCalculationStrategy calculationStrategy){
        this.calculationStrategy = calculationStrategy;
    }

    public double CalculateTravelCost(int passenger, int typeClass, boolean bag) throws Exception {
        if (calculationStrategy == null){
            throw new Exception("Error");
        }
        return calculationStrategy.Calculate(passenger, typeClass, bag);
    }
}

public class Praktika6 {
    public static void main(String[] args) throws Exception {
        TravelBookingContext context = new TravelBookingContext();
        context.ChangeCalculation(new AirplaneTravel());
        double result = context.CalculateTravelCost(1, 1, false);
        System.out.println(result);
    }
}
