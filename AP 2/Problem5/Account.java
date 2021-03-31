import java.util.UUID;
import java.util.ArrayList;

/**
 * Account class for implementing bank account
 * @author Adibov
 * @version 1.0
 */
public class Account {
    private UUID serial;
    private String id, firstName, lastName, type;
    private int balance;
    private ArrayList<Transaction> transactions;

    /**
     * simple constructor to make a object with the given fields
     * @param id
     * @param firstName
     * @param lastName
     * @param type
     * @param balance
     */
    public Account(String id, String firstName, String lastName, String type, int balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.balance = balance;
        serial = UUID.randomUUID();
        transactions = new ArrayList<Transaction>();
    }

    /**
     * update Account after each transaction
     * @param amount
     */
    public void updateBalance(int amount) {
        balance += amount;
    }

    /**
     * add the given transaction to the list of transactions
     * @param transaction
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * print account data
     */
    public void printAccountData() {
        System.out.println(serial.toString() + ", " + id + ", " + firstName + ' ' + lastName + ", " + balance);
    }
}