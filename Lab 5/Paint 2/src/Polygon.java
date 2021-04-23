import java.util.ArrayList;

public class Polygon extends Shape {
    protected ArrayList<Integer> sides;

    public Polygon() {
        sides  = new ArrayList<Integer>();
    }

    /**
     * return polygon sides
     * @return sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }
}
