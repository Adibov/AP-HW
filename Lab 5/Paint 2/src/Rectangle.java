import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Rectangle class to implement rectangle shape
 * @author Adibov
 * @version 1.0
 */
public class Rectangle extends Polygon {
    private ArrayList<Integer> sides;

    /**
     * simple constructor and checker to make a valid object
     * @param x1 a side
     * @param x2 a side
     * @param y1 a side
     * @param y2 a side
     */
    public Rectangle(int x1, int x2, int y1, int y2) {
        ArrayList<Integer> sides = new ArrayList<>();
        sides.add(x1); sides.add(x2); sides.add(y1); sides.add(y2);
        Collections.sort(sides);
        if (sides.size() != 4) {
            System.out.println("There must be 4 sides.");
            return;
        }
        if (!(sides.get(0).equals(sides.get(1)) && sides.get(2).equals(sides.get(3)))) {
            System.out.println("There must be 4 sides, pairwise equal.");
            return;
        }
        this.sides = sides;
    }

    /**
     * sides getter
     * @return list of sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * check if the current rectangle is a square
     * @return boolean answer of the question
     */
    public boolean isSquare() {
        return sides.get(0).equals(sides.get(3));
    }
}