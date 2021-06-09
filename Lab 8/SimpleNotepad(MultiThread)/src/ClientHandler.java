import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * ClientHandler class manages interactions with client
 * @author Adibov
 * @version 1.0
 */
public class ClientHandler implements Runnable {
    Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    /**
     * class constructor
     * @param socket client socket
     */
    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * override run method to make class runnable
     */
    @Override
    public void run() {
        runInputEngine();
    }

    /**
     * run input engine and start getting input from client
     */
    public void runInputEngine() {
        StringBuilder message = new StringBuilder();
        //noinspection InfiniteLoopStatement
        while (true) {
            String receivedMessage = getMessage();
            if (receivedMessage == null) {
                ClientHandler.sleep();
                continue;
            }
            if (receivedMessage.equals("over")) {
                sendMessage(message.toString());
                message = new StringBuilder();
            }
            else
                message.append(receivedMessage).append('\n');
        }
    }

    /**
     * check if stream is empty
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
     * if stream is not empty, reads a message from stream
     * @return received message. returns null if stream is empty
     */
    public String getMessage() {
        if (isStreamEmpty())
            return null;
        String receivedMessage = null;
        try {
             receivedMessage = (String) inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return receivedMessage;
    }

    /**
     * send the given message to the client
     * @param message given message
     */
    public void sendMessage(String message) {
        try {
            outputStream.writeObject(message);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * sleep thread for a short time
     */
    public static void sleep() {
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
