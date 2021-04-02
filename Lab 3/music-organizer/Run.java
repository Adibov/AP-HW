import java.util.Scanner;

/**
 * Run class to create some instances and test program
 * @author Adibov
 * @version 1.0
 */
public class Run {
	private static MusicCollection mc;
	private static Scanner inputScanner;

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		inputScanner = new Scanner(System.in);
		mc = new MusicCollection();
		while (true) {
			showMenu();
			String input = inputScanner.next();
			if (input.equals("1"))
				addMusic();
			else if (input.equals("2"))
				numberOfEachType();
			else if (input.equals("3"))
				listOfMusics();
			else if (input.equals("4"))
				removeMusic();
			else if (input.equals("5"))
				playMusic();
			else if (input.equals("6"))
				stopPlaying();
			else if (input.equals("7"))
				addToFavourite();
			else if (input.equals("8"))
				removeFromFavourite();
			else if (input.equals("9"))
				showFavourite();
			else if (input.equals("10"))
				findSong();
			else if (input.equals("11"))
				break;
			else
				System.out.println("Invalid input!");
			System.out.println();
		}
		System.out.println("Good luck & have fun ;D");
	}

	/**
	 * add music to the list
	 */
	public static void addMusic() {
		String filename, type, address, artist, releaseDate;
		System.out.println("Enter music's filename, type(Pop, Jazz, Rock, Country), address, artist and realese date separated by enter: ");
		filename = inputScanner.nextLine();
		filename = inputScanner.nextLine();
		type = inputScanner.nextLine();
		address = inputScanner.nextLine();
		artist = inputScanner.nextLine();
		releaseDate = inputScanner.nextLine();
		mc.addMusic(filename, type, address, artist, releaseDate);
	}

	/**
	 * show the number of each type
	 */
	public static void numberOfEachType() {
		System.out.println("Pop's number: " + mc.getNumberOfTypes("Pop") + "\nJazz's number: " + mc.getNumberOfTypes("Jazz") + "\nRock's number: " + mc.getNumberOfTypes("Rock") + "\nCountry's number: " + mc.getNumberOfTypes("Country"));
	}

	/**
	 * show the list of musics
	 */
	public static void listOfMusics() {
		System.out.println("Musics: ");
		mc.listAllMusics();
	}

	/**
	 * remove a music
	 */
	public static void removeMusic() {
		System.out.print("Enter the index of the music to be removed: ");
		int index = inputScanner.nextInt();
		mc.removeMusic(index);
	}

	/**
	 * play a music
	 */
	public static void playMusic() {
		System.out.print("Enter the index of the music to be played: ");
		int index = inputScanner.nextInt();
		mc.startPlaying(index);
	}

	/**
	 * stop playing the music
	 */
	public static void stopPlaying() {
		mc.stopPlaying();
	}

	/**
	 * add to favourites
	 */
	public static void addToFavourite() {
		System.out.print("Enter the index of the music to be added to favourites: ");
		int index = inputScanner.nextInt();
		mc.addToFavourite(index);
	}

	/**
	 * remove a song from favourites
	 */
	public static void removeFromFavourite() {
		System.out.print("Enter the index of the music to be removed from favourites: ");
		int index = inputScanner.nextInt();
		mc.removeFromFavourite(index);
	}

	public static void showFavourite() {
		System.out.println("Favourites: ");
		mc.showFavourite();
	}

	private static void findSong() {
		String filename;
		System.out.println("Enter the name of the song you want to find");
		filename = inputScanner.nextLine();
		filename = inputScanner.nextLine();
		mc.findSong(filename);
	}

	/**
	 * show menu in the stdout
	 */
	public static void showMenu() {
		System.out.println("1) Add a music");
		System.out.println("2) Get the number of musics from each type");
		System.out.println("3) Show list of the musics");
		System.out.println("4) Remove a music");
		System.out.println("5) Play a music");
		System.out.println("6) Stop playing");
		System.out.println("7) Add a music to the favourite list");
		System.out.println("8) remove a music from the favourite list");
		System.out.println("9) show the favourite list");
		System.out.println("10) Find song by filename");
		System.out.println("11) Exit");
	}
}