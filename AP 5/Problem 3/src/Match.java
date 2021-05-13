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
    private boolean isFinished = false;

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
        guestTeam.addMatch(this);
        hostTeam.addMatch(this);
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

    /**
     * finish competition
     */
    public void finishMatch() {
        isFinished = true;
        notifyObservers(new MatchNews(
                "Match has been finished",
                "A match between " + guestTeam + " and " + hostTeam + " has been finished.",
                this
        ));
    }

    /**
     * matchDate getter
     * @return matchDate
     */
    public LocalDate getMatchDate() {
        return matchDate;
    }

    /**
     * guestTeam getter
     * @return guestTeam
     */
    public Club getGuestTeam() {
        return guestTeam;
    }

    /**
     * hostTeam getter
     * @return hostTeam
     */
    public Club getHostTeam() {
        return hostTeam;
    }

    /**
     * Override toString method
     * @return String result
     */
    @Override
    public String toString() {
        return guestTeam + " VS. " + hostTeam;
    }
}
