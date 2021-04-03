import java.util.ArrayList;
import java.util.Scanner;

/**
 * Banking System class to implement a simple banking simulator
 */
public class BankingSystem {
    private ArrayList<User> users;
    private ArrayList<Account> accounts;
    private Scanner inputScanner;

    /**
     * simple constructor
     */
    public BankingSystem() {
        users = new ArrayList<User>();
        accounts = new ArrayList<Account>();
        inputScanner = new Scanner(System.in);
    }

    public void register(User user) {

    }
}