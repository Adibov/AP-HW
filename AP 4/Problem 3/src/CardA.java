public class CardA extends SpecialCard {
    /**
     * simple constructor to make a new valid object
     * @param color card color
     */
    public CardA(COLOR color) {
        super(11, color);
    }

    /**
     * apply card to the game
     * @param game the given game
     */
    @Override
    public void applyCard(Game game) {
        game.incrementTurn(1);
        super.applyCard(game);
    }
}
