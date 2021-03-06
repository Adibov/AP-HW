import java.util.Scanner;

public class Person extends Player {
    final private Scanner inputScanner = new Scanner(System.in);

    /**
     * simple constructor
     * @param name player name
     */
    public Person(String name) {
        super(name);
    }

    /**
     * simple constructor to get name from stdin
     */
    public Person(int num) {
        super();
        System.out.println("Enter Player #" + num + "'s name:");
        name = inputScanner.nextLine();
    }

    /**
     * check if the player can drop at least one card
     * @param fieldCard field card
     * @return boolean result
     */
    public boolean canDrop(FieldCard fieldCard) {
        for (Card card : cards)
            if (fieldCard.checkCardValidation(card))
                return true;
        return false;
    }

    /**
     * let the player choose a card to drop
     * @param fieldCard field card
     * @return dropped card
     */
    public Card chooseCard(FieldCard fieldCard) {
        fieldCard.showCard(0);
        showCards();
        System.out.println("Choose a card to drop:");
        int cardIndex = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (cardIndex < 1 || cardIndex > cards.size()) {
            System.out.println("Invalid input.");
            return advanceTurn(fieldCard);
        }
        Card droppedCard = cards.get(cardIndex - 1);
        if (!fieldCard.checkCardValidation(droppedCard)) {
            System.out.println("Card doesn't match with the field card.");
            return advanceTurn(fieldCard);
        }
        return droppedCard;
    }

    /**
     * advance a turn
     * @param fieldCard field card
     * @return dropped card
     */
    @Override
    public Card advanceTurn(FieldCard fieldCard) {
        if (!canDrop(fieldCard))
            return null;
        Card droppedCard = chooseCard(fieldCard);
        if (droppedCard.getNumber() == 12) {
            System.out.println("Choose a color for next turn: (black, blue, red, green)");
            String nextColor = inputScanner.next(); inputScanner.nextLine(); // drop
            switch (nextColor) {
                case "black" -> droppedCard.setColor(COLOR.BLACK);
                case "blue" -> droppedCard.setColor(COLOR.BLUE);
                case "red" -> droppedCard.setColor(COLOR.RED);
                case "green" -> droppedCard.setColor(COLOR.GREEN);
                default -> {
                    System.out.println("Invalid input.");
                    return advanceTurn(fieldCard);
                }
            }
        }
        return droppedCard;
    }
}
