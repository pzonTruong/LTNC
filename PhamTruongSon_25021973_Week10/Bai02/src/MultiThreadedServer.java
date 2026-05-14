import java.io.*;
import java.net.*;
import java.util.logging.*;

public class MultiThreadedServer {
    private int port;
    private static final Logger logger = AppLogger.getLogger();

    public MultiThreadedServer(int port) {
        this.port = port;
    }

    public void start() {
        AppLogger.setup();
        logger.info("Server starting on port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Server is listening...");

            while (true) {
                Socket socket = serverSocket.accept();
                logger.info("New client connected: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

                // Create a new thread for each client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Server error", ex);
        }
    }

    public static void main(String[] args) {
        int port = 5000;
        MultiThreadedServer server = new MultiThreadedServer(port);
        server.start();
    }
}
