import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.UUID;

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

    /**
     * register an account in the banking system
     */
    public void register(User user) {
        if (users.contains(user)) {
            System.out.println("user already exists.");
            return;
        }
        users.add(user);
        System.out.println("user created.");
    }

    /**
     * login user with the given id
     */
    public void login(String id, String password) {
        User user;
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User currentUser = it.next();
            if (currentUser.getId().equals(id))
                user = currentUser;
        }
        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("user doesn't exists or password is incorrect.");
            return;
        }
        System.out.println("Logged in.");
    }

    /**
     * add the given user to the banking system
     */
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfuly.");
    }

    /**
     * remove the given user from the banking system
     */
    public removeUser(User user) {
        if (!users.contains(user)) {
            System.out.println("No such user found.");
            return;
        }
        users.remove(user);
        System.out.println("User removed successfuly.");
    }

    /**
     * display users to the stdout
     */
    public void displayUsers() {
        Iterator<User> it = users.iterator();
        int num = 1;
        while (it.hasNext()) {
            User user = it.next();
            System.out.print("User " + num + ": ");
            user.printAccountData();
            num++;
        }
    }

    /**
     * add the given account to the banking system
     */
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfuly.");
    }

    /**
     * remove the given account from the banking system
     */
    public removeAccount(Account account) {
        if (!accounts.contains(account)) {
            System.out.println("No such account found.");
            return;
        }
        accounts.remove(account);
        System.out.println("Account removed successfuly.");
    }

    /**
     * display accounts to the stdout
     */
    public void displayAccounts() {
        Iterator<Account> it = accounts.iterator();
        int num = 1;
        while (it.hasNext()) {
            Account account = it.next();
            System.out.print("Account " + num + ": ");
            account.printAccountData();
            num++;
        }
    }

    public Account findAccount(String serial) {
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()) {
            Account account = it.next();
            if (account.getSerial().toString().equals(serial))
                return account;
        }
        return null;
    }
}