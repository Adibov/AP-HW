import java.util.ArrayList;

/**
 * implement a simple version of notebook
 * @author Adibov
 * @version 1.0
 */
public class Notebook {
    final private ArrayList<Note> notesList = new ArrayList<Note>();

    /**
     * add the given note to the list of notes
     * @param note the given note
     */
    public void addNote(Note note) {
        notesList.add(note);
    }

    /**
     * delete the given note from the list of notes
     * @param note the given note
     */
    public void deleteNote(Note note) {
        if (!notesList.contains(note))
            return;
        notesList.remove(note);
        note.delete();
    }

    /**
     * show summary of notes
     */
    public void showSummaryOfNotes() {
        int index = 1;
        for (Note note : notesList) {
            System.out.println("Note #" + index + "\n");
            note.showSummary();
            System.out.println();
        }
    }
}
