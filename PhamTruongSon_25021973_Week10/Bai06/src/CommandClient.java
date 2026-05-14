import java.io.*;
import java.net.*;

public class CommandClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        String[] commands = {"START", "SHUTDOWN"};

        for (String cmd : commands) {
            try (Socket socket = new Socket(host, port);
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                
                System.out.println("Connecting to server...");
                System.out.println("Sending: " + cmd);
                writer.println(cmd);
                
                String response = reader.readLine();
                System.out.println("Server Response: " + response);

            } catch (ConnectException e) {
                System.err.println("Error: Remote server is offline!");
                break; // Exit if server is not reachable
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
            
            // Brief pause between commands
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
    }
}
