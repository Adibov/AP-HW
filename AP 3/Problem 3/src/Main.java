import java.util.Scanner;

/**
 * Main class to run the whole project
 * @author Adibov
 * @version 1.0
 */
public class Main {
    final static private Stack stack = new Stack();
    final static private LinkedList linkedList = new LinkedList();
    final static private Scanner inputScanner = new Scanner(System.in);

    /**
     * main method to make class runnable
     * @param args system args
     */
    public static void main(String[] args) {
        String[] input = inputScanner.nextLine().split(" ");
        for (String i : input) {
            int x = Integer.parseInt(i);
            linkedList.add(x);
        }
        reverse();
        linkedList.print();
    }

    /**
     * reverse linkList with stack
     */
    public static void reverse() {
        while (linkedList.getSize() > 0) {
            Node firstNode = linkedList.removeIndex(1);
            stack.push(firstNode);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            linkedList.add(node);
        }
    }
}
