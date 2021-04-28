public class Card8 extends SpecialCard {
    /**
     * simple constructor to make a new valid object
     * @param color card color
     */
    public Card8(COLOR color) {
        super(8, color);
    }

    /**
     * apply card to the game
     * @param game the given game
     */
    @Override
    public void applyCard(Game game) {
        super.applyCard(game);
        game.clearScreen();
        game.showSituation();
        game.getCh();
        game.clearScreen();
        game.advanceTurn();
    }
}
