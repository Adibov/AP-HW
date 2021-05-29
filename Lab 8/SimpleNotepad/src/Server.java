import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class, runs server and response to client
 * @author Adibov
 * @version 1.0
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String message = "";

    /**
     * class constructor
     */
    public Server() {
        try {
            serverSocket = new ServerSocket(2021);
            socket = serverSocket.accept();
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
        Server server = new Server();
        while (true) {
            server.getInput();
            server.sendMessage();
            server.setMessage("");
        }
    }

    /**
     * getInput from the client
     */
    public void getInput() {
        String newMessage = "";
        while (true) {
            try {
                newMessage = (String) in.readObject();
                System.out.println("Server got this message: " + newMessage);
                if (newMessage.equals("over"))
                    break;
                message += newMessage + "\n";
                sendMessage();
            }
            catch (IOException | ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * write current message to the output stream
     */
    public void sendMessage() {
        System.out.println("Server wants to send this message: " + message);
        try {
            out.writeObject(message);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * message getter
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * message setter
     * @param message new message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
