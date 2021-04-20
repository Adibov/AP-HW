/**
 * Stack class to implement stack behaviours
 * @author Adibov
 * @version 1.0
 */
public class Stack {
    private Node[] values;
    private int size;
    final private int limit = 100;

    /**
     * simple constructor to make a new object
     */
    public Stack() {
        values = new Node[limit];
        size = 0;
    }

    /**
     * push the given number to the stack
     * @param x the given value
     */
    public void push(int x) {
        if (size == limit) {
            System.out.println("Stack Overflow");
            return;
        }
        values[size++] = new Node(x);
    }

    /**
     * push the given node to the stack
     * @param node the given node
     */
    public void push(Node node) {
        if (size == limit) {
            System.out.println("Stack Overflow");
            return;
        }
        values[size++] = node;
    }

    /**
     * pop the top element and return it
     * @return top element
     */
    public Node pop() {
        if (size == 0) {
            System.out.println("Stack Underflow.");
            return null;
        }
        return values[--size];
    }

    /**
     * return the top element
     * @return top element
     */
    public Node peak() {
        if (size == 0) {
            System.out.println("Stack Underflow.");
            return null;
        }
        return values[size - 1];
    }

    /**
     * check if the stack is empty or not
     * @return boolean result
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * check if the stack is full or not
     * @return boolean result
     */
    public boolean isFull() {
        return size == limit;
    }
}
