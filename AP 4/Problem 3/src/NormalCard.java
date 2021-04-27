public class NormalCard extends Card {
    public NormalCard(int number, COLOR color) {
        super(number, color, false);
        if (number != 3 && number != 4 && number != 5 && number != 6 && number != 9 && number != 13 && number != 14)
            throw new IllegalArgumentException("Invalid card number for a NormalCard.");
    }
}
