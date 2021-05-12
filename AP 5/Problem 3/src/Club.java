import java.util.ArrayList;

/**
 * Club class to implement football clubs
 * @author Adibov
 * @version 1.0
 * @see Subject
 */
public class Club extends Subject {
    final private ArrayList<Match> upcomingMatches = new ArrayList<Match>();
    final private ArrayList<Player> playersList = new ArrayList<Player>();

    /**
     * add the given player to the list of players
     * @param player the given player
     */
    public void addPlayer(Player player) {
        playersList.add(player);
    }

    /**
     * add a new upcoming match
     * @param match new upcoming match
     */
    public void addMatch(Match match) {
        upcomingMatches.add(match);
    }
}
