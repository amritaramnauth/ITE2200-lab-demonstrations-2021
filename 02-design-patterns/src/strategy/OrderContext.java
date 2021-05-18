package strategy;

public class OrderContext {
    private int totalCost = 0;

    public void makePayment(PayStrategy strategy) {
        strategy.pay();
    }

}
