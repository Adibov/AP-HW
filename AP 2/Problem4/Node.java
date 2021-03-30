/**
 * Node Class for LinkedList
 * @author Adibov
 * @version 1.0
 */
public class Node {
    private int value;
    private Node next;

    /**
     * Simple constructor for making a node with the default values
     */
    public Node() {
        this.value = 0;
        this.next = null;
    }

    /**
     * Simple constructor for making a node with the given value
     * @param value
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Simple constructor for making a node with the given value and next
     * @param value
     * @param next
     */
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    /**
     * value getter
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * value setter
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * next getter
     * @return next
     */
    public Node getNext() {
        return next;
    }

    /**
     * next setter
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
}