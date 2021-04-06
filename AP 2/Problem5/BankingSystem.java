import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.UUID;

/**
 * Banking System class to implement a simple banking simulator
 * @author Adibov
 * @version 1.0
 */
public class BankingSystem {
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    /**
     * simple constructor
     */
    public BankingSystem() {
        users = new ArrayList<User>();
        accounts = new ArrayList<Account>();
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
     * @return returns the logged in user
     */
    public User login(String id, String password) {
        User user = null;
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User currentUser = it.next();
            if (currentUser.getId().equals(id))
                user = currentUser;
        }
        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("user doesn't exists or password is incorrect.");
            return null;
        }
        System.out.println("Logged in.");
        return user;
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
    public void removeUser(User user) {
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
            user.printUserData();
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
    public void removeAccount(Account account) {
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

    /**
     * find account by serial
     * @param serial
     * @return desired account object
     */
    public Account findAccount(String serial) {
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()) {
            Account account = it.next();
            if (account.getSerial().toString().equals(serial))
                return account;
        }
        return null;
    }

    /**
     * get number of accounts
     * @return account counts
     */
    public int getAccountCount() {
        return accounts.size();
    }

    /**
     * return the account with the given index
     * @param index
     * @return account with index No.
     */
    public Account getAccount(int index) {
        index--;
        if (index < 1 || index >= accounts.size())
            return null;
        return accounts.get(index);
    }

    /**
     * find user by the given account
     * @param account the given account
     * @return result user
     */
    public User findUserByAccount(Account account) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if (user.accountExistance(account))
                return user;
        }
        return null;
    }

    /**
     * find user by the given od
     * @param id id of the target user
     * @return user object
     */
    public User findUserById(String id) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if (user.getId().equals(id))
                return user;
        }
        return null;
    }
}