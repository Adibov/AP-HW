/**
 * ClubNews class to implement club news
 * @author Adibov
 * @version 1.0
 */
public class ClubNews extends News {
    private Club targetClub;

    /**
     * simple constructor to make a new object
     * @param title news title
     * @param newsBody news body
     * @param targetClub the club which the news is about
     */
    public ClubNews(String title, String newsBody, Club targetClub) {
        super(title, newsBody);
        this.targetClub = targetClub;
    }

    /**
     * Override toString method
     * @return String result
     */
    @Override
    public String toString() {
        return "News about " + targetClub + ":\n" + super.toString();
    }
}
