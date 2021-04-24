import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Rectangle class to implement rectangle shape
 * @author Adibov
 * @version 1.0
 */
public class Rectangle extends Polygon {
    /**
     * simple constructor and checker to make a valid object
     * @param x1 a side
     * @param x2 a side
     * @param y1 a side
     * @param y2 a side
     */
    public Rectangle(int x1, int x2, int y1, int y2) {
        super(x1, x2, y1, y2);
        Collections.sort(sides);
        if (!(sides.get(0).equals(sides.get(1)) && sides.get(2).equals(sides.get(3))))
            System.out.println("There must be 4 sides, pairwise equal.");
    }

    /**
     * check if the current rectangle is a square
     * @return boolean answer of the question
     */
    public boolean isSquare() {
        return sides.get(0).equals(sides.get(3));
    }

    /**
     * Override toString method
     * @return string result
     */
    @Override
    public String toString() {
        return "Rectangle{" +
                super.toString() +
                "}";
    }
}