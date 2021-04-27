import java.util.*;

public class Game {
    final private Scanner inputScanner = new Scanner(System.in);
    private int playerCount, personCount, computerCount, currentTurn = 0;
    private Card fieldCard;
    private ArrayList <Player> players;
    private HashSet<Card> cards; // available cards

    /**
     * start the game
     */
    public void startGame() {
        players = new ArrayList<Player>();
        cards = new HashSet<Card>();
        getInput();
        addAllCards();
        distributeCards();
    }

    /**
     * get game details from the user
     */
    public void getInput() {
        System.out.println("Enter number of player:");
        playerCount = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (playerCount < 3 || playerCount > 5) {
            System.out.println("Invalid input.");
            getInput();
            return;
        }

        System.out.println("Enter number of Computer player:");
        computerCount = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (computerCount < 0 || computerCount >= playerCount) {
            System.out.println("Invalid input.");
            getInput();
            return;
        }
        personCount = playerCount - computerCount;
        for (int i = 0; i < personCount; i++) {
            Player newPlayer = new Person();
            if (players.contains(newPlayer)) {
                System.out.println("This user already exists.");
                i--;
                continue;
            }
            players.add(newPlayer);
        }
        for (int i = 0; i < computerCount; i++)
            players.add(new Computer(Integer.toString(i + 1)));
    }

    /**
     * add all cards to the cards list
     */
    public void addAllCards() {
        int[] normalCard = {3, 4, 5, 6, 9, 13, 14};
        cards.add(new CardBlack7());
        for (COLOR color : COLOR.values())
            if (color != COLOR.BLACK)
                cards.add(new CardNonBlack7(color));

        for (COLOR color : COLOR.values()) {
            for (int number : normalCard)
                cards.add(new NormalCard(number, color));
            cards.add(new Card2(color));
            cards.add(new Card8(color));
            cards.add(new Card10(color));
            cards.add(new CardA(color));
            cards.add(new CardB(color));
        }
    }

    /**
     * distribute cards between players and choose a filed card
     */
    public void distributeCards() {
        for (Player player : players)
            for (int i = 0; i < 7; i++)
                addCardToPlayer(randomCard(), player);
        fieldCard = randomCard();
        while (fieldCard.isSpecial())
            fieldCard = randomCard();
        removeCard(fieldCard);
    }

    /**
     * get a random card from the available cards
     * @return result card
     */
    public Card randomCard() {
        Random randomGen = new Random();
        int randomIndex = randomGen.nextInt(cards.size());
        for (Card card : cards) {
            if (randomIndex == 0)
                return card;
            randomIndex--;
        }
        throw new IllegalArgumentException("Cannot return a random card.");
    }

    /**
     * add the given card to a player's hand
     * @param card the given card
     * @param player the given player
     */
    public void addCardToPlayer(Card card, Player player) {
        removeCard(card);
        player.addCard(card);
    }

    /**
     * remove the given card from the cards list
     * @param card the given card
     */
    public void removeCard(Card card) {
        if (!cards.contains(card))
            throw new IllegalArgumentException("No such card presents in cards list.");
        cards.remove(card);
    }
}
