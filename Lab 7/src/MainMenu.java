import java.util.Scanner;

/**
 * implement main menu to contract with client
 */
public class MainMenu {
    final private Scanner inputScanner = new Scanner(System.in);
    final private Notebook notebook = new Notebook();

    /**
     * show main menu to the client
     */
    public void mainMenu() {
        clearScreen();
        System.out.println("""
                Choose an option:
                1) Add new note
                2) Show a summary of notes
                3) View a note
                4) Delete a note
                5) Exit
                """);
        int option = inputScanner.nextInt(); inputScanner.nextLine(); // drop
        if (option < 1 || option > 5) {
            showMessage("Invalid input");
            mainMenu();
            return;
        }

        if (option == 1)
            addNewNote();
        else if (option == 2)
            showSummary();
        else if (option == 3)
            viewNote();
        else if (option == 4)
            deleteNote();
        else
            exit();
    }

    /**
     * get a new note and add it to the notebook
     */
    private void addNewNote() {
        String filename, body;
        System.out.println("Enter title of the note:");
        filename = inputScanner.nextLine();
        System.out.println("\nEnter body of the note in one line:");
        body = inputScanner.nextLine();
        notebook.addNote(new Note(filename, body));
        showMessage("A new node added successfully.");
    }

    /**
     * show a summary of the notes
     */
    private void showSummary() {
        notebook.showSummaryOfNotes();
        System.out.println();
        getAnInputFromStdin();
    }

    /**
     * show a specific note to the client
     */
    private void viewNote() {
        Note note = chooseNote("Choose a note to view:");
        clearScreen();
        note.showNote();
    }

    /**
     * delete note
     */
    private void deleteNote() {
        Note note = chooseNote("Choose a note to delete:");
        clearScreen();
        notebook.deleteNote(note);
    }

    private void exit() {
        clearScreen();
        System.out.println("Good luck, have fun ;D");
        System.exit(0);
    }

    /**
     * show list of notes to the client and return the chosen note
     * @param message showing message
     * @return result note
     */
    private Note chooseNote(String message) {
        clearScreen();
        System.out.println(message);
        notebook.showNotesList();

        int option = inputScanner.nextInt();
        if (option < 1 || option > notebook.noteNumber()) {
            showMessage("Invalid input.");
            return chooseNote(message);
        }
        return notebook.getNoteByIndex(option);
    }

    /**
     * show a message and wait for client to press an input
     * @param message the given message
     */
    private void showMessage(String message) {
        clearScreen();
        System.out.println(message);
        getAnInputFromStdin();
    }

    /**
     * wait until client press a key to continue
     */
    private void getAnInputFromStdin() {
        System.out.println("Press any key to continue...");
        inputScanner.nextLine(); // drop
    }

    /**
     * clear screen by printing several empty lines
     */
    private void clearScreen() {
        for (int i = 0; i < 70; i++)
            System.out.println();
    }
}
