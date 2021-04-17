import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Rectangle class to implement rectangle shape
 * @author Adibov
 * @version 1.0
 */
public class Rectangle {
    private ArrayList<Integer> sides;

    /**
     * simple constructor and checker to make a valid object
     * @param sides rectangle's sides
     */
    public Rectangle(ArrayList<Integer> sides) {
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

    /**
     * calculate the perimeter of the rectangle
     * @return rectangle's perimeter
     */
    public int calculatePerimeter() {
        return 2 * (sides.get(0) + sides.get(1));
    }

    /**
     * calculate the area of the rectangle
     * @return rectangle's area
     */
    public int calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    /**
     * draw the rectangle
     */
    public void draw() {
        System.out.println("Draw a rectangle with these sides: " + sides.get(0) + " and " + sides.get(1));
    }

    /**
     * Override equals method
     * @param o the given Object
     * @return boolean compare result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        if (Objects.equals(sides, rectangle.sides))
            return true;
        return sides.get(0).equals(rectangle.getSides().get(0)) && sides.get(2).equals(rectangle.getSides().get(2));
    }

    /**
     * Override toString method
     * @return String of the sides
     */
    @Override
    public String toString() {
        return "Rectangle{" +
                "sides=" + sides +
                '}';
    }
}