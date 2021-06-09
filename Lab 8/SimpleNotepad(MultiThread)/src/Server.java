import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Server class, runs server and response to client
 * @author Adibov
 * @version 1.0
 */
public class Server {
    private ServerSocket serverSocket;
    private ExecutorService threadPool;

    /**
     * class constructor
     */
    public Server() {
        try {
            serverSocket = new ServerSocket(2021);
            threadPool = Executors.newCachedThreadPool();
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
        //noinspection InfiniteLoopStatement
        while (true) {
            server.acceptNewClient();
        }
    }

    /**
     * accept new client to the server
     */
    public void acceptNewClient() {
        try {
            Socket socket = serverSocket.accept();
            ClientHandler newClientHandler = new ClientHandler(socket);
            threadPool.execute(newClientHandler);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
