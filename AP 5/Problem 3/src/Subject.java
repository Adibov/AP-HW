import java.util.ArrayList;

/**
 * Subject class to notify observers
 * @author Adibov
 * @version 1.0
 */
public class Subject {
    final private ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * register the given observer to the given subject
     * @param observer the given observer
     */
    public void registerObserverToSubject(Observer observer) {
        if (observers.contains(observer))
            return;
        observers.add(observer);
    }

    /**
     * unregister the given observer
     * @param observer the given  observer
     */
    public void unregisterObserver(Observer observer) {
        if (!observers.contains(observer))
            return;
        observers.remove(observer);
    }

    /**
     * notify observers (publish the given news)
     * @param news the given news
     */
    public void notifyObservers(News news) {
        for (Observer observer : observers)
            observer.update(news);
    }

}
