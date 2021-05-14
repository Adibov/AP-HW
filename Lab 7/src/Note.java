import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * implement note attributes
 * @author Adibov
 * @version 1.0
 */
public class Note implements Serializable {
    final private LocalDate creationTime;
    private LocalDate lastModificationTime;
    private String filename, body;
    final private FileUtils streamFileUtil = new StreamFileUtil();
//    final private FileUtils streamFileUtil = new BufferFileUtil();

    /**
     * make a new valid note
     * @param filename note filename (title)
     * @param body note body
     */
    public Note(String filename, String body) {
        this.filename = filename;
        this.body = body;
        creationTime = LocalDate.now();
        lastModificationTime = LocalDate.now();
        save();
    }

    /**
     * save note to the corresponding file
     */
    public void save() {
        streamFileUtil.writeToFile(this,"Files" +
                streamFileUtil.getFileSeparator() +
                filename);
    }

    /**
     * delete note from the corresponding file
     */
    public void delete() {
        streamFileUtil.deleteFile("Files" +
                streamFileUtil.getFileSeparator() +
                filename );
    }

    /**
     * filename getter
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * getBody getter
     * @return getBody
     */
    public String getBody() {
        return body;
    }

    /**
     * show a summary of the note (actually first line of the note)
     */
    public void showSummary() {
        String[] bodyLines = body.split("\n");
        System.out.println(bodyLines[0]);
    }

    /**
     * show the whole note
     */
    public void showNote() {
        System.out.println(filename +
                "\nCreation date: " + creationTime +
                "\nLast modification date: " + lastModificationTime +
                "\n" + body);
    }
}
