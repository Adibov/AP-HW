/**
 * MatchNews class to implement match news
 * @author Adibov
 * @version 1.0
 */
public class MatchNews extends News {
    private Match targetMatch;

    /**
     * simple constructor to make a new object
     * @param title news title
     * @param newsBody news body
     * @param targetMatch the match which the news is about
     */
    public MatchNews(String title, String newsBody, Match targetMatch) {
        super(title, newsBody);
        this.targetMatch = targetMatch;
    }

    /**
     * Override toString method
     * @return String result
     */
    @Override
    public String toString() {
        return "News about " + targetMatch + ":\n" + super.toString();
    }
}
