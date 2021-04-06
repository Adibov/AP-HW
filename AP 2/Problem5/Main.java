import java.util.Scanner;

/**
 * Main class to implement main menu and options
 * @author Adibov
 * @version 1.0
 */
public class Main {
    Scanner inputScanner = new Scanner(System.in);
    BankingSystem bank = new BankingSystem();

    public void mainMenu() {
        System.out.println("Please choose one option:");
        System.out.println("1.Sign up");
        System.out.println("2.Log in");
        System.out.println("3.System Admin");
        System.out.println("4.Exit");
        int option = inputScanner.nextInt();

        if (option < 1 || option > 4) {
            System.out.println("Invalid input");
            mainMenu();
            return;
        }
        if (option == 1)
            signUp();
        else if (option == 2)
            logIn();
        else if (option == 3)
            systemAdmin();
        else {
            exit();
            return;
        }
        mainMenu();
    }

    /**
     * sign up a new user
     */
    public void signUp() {
        String firstName, lastName, id, password;
        System.out.print("Enter Firstname: ");
        firstName = inputScanner.nextLine();
        System.out.print("Enter LastName: ");
        lastName = inputScanner.nextLine();
        System.out.print("Enter ID: ");
        id = inputScanner.nextLine();
        System.out.print("Enter Password: ");
        password = inputScanner.nextLine();
        User newUser = new User(firstName, lastName, id, password);
        bank.register(newUser);
    }

    /**
     * log in to an existing account
     */
    public void logIn() {
        System.out.println();
        String id, password;
        System.out.print("Enter ID: ");
        id = inputScanner.nextLine();
        System.out.print("Enter Password: ");
        password = inputScanner.nextLine();
        User user = bank.login(id, password);
        if (user == null) {
            logIn();
            return;
        }
        logInMenu(user);
    }

    /**
     * show log in menu
     * @param user logged in user
     */
    public void logInMenu(User user) {
        System.out.println();
        System.out.println("Choose and option: ");
        System.out.println("1.Existing accounts");
        System.out.println("2.Add new account");
        System.out.println("3.Log out");
        int option = inputScanner.nextInt();
        if (option < 1 || option > 3) {
            System.out.println("Invalid input");
            logInMenu(user);
            return;
        }

        if (option == 1)
            existingAccounts(user);
        else if (option == 2)
            addNewAccount(user);
        else {
            logOut();
            return;
        }
        logInMenu(user);
    }

    /**
     * existing accounts options
     */
    public void existingAccounts(User user) {
        System.out.println();
        if (bank.getAccountCount() == 0) {
            System.out.println("No account exist");
            return;
        }

        System.out.println("Choose from list of accounts:");
        bank.displayAccounts();
        int option = inputScanner.nextInt();
        if (option < 1 || option > bank.getAccountCount()) {
            System.out.println("Invalid input");
            existingAccounts(user);
            return;
        }

        Account account = bank.getAccount(option);
        System.out.println();
        System.out.println("Choose an operation:");
        System.out.println("1.WithDrawal");
        System.out.println("2.Deposit");
        System.out.println("3.Transfer");
        System.out.println("4.Check balance");
        System.out.println("5.Back");

        option = inputScanner.nextInt();
        if (option < 1 || option > 5) {
            System.out.println("Invalid input");
            existingAccounts(user);
            return;
        }

        if (option == 1)
            withDrawal(account);
        else if (option == 2)
            deposit(account);
        else if (option == 3)
            transfer(account);
        else if (option == 4)
            checkBalance(account);
        else {
            logInMenu(user);
            return;
        }
        existingAccounts(user);
    }

    /**
     * withdrawal some amount of money to the account
     * @param account the source account
     */
    public void withDrawal(Account account) {
        System.out.println();
        System.out.println("Enter an amount to withdrawal:");
        int amount = inputScanner.nextInt();
        if (amount <= 0) {
            System.out.println("Invalid input");
            withDrawal(account);
            return;
        }

        User user = bank.findUserByAccount(account);
        if (user == null) {
            System.out.println("No such account exists");
            return;
        }
        user.withdrawal(account, amount);
        System.out.println("Completed");
    }

