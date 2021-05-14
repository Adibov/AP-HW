import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * handle operations(read/write) on files
 * @author Adibov
 * @version 1.0
 */
abstract public class FileUtils {
    final private String fileSeparator = System.getProperty("file.separator");

    /**
     * constructor to make a new object
     */
    public FileUtils() {
        checkEssentials();
    }

    /**
     * check if the necessary files/folders exits
     */
    public void checkEssentials() {
        createFolder("Files");
    }

    /**
     * create a folder with the given path if doesn't exist
     * @param relativePath relative path
     */
    public void createFolder(String relativePath) {
        Path path = Paths.get(relativePath).toAbsolutePath();
        File newFolder = new File(path.toString());
        if (!newFolder.exists() && !newFolder.mkdirs())
            throw new SecurityException("Cannot make new folder.");
    }

    /**
     * create a file with the given name
     * @param filename new filename
     */
    public void createFile(String filename) {
        Path path = Paths.get("Files" + fileSeparator + filename).toAbsolutePath();
        File newFile = new File(path.toString());
        try {
            if (!newFile.exists() && !newFile.createNewFile())
                throw new SecurityException("Cannot make new file.");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * write the given object to the file with the given path
     * @param object object file
     * @param path file path
     */
    abstract public void writeToFile(Object object, String path);

    /**
     * read a serializable object from the given path
     * @param path given path
     * @return result Object, returns null if cannot read any object
     */
    abstract public Object readFromFile(String path);
}
