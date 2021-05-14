import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * implement a simple version of notebook
 * @author Adibov
 * @version 1.0
 */
public class Notebook {
    final private ArrayList<Note> notesList = new ArrayList<Note>();

    /**
     * make a new valid object
     */
    public Notebook() {
        addInitialNotes();
    }

    /**
     * add files in Files/ directory to list
     */
    private void addInitialNotes() {
        FileUtils streamFileUtil = new BufferFileUtil();
//        FileUtils streamFileUtil = new StreamFileUtil();
        String absolutePath = Paths.get("Files").toAbsolutePath().toString();
        String[] filesList = new File(absolutePath).list();
        if (filesList == null)
            return;

        for (String filename : filesList) {
            if (filename.charAt(0) == '.')
                continue;

            Note note = (Note)streamFileUtil.readFromFile("Files" +
                    streamFileUtil.getFileSeparator() +
                    filename);
            addNote(note);
        }
    }

    /**
     * add the given note to the list of notes
     * @param note the given note
     */
    public void addNote(Note note) {
        notesList.add(note);
    }

    /**
     * return number of notes in the list
     * @return notes number
     */
    public int noteNumber() {
        return notesList.size();
    }

    /**
     * return note with the given index
     * @param index the given index
     * @return result note
     */
    public Note getNoteByIndex(int index) {
        if (index < 1 || index > notesList.size())
            return null;
        return notesList.get(index - 1);
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
            index++;
        }
    }

    /**
     * show notes with their name (title)
     */
    public void showNotesList() {
        int index = 1;
        for (Note note : notesList) {
            System.out.println("Note #" + index + ": " + note.getFilename());
            index++;
        }
    }
}
