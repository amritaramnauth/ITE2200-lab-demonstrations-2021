package strategy;

public class DebitCardPayment implements  PayStrategy {
    @Override
    public void pay() {
        System.out.println("Paid with debit card");
    }
}
