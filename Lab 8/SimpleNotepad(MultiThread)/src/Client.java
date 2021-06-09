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
     * main method, make class runnable
     * @param args program args
     */
    public static void main(String[] args) {
        System.out.println("""
                Hey there
                Here we have a simple notepad that you can use to send message and receive them after typing 'over' key word.
                
                - Have Fun =)
                """);
        Scanner inputScanner = new Scanner(System.in);
        Client client = new Client();
        //noinspection InfiniteLoopStatement
        while (true) {
            String input = inputScanner.nextLine();
            client.sendMessage(input);
            Client.sleep();
            if (!client.isStreamEmpty())
                client.update();
        }
    }

    /**
     * check if stream is empty or not
     * @return boolean result
     */
    public boolean isStreamEmpty() {
        try {
            return socket.getInputStream().available() == 0;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return true;
    }

    /**
     * send the given message to the server
     * @param message given message
     */
    public void sendMessage(String message) {
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

    /**
     * sleep thread for a short time
     */
    static public void sleep() {
        try {
            Thread.sleep(300);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
