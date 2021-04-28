import java.io.IOException;
import java.util.*;

public class Game {
    final private Scanner inputScanner = new Scanner(System.in);
    private int playerCount, personCount, computerCount, currentPlayer, direction, toPenalize;
    private FieldCard fieldCard;
    private ArrayList<Player> players;
    private HashSet<Card> cards; // available cards

    /**
     * start the game
     */
    public void startGame() {
        players = new ArrayList<Player>();
        cards = new HashSet<Card>();
        currentPlayer = 0;
        direction = 1;
        toPenalize = 0;
        getInput();
        addAllCards();
        distributeCards();

        while (!finishedGame()) {
            clearScreen();
            advanceTurn();
            clearScreen();
            showSituation();
            incrementTurn(1);
            System.out.println("Press Enter to continue.");
            inputScanner.nextLine();
        }
        showRankList();
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
            Player newPlayer = new Person(i + 1);
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
            cards.add(new Card(12, color)); // CardA
        }
    }

    /**
     * distribute cards between players and choose a filed card
     */
    public void distributeCards() {
        for (Player player : players)
            for (int i = 0; i < 7; i++)
                addCardToPlayer(randomCard(), player);
        Card tmpFieldCard = randomCard();
        while (tmpFieldCard.isSpecial())
            tmpFieldCard = randomCard();
        fieldCard = new FieldCard(tmpFieldCard.getNumber(), tmpFieldCard.getColor(), false);
        removeCard(tmpFieldCard);
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
     * add the given card to the cards list
     * @param card the given card
     */
    public void addCard(Card card) {
        cards.add(card);
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

    /**
     * check if the game is finished
     * @return boolean result
     */
    public boolean finishedGame() {
        for (Player player : players)
            if (player.getCardsNumber() == 0)
                return true;
        return false;
    }

    /**
     * advance a turn
     */
    public void advanceTurn() {
        System.out.println(players.get(currentPlayer).getName() + "'s turn:");
        Card droppedCard = players.get(currentPlayer).advanceTurn(fieldCard);
        if (droppedCard == null || !fieldCard.checkCardValidation(droppedCard)) {
            if (fieldCard.getNumber() == 7 && fieldCard.isContinuous()) {
                penalizePlayer(players.get(currentPlayer), toPenalize);
                toPenalize = 0;
                fieldCard.setContinuous(false);
                return;
            }

            Card newCard = randomCard();
            addCardToPlayer(newCard, players.get(currentPlayer));
            if (fieldCard.checkCardValidation(newCard))
                newCard.applyCard(this);
            return;
        }
        droppedCard.applyCard(this);
    }

    /**
     * penalize the given player with the given number of cards
     * @param player the given player
     * @param amount number of cards
     */
    public void penalizePlayer(Player player, int amount) {
        if (amount > cards.size())
            throw new IllegalArgumentException("Cannot penalize this amount of card.");
        for (int i = 0; i < amount; i++) {
            Card penaltyCard = randomCard();
            removeCard(penaltyCard);
            player.addCard(penaltyCard);
        }
    }

    /**
     * increment turn by the given amount
     * @param amount the given amount
     */
    public void incrementTurn(int amount) {
        currentPlayer += (amount * direction) % playerCount;
        currentPlayer = (currentPlayer + playerCount) % playerCount;
    }

    /**
     * fieldCard setter
     * @param fieldCard new value
     */
    public void setFieldCard(FieldCard fieldCard) {
        this.fieldCard = fieldCard;
    }

    /**
     * currentPlayer gettter
     * @return currentPlayer
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * players getter
     * @return players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * fieldCard getter
     * @return fieldCard
     */
    public FieldCard getFieldCard() {
        return fieldCard;
    }

    /**
     * direction getter
     * @return direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * direction setter
     * @param direction new value
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * show players except one
     * @param index the exception player
     */
    public void showPlayers(int index) {
        System.out.println("Players:");
        int num = 1, forIndex = 1;
        for (Player player : players) {
            if (forIndex != index) {
                System.out.println("#" + num + ": " + player.name + " with " + player.getCardsNumber() + " card(s) in hand.");
                num++;
            }
            forIndex++;
        }
    }

    /**
     * show current situation of the game after playing one card
     */
    public void showSituation() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + players.get(currentPlayer).getName() + ConsoleColors.WHITE_BRIGHT + "'s turn finished and after that, Field card is:" + ConsoleColors.RESET);
        fieldCard.showCard(0);
        System.out.println(ConsoleColors.WHITE_BRIGHT + "\nAnd people's hands is like this:" + ConsoleColors.RESET);
        for (Player player : players)
            player.showCardsAnonymously();
        System.out.print(ConsoleColors.WHITE_BRIGHT + "Direction: " + ConsoleColors.YELLOW_BOLD);
        if (direction == 1)
            System.out.println("Clockwise" + ConsoleColors.RESET);
        else
            System.out.println("Counter Clockwise" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.WHITE_BRIGHT + "Did in the last turn 7 show up: " + ConsoleColors.RED);
        if (fieldCard.isContinuous())
            System.out.println("Yes" + ConsoleColors.RESET);
        else
            System.out.println("No" + ConsoleColors.RESET);
    }

    /**
     * show player ranks with respect to their points
     */
    public void showRankList() {
        System.out.println("Rank list:");
        HashSet<Player> rank = new HashSet<Player>(players);
        int num = 1;
        while (rank.size() != 0) {
            Player firstPlayer = rank.iterator().next();
            for (Player player : rank)
                if (player.getPoints() < firstPlayer.getPoints())
                    firstPlayer = player;
            rank.remove(firstPlayer);
            System.out.println("#" + num + ": " + firstPlayer.getName());
            num++;
        }
    }

    /**
     * player count getter
     * @return player count
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * toPenalize getter
     * @return toPenalize
     */
    public int getToPenalize() {
        return toPenalize;
    }

    /**
     * toPenalize setter
     * @param toPenalize new value
     */
    public void setToPenalize(int toPenalize) {
        this.toPenalize = toPenalize;
    }

    /**
     * clear terminal screen
     */
    private static void clearScreen() {
        for (int i = 0; i < 30; i++)
            System.out.println();
    }

}
