import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client class, to simulate client behaviours
 * @author Adibov
 * @version 1.0
 */
public class Client {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Scanner inputScanner = new Scanner(System.in);

    /**
     * class constructor
     */
    public Client() {
        try {
            socket = new Socket("localhost", 2021);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * main method, makes class runnable
     * @param args program args
     */
    public static void main(String[] args) {
        Client client = new Client();
        while (true) {
            client.inputMessage();
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            client.update();
        }
    }

    /**
     * input a new message from the client
     */
    public void inputMessage() {
        String message = inputScanner.nextLine();
        try {
            out.writeObject(message);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * update client output stream if any message has been sent via the server
     */
    public void update() {
        System.out.println("\nReceived:");
        try {
            String message = (String) in.readObject();
            System.out.println(message);
        }
        catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        System.out.println();
    }
}
