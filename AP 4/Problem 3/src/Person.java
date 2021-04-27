import java.util.Scanner;

public class Person extends Player {
    final private Scanner inputScanner = new Scanner(System.in);

    /**
     * simple constructor
     * @param name player name
     */
    public Person(String name) {
        super(name);
    }

    /**
     * simple constructor to get name from stdin
     */
    public Person() {
        super();
        System.out.println("Enter Player name:");
        name = inputScanner.nextLine();
    }
}
