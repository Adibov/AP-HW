/**
 * LinkedList implementation Class
 * @author Adibov
 * @version 1.0
 */
public class LinkedList {
    private int size;
    private Node head, cur;

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
     * @param k
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
     * @param k
     */
    public void addFirst(int k) {
        cur = head;
        Node newNode = new Node(k, head.getNext());
        head.setNext(newNode);
        size++;
    }

    /**
     * print the middle number in the list
     */
    public void findMiddle() {
        if (size == 0) {
            System.out.println(-1);
            return;
        }

        cur = head;
        for (int i = 0; i < (size + 1) / 2; i++)
            cur = cur.getNext();
        System.out.println(cur.getValue());
    }

    /**
     * remove middle number in the list
     */
    public void removeMiddle() {
        if (size == 0)
            return;
        if (size == 1) {
            head.setNext(null);
            return;
        }

        cur = head;
        for (int i = 0; i < (size + 1) / 2 - 1; i++)
            cur = cur.getNext();
        cur.setNext(cur.getNext().getNext());
        cur.getNext().setNext(null);
        size--;
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
     * @param k
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
     * remove the number in the given index
     * @param index
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

    /**
     * main method, make an object and add some integers to it just for testing
     * @param args
     */
    public static void main(String[] args) {

    }
}