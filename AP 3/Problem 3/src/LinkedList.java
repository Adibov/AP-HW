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
     * remove the node with the given index
     * @param index given index
     */
    public void removeIndex(int index) {
        if (index >= size)
            return;

        cur = head;
        for (int i = 0; i < index; i++)
            cur = cur.getNext();
        cur.setNext(cur.getNext().getNext());
        size--;
    }
}