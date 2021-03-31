import java.util.Date;

/**
 * Transaction class to implement transactions
 * @author Adibov
 * @version 1.0
 */
public class Transaction {
    private int amount;
    private Date date;

    /**
     * constructor with the given amount value
     * @param amount
     */
    public Transaction(int amount) {
        this.amount = amount;
        date = new Date();
    }

    /**
     * print transaction details
     */
    public void print() {
        System.out.println("A transaction with amount of " + amount + " at " + date.toString());
    }
}