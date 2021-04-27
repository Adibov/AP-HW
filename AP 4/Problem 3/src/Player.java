import java.util.ArrayList;
import java.util.Objects;

public class Player {
    protected String name;
    protected ArrayList<Card> cards;

    /**
     * simple constructor with no input
     */
    public Player() {
        cards = new ArrayList<Card>();
    }

    /**
     * constructor to make a new valid object
     * @param name player name
     */
    public Player(String name) {
        this.name = name;
        cards = new ArrayList<Card>();
    }

    /**
     * add the given card to the list of cards
     * @param card the given card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * return number of player's card
     * @return cards number
     */
    public int getCardsNumber() {
        return cards.size();
    }

    /**
     * advance a turn
     * @param fieldCard field card
     * @return dropped card
     */
    public Card advanceTurn(FieldCard fieldCard) {
        if (cards.size() == 0)
            throw new IllegalArgumentException("No card exits to drop");
        return cards.get(0);
    }

    /**
     * override equals method
     * @param o the given object
     * @return boolean result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    /**
     * override hashCode method
     * @return int result
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
