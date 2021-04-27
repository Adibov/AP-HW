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
        Player currentPlayer = game.getPlayers().get(game.getCurrentPlayer());
        game.showPlayers(game.getCurrentPlayer() + 1);
        System.out.println("Enter index of the player to penalize:");
        int index = inputScanner.nextInt(); inputScanner.nextLine();
        if (index < 1 || index >= game.getPlayerCount()) {
            System.out.println("Invalid input.");
            applyCard(game);
            return;
        }
        if (index >= game.getCurrentPlayer())
            index++;
        Card penaltyCard = currentPlayer.randomCard();
        currentPlayer.removeCard(penaltyCard);
        game.getPlayers().get(index - 1).addCard(penaltyCard);
        super.applyCard(game);
    }
}
