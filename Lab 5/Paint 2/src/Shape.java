import java.util.ArrayList;
import java.lang.Math;

public class Shape {
    /**
     * calculate the perimeter of the shape
     * @return shape's perimeter
     */
    public double calculatePerimeter() {
        if (this instanceof Circle)
            return 2 * Math.PI * ((Circle) this).getRadius();
        else if (this instanceof Polygon) {
            ArrayList<Integer> sides;
            if (this instanceof Rectangle) {
                sides = ((Rectangle) this).getSides();
                return 2 * (sides.get(0) + sides.get(1));
            }
            else if (this instanceof Triangle) {
                sides = ((Triangle) this).getSides();
                return sides.get(0) + sides.get(1) + sides.get(2);
            }
            else
                return 0;
        }
        else
            return 0;
    }

    /**
     * calculate the area of the shape
     * @return shape's area
     */
    public double calculateArea() {
        if (this instanceof Circle)
            return Math.PI * ((Circle) this).getRadius() * ((Circle) this).getRadius();
        else if (this instanceof Polygon) {
            ArrayList<Integer> sides;
            if (this instanceof Rectangle) {
                sides = ((Rectangle) this).getSides();
                return sides.get(0) * sides.get(1);
            }
            else if (this instanceof Triangle) {
                sides = ((Triangle) this).getSides();
                double a = sides.get(0), b = sides.get(1), c = sides.get(2);
                double p = (double)(a + b + c) / 2.0;
                return Math.sqrt(p * (p - a) * (p - b) * (p - c));
            }
            else
                return 0;
        }
        else
            return 0;
    }

    /**
     * draw the shape
     */
    public void draw() {
        if (this instanceof Circle)
            System.out.println("Draw a circle with radius " + ((Circle) this).getRadius());
        else if (this instanceof Polygon) {
            ArrayList<Integer> sides;
            if (this instanceof Rectangle) {
                sides = ((Rectangle) this).getSides();
                System.out.println("Draw a rectangle with these sides: " + sides.get(0) + "," + sides.get(2));
            }
            else if (this instanceof Triangle) {
                sides = ((Triangle) this).getSides();
                System.out.println("Draw a triangle with these sides: " + sides.get(0) + "," + sides.get(1) + "," + sides.get(2));
            }
        }
    }

    /**
     * check if this object is equals to the given object
     * @param obj the given object
     * @return boolean result
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (this instanceof Circle)
            return ((Circle) this).getRadius() == ((Circle) obj).getRadius();
        else if (this instanceof Polygon) {
            ArrayList<Integer> sides;
            if (this instanceof Rectangle) {
                sides = ((Rectangle) this).getSides();
                return ((Rectangle) this).getSides().get(0).equals(sides.get(0)) && ((Rectangle) this).getSides().get(2).equals(sides.get(2));
            }
            else if (this instanceof Triangle) {
                sides = ((Triangle) this).getSides();
                return ((Triangle) this).getSides().get(0).equals(sides.get(0)) && ((Triangle) this).getSides().get(1).equals(sides.get(1)) && ((Triangle) this).getSides().get(2).equals(sides.get(2));
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * return details in string format
     * @return string result
     */
    @Override
    public String toString() {
        if (this instanceof Circle)
            return "Circle{" +
                    "radius=" + ((Circle) this).getRadius() +
                    '}';
        else if (this instanceof Polygon) {
            ArrayList<Integer> sides;
            if (this instanceof Rectangle) {
                sides = ((Rectangle) this).getSides();
                return "Rectangle{" +
                        "sides=" + sides +
                        '}';
            }
            else if (this instanceof Triangle) {
                sides = ((Triangle) this).getSides();
                return "Triangle{" +
                        "sides=" + sides +
                        '}';
            }
        }
        return "Shape{}";
    }
}
