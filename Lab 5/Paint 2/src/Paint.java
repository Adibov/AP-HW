import java.util.ArrayList;

/**
 * Paint class to implement shape painting
 * @author Adibov
 * @version 1.0
 */
public class Paint {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    /**
     * simple constructor to make a new object
     */
    public Paint() {

    }

    /**
     * add the given shape to the list
     * @param shape the given shape
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * calls all shapes draw method
     */
    public void drawAll() {
        System.out.println("Shapes:");
        for (Shape shape : shapes)
            shape.draw();
        System.out.println(); // blank line
    }

    /**
     * class all shapes toString method
     */
    public void printAll() {
        System.out.println("Shapes:");
        for (Shape shape : shapes)
            System.out.println(shape.toString());
        System.out.println(); // blank line
    }

    public void describeEqualSides() {
        System.out.println("Special shapes:");
        for (Shape shape : shapes)
            if (shape instanceof Triangle && ((Triangle) shape).isEquilateral())
                System.out.println(((Triangle) shape).toString());
            else if (shape instanceof Rectangle && ((Rectangle) shape).isSquare())
                System.out.println(((Rectangle) shape).toString());
    }
}
