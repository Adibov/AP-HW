import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Circle {
    private int radius;

    /**
     * simple constructor and checker to make a valid object
     * @param radius circle's radius
     */
    public Circle(int radius) {
        if (radius <= 0) {
            System.out.println("Radius should pe positive.");
            return;
        }
        this.radius = radius;
    }

    /**
     * radius getter
     * @return circle's radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * calculate the perimeter of the circle
     * @return circle's perimeter
     */
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * calculate the area of the circle
     * @return circle's area
     */
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * draw the circle
     */
    public void draw() {
        System.out.println("Draw a circle with radius " + radius);
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
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    /**
     * Override toString method
     * @return String of the sides
     */
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
