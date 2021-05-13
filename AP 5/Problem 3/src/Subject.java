import java.util.ArrayList;
import java.util.UUID;

/**
 * Subject class to notify observers
 * @author Adibov
 * @version 1.0
 */
public class Subject {
    final private ArrayList<Observer> observers = new ArrayList<Observer>();
    final private UUID id;

    /**
     * simple constructor to initialize id
     */
    public Subject() {
        id = UUID.randomUUID();
    }

    /**
     * register the given observer to the given subject
     * @param observer the given observer
     */
    protected void registerObserverToSubject(Observer observer) {
        if (observers.contains(observer))
            return;
        observers.add(observer);
    }

    /**
     * unregister the given observer
     * @param observer the given  observer
     */
    protected void unregisterObserver(Observer observer) {
        if (!observers.contains(observer))
            return;
        observers.remove(observer);
    }

    /**
     * notify observers (publish the given news)
     * @param news the given news
     */
    protected void notifyObservers(News news) {
        for (Observer observer : observers)
            observer.update(news);
    }

    /**
     * Override equals method
     * @param o given object
     * @return boolean result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        return ((Subject)o).id.equals(id);
    }
}
