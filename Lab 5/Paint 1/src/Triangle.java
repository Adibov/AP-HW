import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import  java.lang.Math;

/**
 * Triangle class to implement triangle shape
 * @author Adibov
 * @version 1.0
 */
public class Triangle {
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

    /**
     * calculate the perimeter of the triangle
     * @return triangle's perimeter
     */
    public double calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    /**
     * calculate the area of the triangle
     * @return triangle's area
     */
    public double calculateArea() {
        double a = sides.get(0), b = sides.get(1), c = sides.get(2);
        double p = (double)(a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * draw the rectangle
     */
    public void draw() {
        System.out.println("Draw a triangle with these sides: " + sides.get(0) + "," + sides.get(1) + "," + sides.get(2));
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
        Triangle triangle = (Triangle) o;
        return sides.equals(triangle.sides);
    }

    /**
     * Override toString method
     * @return String of the sides
     */
    @Override
    public String toString() {
        return "Triangle{" +
                "sides=" + sides +
                '}';
    }
}