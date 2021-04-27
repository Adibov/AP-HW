/**
 * Card class to implements Cards common behaviours
 */
public class Card {
    /**
     * we consider A, B, C, D as 11, 12, 13, 14 in card number
     */
    int number;
    COLOR color;

    enum COLOR {
        BLACK,
        RED,
        BLUE,
        GREEN
    }

    /**
     * constructor to make a new valid object
     * @param number card number
     * @param color card color
     */
    public Card(int number, COLOR color) {
        if (number < 2 || number > 14)
            throw new IllegalArgumentException("Invalid card number.");
        if (color != COLOR.BLACK && color != COLOR.BLUE && color != COLOR.GREEN && color != COLOR.RED)
            throw new IllegalArgumentException("Invalid card color.");
        this.number = number;
        this.color = color;
    }

    /**
     * calculate card point
     * @return card point
     */
    public int getPoint() {
        if (number == 7) {
            if (color == COLOR.BLACK)
                return 15;
            else
                return 10;
        }
        return number;
    }

    /**
     * check if the card is special
     * @return boolean result
     */
    public boolean isSpecial() {
        return number != 3 && number != 4 && number != 5 && number != 6 && number != 9 && number != 13 && number != 14;
    }
}
