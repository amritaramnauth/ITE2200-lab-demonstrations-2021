package observer;

public interface Publisher {
    public void register(Subscriber o);
    public void unregister(Subscriber o);
    public void notifyObserver();
}
