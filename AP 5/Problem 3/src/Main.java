import java.time.LocalDate;

/**
 * main class to instantiate some object and test package
 */
public class Main {
    /**
     * main method to make class runnable
     * @param args program args
     */
    public static void main(String[] args) {
        // make some instances
        Follower follower1 = new Follower("Mammad bagher");
        Follower follower2 = new Follower("Ahmad sadegh");
        Follower follower3 = new Follower("Kaftar batel");

        Club club1 = new Club("Barcelona");
        Club club2 = new Club("Real Madrid");
        Club club3 = new Club("Liverpool");

        Player player1 = new Player("Leonel", "Messi", "021", 33);
        Player player2 = new Player("Cristiano", "Ronaldo", "0098", 36);
        Player player3 = new Player("Mohammad", "Salah", "123", 28);

        // followers follow their favourite subjects
        follower1.followSubject(club1);
        follower1.followSubject(club3);
        follower1.followSubject(player1);

        follower2.followSubject(club1);
        follower2.followSubject(player1);

        follower3.followSubject(club2);
        follower3.followSubject(player2);
        follower3.followSubject(player3);

        // make some event
        club1.addPlayer(player1);
        club2.addPlayer(player2);
        club3.addPlayer(player3);

        Match match1 = new Match(LocalDate.now(), club1, club2);
        Match match2 = new Match(LocalDate.now(), club2, club1);
        Match match3 = new Match(LocalDate.now(), club3, club1);

        match1.finishMatch();
        match2.finishMatch();
        match3.finishMatch();
    }
}
