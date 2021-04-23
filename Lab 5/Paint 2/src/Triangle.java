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
    private ArrayList<Integer> sides;

    /**
     * simple constructor and checker to make a valid object
     * @param a a side
     * @param b a side
     * @param c a side
     */
    public Triangle(int a, int b, int c) {
        ArrayList<Integer> sides = new ArrayList<>();
        sides.add(a); sides.add(b); sides.add(c);
        Collections.sort(sides);
        if (sides.size() != 3) {
            System.out.println("There must be 3 sides.");
            return;
        }
        if (sides.get(0) + sides.get(1) <= sides.get(2)) {
            System.out.println("Cannot make a trianlge with the given sides.");
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
     * check if the current triangle is equilateral
     * @return boolean answer of the question
     */
    public boolean isEquilateral() {
        return sides.get(0).equals(sides.get(2));
    }
}