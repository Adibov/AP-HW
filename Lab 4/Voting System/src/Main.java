import java.util.ArrayList;
import java.util.Scanner;

/**
 * main class to run program
 * @author Adibov
 * @version 1.0
 */
public class Main {
    final private static VotingSystem voting = new VotingSystem();
    final private static Scanner inputScanner = new Scanner(System.in);
    private static ArrayList<Person> users = new ArrayList<Person>();

    public static void main(String[] args) {
        while (true) {
            Person person = logIn();
            mainMenu(person);
        }
    }

    public static Person logIn() {
        System.out.println();
        System.out.println("Choose an option:");
        System.out.println("1) Log in to an existing account");
        System.out.println("2) Signup");
        int option = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (option < 1 || option > 2) {
            System.out.println("Invalid input.");
            return logIn();
        }
        else if (option == 1) {
            Person result = logInToAccount();
            if (result == null)
                return logIn();
            return result;
        }
        else
            return signUp();
    }

    public static Person logInToAccount() {
        System.out.println();
        if (users.size() == 0) {
            System.out.println("No user found.");
            return null;
        }

        System.out.println("Choose a user:");
        int num = 1, index;
        for (Person person : users) {
            System.out.println("User #" + num + ": " + person.toString());
            num++;
        }
        index = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (index < 1 || index > users.size()) {
            System.out.println("Invalid input.");
            return logInToAccount();
        }
        return users.get(index - 1);
    }

    public static Person signUp() {
        System.out.println();
        String firstName, lastName;
        System.out.println("Enter your firstname:");
        firstName = inputScanner.nextLine();
        System.out.println("Enter your lastname:");
        lastName = inputScanner.nextLine();
        Person person = new Person(firstName, lastName);
        if (users.contains(person)) {
            System.out.println("This user exists.");
            return signUp();
        }
        users.add(person);
        return person;
    }

    public static void mainMenu(Person person) {
        System.out.println();
        System.out.println("Choose an option:");
        System.out.println("1) Add a new poll");
        System.out.println("2) Add a new vote");
        System.out.println("3) Show results");
        System.out.println("4) Show option for a Question");
        System.out.println("5) Back");
        System.out.println("6) Exit");
        int option = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (option < 1 || option > 6) {
            System.out.println("Invalid input.");
            mainMenu(person);
            return;
        }
        else if (option == 1)
            newPoll();
        else if (option == 2)
            newVote(person);
        else if (option == 3)
            results();
        else if (option == 4)
            showVotes();
        else if (option == 5)
            return;
        else {
            System.out.println();
            System.out.println("Good luck & have Fun ;D");
            System.exit(0);
        }
        mainMenu(person);
    }

    public static void newPoll() {
        System.out.println();
        int type, num;
        String question;
        ArrayList <String> options = new ArrayList <String>();
        System.out.println("Enter poll type: (0 for single voting / 1 for multiple voting)");
        type = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (type < 0 || type > 1) {
            System.out.println("Invalid type.");
            newPoll();
            return;
        }

        System.out.println();
        System.out.println("Enter question poll:");
        question = inputScanner.nextLine();
        System.out.println("Enter number of options:");
        num = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (num < 0) {
            System.out.println("Invalid input.");
            newPoll();
            return;
        }
        for (int i = 0; i < num; i++) {
            String option;
            System.out.println("Enter option #" + (i + 1) + ": ");
            option = inputScanner.nextLine();
            options.add(option);
        }
        voting.createVoting(question, type, options);
    }

    public static void newVote(Person person) {
        System.out.println();
        System.out.println("Choose a question:");
        Voting question;
        ArrayList<String> votes = new ArrayList<String>();

        voting.getVotingList();
        int index = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (index < 1 || index > voting.getVotingListSize()) {
            System.out.println("Invalid input.");
            newVote(person);
            return;
        }
        question = voting.getQuestionByIndex(index);

        System.out.println();
        System.out.println("Vote some options: (Enter 0 to end voting)");
        question.getPolls();
        while (true) {
            index = inputScanner.nextInt(); inputScanner.nextLine(); // drop
            if (index == 0)
                break;
            if (index < 1 || index > question.getPollsSize()) {
                System.out.println("Invalid input.");
                continue;
            }

            String option = question.getPollByIndex(index);
            if (votes.contains(option)) {
                System.out.println("You have voted this option before.");
                continue;
            }
            votes.add(option);
        }
        question.vote(person, votes);
    }

    public static void results() {
        System.out.println();
        System.out.println("Choose a question:");
        Voting question;
        ArrayList<String> votes = new ArrayList<String>();

        voting.getVotingList();
        int index = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (index < 1 || index > voting.getVotingListSize()) {
            System.out.println("Invalid input.");
            results();
            return;
        }
        voting.getResult(index);
    }

    public static void showVotes() {
        System.out.println();
        voting.getVoting();
    }
}
