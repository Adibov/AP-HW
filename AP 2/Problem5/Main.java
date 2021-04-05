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
        else
            exit();
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
        System.out.println("Choose and option: ");
        System.out.println("1.Existing accounts");
        System.out.println("2.Add new account");
        System.out.println("3.Log out");
        int option = inputScanner.nextInt();
        if (option < 1 || option > 3) {
            System.out.println("Invalid input");
            logIn();
            return;
        }

        if (option == 1)
            existingAccounts();
        else if (option == 2)
            addNewAccount();
        else

        String id, password;
        System.out.print("Enter ID: ");
        id = inputScanner.nextLine();
        System.out.print("Enter Password: ");
        password = inputScanner.nextLine();
        bank.login(id, password);
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