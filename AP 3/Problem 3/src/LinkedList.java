/**
 * LinkedList implementation Class
 * @author Adibov
 * @version 1.0
 */
public class LinkedList {
    private int size;
    final private Node head;
    private Node cur;

    /**
     * simple constructor for making a empty list
     */
    public LinkedList() {
        size = 0;
        head = new Node();
        cur = head;
    }

    /**
     * add given number to the end of the list
     * @param k new node's value
     */
    public void add(int k) {
        cur = head;
        while (cur.getNext() != null)
            cur = cur.getNext();
        Node newNode = new Node(k);
        cur.setNext(newNode);
        cur = newNode;
        size++;
    }

    /**
     * add given node to the end of the list
     * @param node new node
     */
    public void add(Node node) {
        node.setNext(null);
        cur = head;
        while (cur.getNext() != null)
            cur = cur.getNext();
        cur.setNext(node);
        cur = node;
        size++;
    }

    /**
     * add given number before the list
     * @param k new node's value
     */
    public void addFirst(int k) {
        cur = head;
        Node newNode = new Node(k, head.getNext());
        head.setNext(newNode);
        size++;
    }

    /**
     * add given node before the list
     * @param node new node
     */
    public void addFirst(Node node) {
        cur = head;
        head.setNext(node);
        size++;
    }

    /**
     * print the whole list
     */
    public void print() {
        cur = head.getNext();
        while (cur != null) {
            System.out.print(cur.getValue() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    /**
     * check if the given number exists in the list
     * @param k given number
     */
    public void contains(int k) {
        cur = head.getNext();
        int result = 0;
        while (cur != null) {
            if (cur.getValue() == k) {
                System.out.println(result);
                break;
            }
            cur = cur.getNext();
            result++;
        }
        if (cur == null)
            System.out.println(-1);
    }

    /**
     * remove the node with the given index, and return its value
     * @param index given index
     * @return removed node
     */
    public Node removeIndex(int index) {
        if (index < 1 || size < index)
            return null;

        Node result;
        cur = head;
        for (int i = 1; i < index; i++)
            cur = cur.getNext();
        result = cur.getNext();
        cur.setNext(cur.getNext().getNext());
        size--;
        return result;
    }

    /**
     * size getter
     * @return LinkedList size
     */
    public int getSize() {
        return size;
    }
}