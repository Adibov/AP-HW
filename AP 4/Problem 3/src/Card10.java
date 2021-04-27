public class Card10 extends SpecialCard {
    /**
     * simple constructor to make a new valid object
     * @param color card color
     */
    public Card10(COLOR color) {
        super(10, color);
    }

    /**
     * apply card to the game
     * @param game the given game
     */
    @Override
    public void applyCard(Game game) {
        game.setDirection(-game.getDirection());
        super.applyCard(game);
    }
}
