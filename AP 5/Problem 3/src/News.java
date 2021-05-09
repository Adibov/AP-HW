/**
 * News class to classify different news
 *
 * @author Adibov
 * @version 1.0
 */
public class News {
    String title, newsBody;

    /**
     * construct a new valid object
     * @param title news title
     * @param newsBody news body
     */
    public News(String title, String newsBody) {
        this.title = title;
        this.newsBody = newsBody;
    }
}
