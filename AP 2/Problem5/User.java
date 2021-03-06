import java.util.ArrayList;

/**
 * User class to implement users
 * @author Adibov
 * @version 1.0
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
        if (amount < 0) {
            System.out.println("Cannot deposit a negative amount!");
            return;
        }
        if (!account.updateBalance(amount))
            return;
        account.updateBalance(amount);
        account.addTransaction(new Transaction(amount));
    }

    /**
     * withdraw the given amount from the account
     * @param account
     * @param amount
     */
    public void withdrawal(Account account, int amount) {
        if (amount < 0) {
            System.out.println("Cannot withdrawal a negative amount!");
            return;
        }
        if (!accountList.contains(account)) {
            System.out.println("No such account found for this user!");
            return;
        }
        if (!account.updateBalance(-amount))
            return;
        account.addTransaction(new Transaction(-amount));
    }

    /**
     * transfer the given money from one acoount to the another one
     * @param srcAccount
     * @param destAccount
     * @param amount
     */
    public void transfer(Account srcAccount, Account destAccount, int amount) {
        if (!accountList.contains(srcAccount)) {
            System.out.println("No such account found for this user!");
            return;
        }
        if (!srcAccount.updateBalance(-amount))
            return;
        destAccount.updateBalance(amount);
        srcAccount.addTransaction(new Transaction(-amount));
        destAccount.addTransaction(new Transaction(amount));
    }

    /**
     * print account's balance
     * @param account
     */
    public void checkBalance(Account account) {
        System.out.println(account.getBalance());
    }

    /**
     * prints all account with their information
     */
    public void printAllAvailableAccounts() {
        System.out.println("All available accounts: ");
        for (Account i : accountList)
            i.printAccountData();
    }

    /**
     * print user data, such as firstName lastName & id
     */
    public void printUserData() {
        System.out.println(firstName + ", " + lastName + ", " + id);
    }

    /**
     * firstName getter
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * lastName getter
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * id getter
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * password getter
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * overrdie equals method
     * @param externalUser
     * @return
     */
    @Override
    public boolean equals(Object externalUser) {
        if (externalUser == this)
            return true;
        if (!(externalUser instanceof User))
            return false;

        User external = (User) externalUser;
        return (this.id.equals(external.getId()));
    }

    /**
     * check if the given account is for this user
     * @param account the given account
     * @return true if the given account is for this user
     */
    public boolean accountExistance(Account account) {
        return accountList.contains(account);
    }
}