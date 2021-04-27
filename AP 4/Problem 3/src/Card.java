import java.util.Objects;

/**
 * color enum to override colors
 */
enum COLOR {
    BLACK,
    RED,
    BLUE,
    GREEN
}

/**
 * Card class to implements Cards common behaviours
 */
public class Card {
    /**
     * we consider A, B, C, D as 11, 12, 13, 14 in card number
     */
    protected int number;
    protected COLOR color;

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

    /**
     * number getter
     * @return card number
     */
    public int getNumber() {
        return number;
    }

    /**
     * color getter
     * @return card color
     */
    public COLOR getColor() {
        return color;
    }

    /**
     * override equals method
     * @param o given object
     * @return boolean result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return number == card.number && color == card.color;
    }

    /**
     * override hashCode method
     * @return boolean result
     */
    @Override
    public int hashCode() {
        return Objects.hash(number, color);
    }
}
