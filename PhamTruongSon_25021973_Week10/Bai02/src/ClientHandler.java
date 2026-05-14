import java.io.*;
import java.net.*;
import java.util.logging.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private static final Logger logger = AppLogger.getLogger();

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String clientAddress = socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
        logger.info("Handling client: " + clientAddress);

        try (
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true)
        ) {
            String text;
            while ((text = reader.readLine()) != null) {
                logger.info("Message from " + clientAddress + ": " + text);
                
                // Echo the message back
                writer.println("Server echoed: " + text);

                if (text.equalsIgnoreCase("bye")) {
                    logger.info("Client requested disconnect: " + clientAddress);
                    break;
                }
            }
        } catch (IOException ex) {
            logger.log(Level.WARNING, "Error in ClientHandler for " + clientAddress, ex);
        } finally {
            try {
                socket.close();
                logger.info("Connection closed: " + clientAddress);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Could not close socket for " + clientAddress, e);
            }
        }
    }
}
