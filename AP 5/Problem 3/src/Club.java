import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/**
 * Club class to implement football clubs
 * @author Adibov
 * @version 1.0
 * @see Subject
 */
public class Club extends Subject {
    final private ArrayList<Match> upcomingMatches = new ArrayList<Match>();
    final private ArrayList<Player> playersList = new ArrayList<Player>();
    private String clubName;

    /**
     * class constructor to make a new object
     * @param clubName club name
     */
    public Club(String clubName) {
        this.clubName = clubName;
    }

    /**
     * add the given player to the list of players
     * @param player the given player
     */
    public void addPlayer(Player player) {
        playersList.add(player);
        notifyObservers(new ClubNews(
                "New Player joined to the club",
                "After some negotiations, the club accepted " + player + "'s joining request.",
                this
        ));
    }

    /**
     * add a new upcoming match
     * @param match new upcoming match
     */
    public void addMatch(Match match) {
        upcomingMatches.add(match);
        notifyObservers(new MatchNews(
                "A new upcoming match",
                "A new upcoming match will be held on " + match.getMatchDate() + " between " + match.getGuestTeam() + " and "
                        + match.getHostTeam() + ", And " + match.getHostTeam() + " will be host of the game.",
                match
        ));
    }

    /**
     * Override toString method
     * @return String result
     */
    @Override
    public String toString() {
        return clubName;
    }
}