    /**
     * deposit some amount of money to the account
     * @param account the destination account
     */
    public void deposit(Account account) {
        System.out.println();
        System.out.println("Enter an amount to deposit:");
        int amount = inputScanner.nextInt();
        if (amount <= 0) {
            System.out.println("Invalid input");
            deposit(account);
            return;
        }

        User user = bank.findUserByAccount(account);
        if (user == null) {
            System.out.println("No such account exists");
            return;
        }
        user.deposit(account, amount);
        System.out.println("Completed");
    }

    /**
     * transfer some amount of money from one account to the another one
     * @param srcAccount source account
     */
    public void transfer(Account srcAccount) {
        System.out.println();
        System.out.println("Enter destination account's serial:");
        String serial = inputScanner.nextLine();
        System.out.println("Enter the amount of money to transfer:");
        int amount = inputScanner.nextInt();

        Account destAccount = bank.findAccount(serial);
        if (destAccount == null) {
            System.out.println("No such account found");
            transfer(srcAccount);
            return;
        }
        User user = bank.findUserByAccount(srcAccount);
        user.transfer(srcAccount, destAccount, amount);
        System.out.println("Completed");
    }

    /**
     * return available money
     */
    public void checkBalance(Account account) {
        System.out.println();
        System.out.println("Account balance: " + account.getBalance());
    }

    /**
     * add a new account
     */
    public void addNewAccount(User user) {
        int amount;
        String type;
        System.out.println("Enter account initial amount: ");
        amount = inputScanner.nextInt();
        System.out.println("Enter account type: ");
        type = inputScanner.nextLine();
        if (amount < 0) {
            System.out.println("Invalid amount");
            addNewAccount(user);
            return;
        }

        Account newAccount = new Account(user.getId(), user.getFirstName(), user.getLastName(), type, amount);
        user.addAccount(newAccount);
        bank.addAccount(newAccount);
        System.out.println("New account opened");
    }

    /**
     * log out from the current user
     */
    public void logOut() {
        System.out.println();
        System.out.println("Logged out");
    }

    /**
     * enter system admin area
     */
    public void systemAdmin() {
        System.out.println();
        String username, password;
        System.out.println("Enter admin username:");
        username = inputScanner.nextLine();
        System.out.println("Enter admin password");
        password = inputScanner.nextLine();
        if (!username.equals("sysadmin") || !password.equals("1234")) {
            System.out.println("Username or password is incorrect.");
            systemAdmin();
            return;
        }
        adminMainMenu();
    }

    /**
     * implement admin main menu
     */
    public void adminMainMenu() {
        System.out.println();
        System.out.println("Choose an option:");
        System.out.println("1.Display users");
        System.out.println("2.Display accounts");
        System.out.println("3.Remove user");
        System.out.println("4.Remove account");
        System.out.println("5.Back");
        int option = inputScanner.nextInt();
        if (option == 1)
            bank.displayUsers();
        else if (option == 2)
            bank.displayAccounts();
        else if (option == 3)
            removeUser();
        else if (option == 4)
            removeAccount();
        else if (option == 5)
            return;
        else {
            System.out.println("Invalid input");
            adminMainMenu();
            return;
        }
        adminMainMenu();
    }

    /**
     * remove user with the given id
     */
    public void removeUser() {
        System.out.println("Enter the user id to be removed:");
        String id = inputScanner.nextLine();
        User user = bank.findUserById(id);
        if (user == null) {
            System.out.println("No such user exists");
            return;
        }
        bank.removeUser(user);
    }

    /**
     * remove account with the given serial
     */
    public void removeAccount() {
        System.out.println("Enter the serial account to be removed:");
        String serial = inputScanner.nextLine();
        Account account = bank.findAccount(serial);
        if (account == null) {
            System.out.println("No such Account exists");
            return;
        }
        bank.removeAccount(account);
    }

    /**
     * end program
     */
    public void exit() {
        System.out.println("Good luck & have fun ;D");
    }
}