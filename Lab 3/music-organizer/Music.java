/**
 * Music class for implementing music track
 */
public class Music {
    private String type, address, filename, artist, releaseDate;

    /**
     * constructor for making a new object
     * @param type
     * @param address
     */
    public Music(String filename, String type, String address, String artist, String releaseDate) {
        this.type = type;
        this.address = address;
        this.filename = filename;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }

    /**
     * print the details of the music
     */
    public void print() {
        System.out.println("Filename, Type, Address, Artist, Release Date: " + filename + " " + type + " " + address + " " + artist + " " + releaseDate);
    }

    /**
     * type getter
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * filename getter
     * @return filename
     */
    public String getFilename() {
        return filename;
    }
}