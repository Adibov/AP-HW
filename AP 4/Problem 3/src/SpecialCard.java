public class SpecialCard extends Card {
    /**
     * simple constructor to make a new valid object
     * @param number card number
     * @param color card color
     */
    public SpecialCard(int number, COLOR color) {
        super(number, color);
        if (!this.isSpecial())
            throw new IllegalArgumentException("Invalid card number for SpecialCard.");
    }
}
