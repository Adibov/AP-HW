/**
 * Follower class to simulate persons
 * @author Adibov
 * @version 1.0
 * @see Observer
 */
public class Follower implements Observer {
    private String name;

    /**
     * simple constructor to make a new valid object
     * @param name follower name
     */
    public Follower(String name) {
        this.name = name;
    }

    /**
     * follow the given subject
     * @param subject the given subject
     */
    public void followSubject(Subject subject) {
        subject.registerObserverToSubject(this);
    }

    /**
     * unfollow from the given subject
     * @param subject the given subject
     */
    public void unfollowSubject(Subject subject) {
        subject.unregisterObserver(this);
    }

    /**
     * update observer state
     * @param news given news
     */
    @Override
    public void update(News news) {
        System.out.println("A news for " + name + " : \n" + news);
    }
}
