import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kolling with special thanks to Adibov
 * @version 2011.07.31
 */
public class MusicCollection {
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> files, pop, jazz, rock, country;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection() {
        player = new MusicPlayer();
        files = new ArrayList<Music>();
        pop = new ArrayList<Music>();
        jazz = new ArrayList<Music>();
        rock = new ArrayList<Music>();
        country = new ArrayList<Music>();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     * @param type
     * @param address
     */
    public void addMusic(String filename, String type, String address) {
        Music newMusic = new Music(filename, type, address);
        if (type.equals("Pop")) {
            pop.add(newMusic);
        }
        else if (type.equals("Jazz")) {
            jazz.add(newMusic);
        }
        else if (type.equals("Rock")) {
            rock.add(newMusic);
        }
        else if (type.equals("Country")) {
            country.add(newMusic);
        }
        else {
            System.out.println("Invalid type");
            return;
        }
        files.add(newMusic);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfMusics() {
        return files.size();
    }

    /**
     * Return the number of files with the given type
     * @return the number of files
     */
    public int getNumberOfTypes(String type) {
        if (type.equals("Pop"))
            return pop.size();
        else if (type.equals("Jazz"))
            return jazz.size();
        else if (type.equals("Rock"))
            return rock.size();
        else if (type.equals("Country"))
            return country.size();
        else
            System.out.println("Invalid type");
        return 0;
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listMusic(int index) {
        files.get(index).print();
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllMusics() {
        for (Music i : files)
            i.print();
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeMusic(int index) {
        if (!validIndex(index)) {
            System.out.println("Invalid index");
            return;
        }
        index--;

        Music deletedMusic = files.get(index);
        if (deletedMusic.getType().equals("Pop"))
            pop.remove(deletedMusic);
        else if (deletedMusic.getType().equals("Jazz"))
            jazz.remove(deletedMusic);
        else if (deletedMusic.getType().equals("Rock"))
            rock.remove(deletedMusic);
        else if (deletedMusic.getType().equals("Country"))
            country.remove(deletedMusic);
        files.remove(deletedMusic);
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index) {
        if (!validIndex(index)) {
            System.out.println("Invalid index");
            return;
        }
        index--;
        player.startPlaying(files.get(index));
    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        player.stopPlaying();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index) {
        // The return value.
        // Set according to whether the index is valid or not.
        index--;
        if (index < 0 || index >= files.size())
            return false;
        return true;
    }


}