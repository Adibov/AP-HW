/**
 * News class to classify different news
 *
 * @author Adibov
 * @version 1.0
 */
public class News {
    protected String title, newsBody;

    /**
     * construct a new valid object
     * @param title news title
     * @param newsBody news body
     */
    public News(String title, String newsBody) {
        this.title = title;
        this.newsBody = newsBody;
    }

    /**
     * override toString method
     * @return String result
     */
    @Override
    public String toString() {
        return title + "\n" + newsBody + "\n";
    }
}
