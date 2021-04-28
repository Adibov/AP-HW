public class CardNonBlack7 extends SpecialCard {
    /**
     * simple constructor to make a new valid object
     * @param color card color
     */
    public CardNonBlack7(COLOR color) {
        super(7, color);
        if (color == COLOR.BLACK)
            throw new IllegalArgumentException("Invalid color for a NonBlack card.");
    }

    /**
     * apply card to the game
     * @param game the given game
     */
    @Override
    public void applyCard(Game game) {
        super.applyCard(game);
        game.setToPenalize(game.getToPenalize() + 2);
    }
}
