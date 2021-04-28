import java.util.Objects;
import java.util.Scanner;

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
    final protected Scanner inputScanner = new Scanner(System.in);

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
     * apply card to the game
     * @param game the given game
     */
    public void applyCard(Game game) {
        Player player = game.getPlayers().get(game.getCurrentPlayer());
        game.addCard(game.getFieldCard());
        game.setFieldCard(new FieldCard(number, color, number == 7));
        player.removeCard(this);
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
     * color setter
     * @param color new color
     */
    public void setColor(COLOR color) {
        this.color = color;
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
     * get card character
     * @return card character
     */
    public String getCharacter() {
        if (number <= 10)
            return Integer.toString(number);
        return switch (number) {
            case 11 -> "A";
            case 12 -> "B";
            case 13 -> "C";
            default -> "D";
        };
    }

    /**
     * show card with color
     * @param indent the indent of the card to be printed
     */
    public void showCard(int indent) {
        final String cardColor;
        if (color == COLOR.BLACK)
            cardColor = ConsoleColors.BLACK_BOLD_BRIGHT;
        else if (color == COLOR.BLUE)
            cardColor = ConsoleColors.BLUE_BOLD_BRIGHT;
        else if (color == COLOR.GREEN)
            cardColor = ConsoleColors.GREEN_BOLD_BRIGHT;
        else
            cardColor = ConsoleColors.RED_BOLD_BRIGHT;

        for (int i = 0; i < 10; i++)
            System.out.print(cardColor + "―");
        if (number == 10)
            System.out.print("―");
        System.out.println();
        for (int i = 0; i < indent; i++)
            System.out.print(" ");
        System.out.print("┃ " + getCharacter());
        for (int i = 0; i < 6; i++)
            System.out.print(" ");
        System.out.println("┃");

        for (int row = 0; row < 2; row++) {
            for (int i = 0; i < indent; i++)
                System.out.print(" ");
            System.out.print("┃");
            for (int j = 0; j < 8; j++)
                System.out.print(" ");
            if (number == 10)
                System.out.print(" ");
            System.out.println("┃");
        }

        for (int i = 0; i < indent; i++)
            System.out.print(" ");
        System.out.print("┃");
        for (int i = 0; i < 6; i++)
                System.out.print(" ");
        System.out.print(getCharacter());
        System.out.println(" ┃");
        for (int i = 0; i < indent; i++)
            System.out.print(" ");
        for (int i = 0; i < 10; i++)
            System.out.print(cardColor + "―" + ConsoleColors.RESET);
        if (number == 10)
            System.out.print(cardColor + "―" + ConsoleColors.RESET);
        System.out.println();
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

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", color=" + color +
                '}';
    }
}
