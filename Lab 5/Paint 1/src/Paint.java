import java.util.ArrayList;

/**
 * Paint class to implement shape painting
 * @author Adibov
 * @version 1.0
 */
public class Paint {
    private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    /**
     * simple constructor to make a new object
     */
    public Paint() {

    }

    /**
     * add the given triangle to the list
     * @param triangle the given triangle
     */
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * add the given cricle to the list
     * @param circle the given circle
     */
    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    /**
     * add the given rectangle to the list
     * @param rectangle the given rectangle
     */
    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * calls all shapes draw method
     */
    public void drawAll() {
        System.out.println("Triangles:");
        for (Triangle t : triangles)
            t.draw();
        System.out.println(); // blank line
        System.out.println("Circles:");
        for (Circle c : circles)
            c.draw();
        System.out.println(); // blank line
        System.out.println("Rectangles:");
        for (Rectangle r : rectangles)
            r.draw();
        System.out.println(); // blank line
    }

    /**
     * class all shapes toString method
     */
    public void printAll() {
        System.out.println("Triangles:");
        for (Triangle t : triangles)
            System.out.println(t.toString());
        System.out.println(); // blank line
        System.out.println("Circles:");
        for (Circle c : circles)
            System.out.println(c.toString());
        System.out.println(); // blank line
        System.out.println("Rectangles:");
        for (Rectangle r : rectangles)
            System.out.println(r.toString());
        System.out.println(); // blank line
    }
}
