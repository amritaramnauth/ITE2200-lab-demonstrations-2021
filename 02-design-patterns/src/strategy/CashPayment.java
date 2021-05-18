package strategy;

public class CashPayment implements PayStrategy {

    // define properties..

    @Override
    public void pay() {
        System.out.println("Paid via cash");
    }
}
