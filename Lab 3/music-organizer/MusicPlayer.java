/**
 * Provide basic playing of MP3 files via the javazoom library.
 * See http://www.javazoom.net/
 * 
 * @author David J. Barnes and Michael Kolling with special thanks to Adibov
 * @version 2011.07.31
 */
public class MusicPlayer {
    // The current player. It might be null.
    private boolean isPlaying;
    /**
     * Constructor for objects of class MusicFilePlayer
     */
    public MusicPlayer() {
        isPlaying = false;
    }
    

    /**
     * Start playing the given audio file.
     * The method returns once the playing has been started.
     * @param filename The file to be played.
     */
    public void startPlaying(Music music) {
        if (isPlaying == true) {
            System.out.println("Some music is playing right now");
            return;
        }
        System.out.println(music.filename + " is playing...");
		isPlaying = true;
    }
    
    /**
     * Stop playing the current music
     */
    public void stop() {
        if (isPlaying == false) {
            System.out.println("Nothing is playing!");
            return
        }
        System.out.println("player is stopped!");
		isPlaying = false;
    }
}