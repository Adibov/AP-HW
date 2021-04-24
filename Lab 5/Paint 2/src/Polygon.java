import java.util.ArrayList;

public class Polygon extends Shape {
    protected ArrayList<Integer> sides = new ArrayList<Integer>();

    public Polygon(int... sides) {
        for (int side : sides)
            this.sides.add(side);
    }

    /**
     * return polygon sides
     * @return sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * Override toString method
     * @return string result
     */
    @Override
    public String toString() {
        return "sides=" + sides;
    }
}
