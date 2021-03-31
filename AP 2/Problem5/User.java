import java.util.ArrayList;

/**
 * User class to implement users
 * @author Adibov
 * @version 1.0-=
 */
public class User {
    private String firstName, lastName, id, password;
    private ArrayList<Account> accountList;

    /**
     * constructor for making a new user
     * @param firstName
     * @param lastName
     * @param id
     * @param password
     */
    public User(String firstName, String lastName, String id, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
        accountList = new ArrayList<Account>();
    }

    /**
     * add the given account to the list of accounts
     * @param account
     */
    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * remove the given account from the accounts list
     * @param account
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    /**
     * deposit the given amount to the account
     * @param account
     * @param amount
     */
    public void deposit(Account account, int amount) {
        account.updateBalance(amount);
    }

    /**
     * withdraw the given amount from the account
     * @param account
     * @param amount
     */
    public void withdrawal(Account account, int amount) {
        if (account.getBalence() < amount) {
            System.out.println("Not enough money");
            return;
        }
        account.updateBalence(-amount);
    }
}