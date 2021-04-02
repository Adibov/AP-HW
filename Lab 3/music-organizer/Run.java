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
				break;
			else
				System.out.println("Invalid input!");
		}
		System.out.println("Good luck & have fun ;D");
	}

	/**
	 * add music to the list
	 */
	public void addMusic() {
		String filename, type, address;
		System.out.print("Enter music's filename: ");
		filename = inputScanner.nextLine();
		System.out.print("Enter music's type: (Pop, Jazz, Rock, Country) ");
		type = inputScanner.nextLine();
		System.out.print("Enter music's address: ");
		address = inputScanner.nextLine();
		mc.addMusic(filename, type, address);
	}

	/**
	 * show the number of each type
	 */
	public void numberOfEachType() {
		System.out.println("Pop's number: " + mc.getNumberOfTypes("Pop") + "\nJazz's number: " + mc.getNumberOfTypes("Jazz") + "\nRock's number: " + mc.getNumberOfTypes("Rock") + "\nCountry's number: " + mc.getNumberOfTypes("Country"));
	}

	/**
	 * show the list of musics
	 */
	public void listOfMusics() {
		System.out.println("Musics: ");
		mc.listAllMusics();
	}

	/**
	 * remove a music
	 */
	public void removeMusic() {
		System.out.print("Enter the index of the music to be removed: ");
		int index = inputScanner.nextInt();
		mc.removeMusic(index);
	}

	/**
	 * play a music
	 */
	public void playMusic() {
		System.out.print("Enter the index of the music to be played: ");
		int index = inputScanner.nextInt();
		mc.removeMusic(index);
	}

	/**
	 * stop playing the music
	 */
	public void stopPlaying() {
		mc.stopPlaying();
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
		System.out.println("7) Exit");
	}
}