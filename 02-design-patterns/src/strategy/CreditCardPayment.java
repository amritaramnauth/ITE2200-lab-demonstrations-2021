package strategy;

public class CreditCardPayment implements  PayStrategy {
    @Override
    public void pay() {
        System.out.println("Paid via credit card");
    }
}
