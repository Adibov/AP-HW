import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Circle extends Shape {
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
     * Override toString method
     * @return string result
     */
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "}";
    }
}
