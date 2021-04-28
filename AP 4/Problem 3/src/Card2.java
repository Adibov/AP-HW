import java.util.Random;

public class Card2 extends SpecialCard {
    /**
     * simple constructor to make a new valid object
     * @param color card color
     */
    public Card2(COLOR color) {
        super(2, color);
    }

    /**
     * apply card to the game
     *
     * @param game the given game
     */
    @Override
    public void applyCard(Game game) {
        int index;
        super.applyCard(game);
        Player currentPlayer = game.getPlayers().get(game.getCurrentPlayer());
        if (currentPlayer.getCardsNumber() == 0) {
            return; // already won
        }
        if (currentPlayer instanceof Computer) {
            Random randomGen = new Random();
            index = randomGen.nextInt(game.getPlayerCount() - 1);
        }
        else {
            game.showPlayers(game.getCurrentPlayer() + 1);
            System.out.println("Enter index of the player to penalize:");
            index = inputScanner.nextInt(); inputScanner.nextLine(); // drop
            if (index < 1 || index >= game.getPlayerCount()) {
                System.out.println("Invalid input.");
                applyCard(game);
                return;
            }
        }
        if (index >= game.getCurrentPlayer())
            index++;
        Card penaltyCard = currentPlayer.randomCard();
        currentPlayer.removeCard(penaltyCard);
        game.getPlayers().get(index - 1).addCard(penaltyCard);
    }
}
