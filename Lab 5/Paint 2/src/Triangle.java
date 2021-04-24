import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import  java.lang.Math;

/**
 * Triangle class to implement triangle shape
 * @author Adibov
 * @version 1.0
 */
public class Triangle extends Polygon {
    /**
     * simple constructor and checker to make a valid object
     * @param a a side
     * @param b a side
     * @param c a side
     */
    public Triangle(int a, int b, int c) {
        super(a, b, c);
        Collections.sort(sides);
        if (sides.get(0) + sides.get(1) <= sides.get(2))
            System.out.println("Cannot make a triangle with the given sides.");
    }

    /**
     * check if the current triangle is equilateral
     * @return boolean answer of the question
     */
    public boolean isEquilateral() {
        return sides.get(0).equals(sides.get(2));
    }

    /**
     * Override toString method
     * @return string result
     */
    @Override
    public String toString() {
        return "Triangle{" +
                super.toString() +
                "}";
    }
}