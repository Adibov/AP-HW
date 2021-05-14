import java.io.*;
import java.nio.file.Paths;

/**
 * read/write to/in files with file stream class
 * @author Adibov
 * @version 1.0
 */
public class StreamFileUtil extends FileUtils {
    /**
     * construct a new object
     */
    public StreamFileUtil() {

    }

    /**
     * write the given object to the file with the given path
     * @param object object file
     * @param path   file path
     */
    @Override
    public void writeToFile(Object object, String path) {
        String absolutePath = Paths.get(path).toAbsolutePath().toString();

        try (FileOutputStream fileInputStream = new FileOutputStream(absolutePath)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
            objectOutputStream.writeObject(object);
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

        try (FileInputStream fileInputStream = new FileInputStream(absolutePath)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
}
