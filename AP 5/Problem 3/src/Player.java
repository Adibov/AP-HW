/**
 * Player class to implement football players
 * @author Adibov
 * @version 1.0
 * @see Subject
 */
public class Player extends Subject {
    final private String firstname, lastname, idCardNumber;
    final private int age;

    /**
     * make a new player object
     * @param firstname player's firstname
     * @param lastname player's lastname
     * @param idCardNumber player's id card number
     * @param age player's age
     */
    public Player(String firstname, String lastname, String idCardNumber, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.idCardNumber = idCardNumber;
        this.age = age;
        notifyObservers(new PlayerNews(
                "A new player has been hired",
                this + " has been hired to play in league.",
                this
        ));
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}