import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * read/write to/in files with buffer reader class
 * @author Adibov
 * @version 1.0
 */
public class BufferFileUtil extends FileUtils {
    /**
     * constructor to make a valid object
     */
    public BufferFileUtil() {

    }

    /**
     * write the given object to the file with the given path
     * @param object object file
     * @param path   file path
     */
    @Override
    public void writeToFile(Object object, String path) {
        String absolutePath = Paths.get(path).toAbsolutePath().toString();
        Note note = (Note)object;

        try (FileWriter fileWriter = new FileWriter(absolutePath)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(note.getFilename());
            bufferedWriter.write(note.getBody());
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * read a serializable object from the given path
     * @param path given path
     * @return result Object, returns null if cannot read any object
     */
    @Override
    public Object readFromFile(String path) {
        String absolutePath = Paths.get(path).toAbsolutePath().toString();
        String filename, body;

        try (FileReader fileReader = new FileReader(absolutePath)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            filename = bufferedReader.readLine();
            body = bufferedReader.readLine();
            return new Note(filename, body);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
}
