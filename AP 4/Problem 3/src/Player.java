import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

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
     * remove the given cards from the list
     * @param card the given card
     */
    public void removeCard(Card card) {
        if (!cards.contains(card))
            throw new IllegalArgumentException("Card doesn't exist in the hand.");
        cards.remove(card);
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
     * return a random card from cards
     * @return random card
     */
    public Card randomCard() {
        if (cards.size() == 0)
            throw new IllegalArgumentException("Cannot choose a random card from an empty list.");
        Random randomGen = new Random();
        int index = randomGen.nextInt(cards.size());
        return cards.get(index);
    }

    /**
     * return number of player's card
     * @return cards number
     */
    public int getCardsNumber() {
        return cards.size();
    }

    /**
     * getCards getter
     * @return cards
     */
    public ArrayList<Card> getCards() {
        return cards;
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
