import java.time.LocalDate;

/**
 * Match class to implement football matches
 * @author Adibov
 * @version 1.0
 * @see Subject
 */
public class Match extends Subject {
    private LocalDate matchDate;
    private Club guestTeam, hostTeam;

    /**
     * constructor to make a new valid object
     * @param matchDate match date
     * @param guestTeam guest team club
     * @param hostTeam host team club
     */
    public Match(LocalDate matchDate, Club guestTeam, Club hostTeam) {
        this.matchDate = matchDate;
        this.guestTeam = guestTeam;
        this.hostTeam = hostTeam;
    }

    /**
     * get opponent of the given club
     * @param targetClub the given club
     * @return opponent club
     */
    public Club getOpponent(Club targetClub) {
        if (targetClub.equals(guestTeam))
            return hostTeam;
        else if (targetClub.equals(hostTeam))
            return guestTeam;
        else
            return null;
    }
}
