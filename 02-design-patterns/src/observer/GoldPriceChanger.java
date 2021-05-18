package observer;

import java.util.ArrayList;

public class GoldPriceChanger implements Publisher {

    private ArrayList<Subscriber> subscribers;
    private double goldPrice;

    public GoldPriceChanger() {
        this.subscribers = new ArrayList<Subscriber>();
    }

    @Override
    public void register(Subscriber o) {
        subscribers.add(o);
    }

    @Override
    public void unregister(Subscriber o) {
        var observerIndex = subscribers.indexOf(o);
        System.out.println("Customer observer at "+ (observerIndex+1) + " removed");
        subscribers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(goldPrice);
        }
    }

    public void setGoldPrice(double price) {
        this.goldPrice = price;
        notifyObserver();
    }
}
