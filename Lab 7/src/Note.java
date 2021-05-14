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
    private LocalDate modificationTime;
    private String filename, body;

    /**
     * make a new valid note
     * @param filename note filename (title)
     * @param body note body
     */
    public Note(String filename, String body) {
        this.filename = filename;
        this.body = body;
        creationTime = LocalDate.now();
        modificationTime = LocalDate.now();

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
     * override toString method
     * @return String result
     */
    @Override
    public String toString() {
        return filename + "\n-----------------------------\n" + body;
    }
}
