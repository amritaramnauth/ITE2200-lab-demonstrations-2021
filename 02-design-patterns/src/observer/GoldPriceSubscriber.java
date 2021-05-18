package observer;

public class GoldPriceSubscriber implements Subscriber {

    private double goldPrice;
    private static int observerCounter = 0;
    private int observerId;
    private Publisher goldPriceChanger;

    public GoldPriceSubscriber(Publisher goldPriceChanger) {
        this.goldPriceChanger = goldPriceChanger;
        this.observerId = ++observerCounter;

        System.out.println("New customer observer "+ this.observerId);
        this.goldPriceChanger.register(this);
    }

    @Override
    public void update(double goldPrice) {
        this.goldPrice = goldPrice;
        printGoldPrices();
    }

    public void printGoldPrices() {
        System.out.println("Customer observer "+observerId +" -- Gold price change "+goldPrice);
    }
}
