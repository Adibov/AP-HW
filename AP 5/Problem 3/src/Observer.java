/**
 * Observer interface to implement Observer design pattern
 * @author Adibov
 * @version 1.0
 */
public interface Observer {
    /**
     * update observer state
     * @param news given news
     */
    public void update(News news);
}
