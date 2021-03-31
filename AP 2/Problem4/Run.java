import java.util.Scanner;

/**
 * Run class, for make some instances and run project
 */
public class Run {
    static Scanner inputScanner = new Scanner(System.in);
    static LinkedList lk = new LinkedList();

    /**
     * add a number to list
     */
    public static void add() {
        int k = inputScanner.nextInt();
        lk.add(k);
    }

    /**
     * add a number before the list
     */
    public static void addFirst() {
        int k = inputScanner.nextInt();
        lk.addFirst(k);
    }

    /**
     * print middle number
     */
    public static void findMiddle() {
        lk.findMiddle();
    }

    /**
     * remove middle number
     */
    public static void removeMiddle() {
        lk.removeMiddle();
    }

    /**
     * print the whole list
     */
    public static void print() {
        lk.print();
    }

    /**
     * check if the give number exists in the list
     */
    public static void contains() {
        int k = inputScanner.nextInt();
        lk.contains(k);
    }

    /**
     * remove the number in the given index
     */
    public static void removeIndex() {
        int index = inputScanner.nextInt();
        lk.removeIndex(index);
    }

    /**
     * main method, make a LinkedList and add some integers to it just for lking
     * @param args
     */
    public static void main(String[] args) {
        String input;
        while (true) {
            input = inputScanner.next();
            if (input.equals("finish"))
                break;
            else if (input.equals("add"))
                add();
            else if (input.equals("addFirst"))
                addFirst();
            else if (input.equals("findMiddle"))
                findMiddle();
            else if (input.equals("removeMiddle"))
                removeMiddle();
            else if (input.equals("print"))
                print();
            else if (input.equals("contains"))
                contains();
            else if (input.equals("removeIndex"))
                removeIndex();
            else
                System.out.println("Invalid input!");
        }
    }
}