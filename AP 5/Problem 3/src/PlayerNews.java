/**
 * PlayerNews class to implement player news
 * @author Adibov
 * @version 1.0
 */
public class PlayerNews extends News {
    private Player targetPlayer;

    /**
     * simple constructor to make a new object
     * @param title news title
     * @param newsBody news body
     * @param targetPlayer the player which the news is about
     */
    public PlayerNews(String title, String newsBody, Player targetPlayer) {
        super(title, newsBody);
        this.targetPlayer = targetPlayer;
    }

    /**
     * Override toString method
     * @return String result
     */
    @Override
    public String toString() {
        return "News about " + targetPlayer + ":\n" + super.toString();
    }
}
