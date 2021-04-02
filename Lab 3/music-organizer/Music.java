/**
 * Music class for implementing music track
 */
public class Music {
    private String type, address, filename;

    /**
     * constructor for making a new object
     * @param type
     * @param address
     */
    public Music(String filename, String type, String address) {
        this.type = type;
        this.address = address;
        this.filename = filename;
    }

    /**
     * print the details of the music
     */
    public void print() {
        System.out.println("Filename: " + filename + "\nType: " + type + "\nAddress: " + address);
    }
}