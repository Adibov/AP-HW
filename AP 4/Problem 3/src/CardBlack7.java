public class CardBlack7 extends SpecialCard {
    /**
     * simple constructor to make a new valid object
     */
    public CardBlack7() {
        super(7, COLOR.BLACK);
    }

    /**
     * apply card to the game
     * @param game the given game
     */
    @Override
    public void applyCard(Game game) {
        super.applyCard(game);
        game.setToPenalize(game.getToPenalize() + 4);
    }
}
