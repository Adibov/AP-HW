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
        if (!bank.login(id, password)) {
            logIn();
            return;
        }
        logInMenu();
    }

    /**
     * show log in menu
     */
    public void logInMenu() {
        System.out.println();
        System.out.println("Choose and option: ");
        System.out.println("1.Existing accounts");
        System.out.println("2.Add new account");
        System.out.println("3.Log out");
        int option = inputScanner.nextInt();
        if (option < 1 || option > 3) {
            System.out.println("Invalid input");
            logInMenu();
            return;
        }

        if (option == 1)
            existingAccounts();
        else if (option == 2)
            addNewAccount();
        else {
            logOut();
            return;
        }
        logInMenu();
    }

    /**
     * existing accounts options
     */
    public void existingAccounts() {
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
            existingAccounts();
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
            existingAccounts();
            return;
        }

        if (option == 1)
            withDrawal();
        else if (option == 2)
            deposit();
        else if (option == 3)
            transfer();
        else if (option == 4)
            checkBalance();
        else {
            logInMenu();
            return;
        }
        existingAccounts();
    }

    /**
     * withdrawal some amount of money to the account
     */
    public void withDrawal() {

    }

    /**
     * deposit some amount of money to the account
     */
    public void deposit() {

    }

    /**
     * transfer some amount of money from one account to the another one
     */
    public void transfer() {

    }

    /**
     * return available money
     */
    public void checkBalance() {

    }

    /**
     * add a new account
     */
    public void addNewAccount() {

    }

    /**
     * log out from the current user
     */
    public void logOut() {

    }

    /**
     * enter system admin area
     */
    public void systemAdmin() {

    }

    /**
     * end program
     */
    public void exit() {

    }
}