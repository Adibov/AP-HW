public class CardNonBlack7 extends Card7 {
    /**
     * simple constructor to make a new valid object
     * @param color card color
     */
    public CardNonBlack7(COLOR color) {
        super(color);
        if (color == COLOR.BLACK)
            throw new IllegalArgumentException("Invalid color for a NonBlack card.");
    }
}
