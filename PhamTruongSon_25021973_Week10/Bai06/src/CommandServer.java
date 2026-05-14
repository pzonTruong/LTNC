import java.io.*;
import java.net.*;

public class CommandServer {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // Set timeout for accept()
            serverSocket.setSoTimeout(5000);
            System.out.println("Command Server is listening on port " + port + "...");

            boolean running = true;
            while (running) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                    String command = reader.readLine();
                    if (command == null) continue;

                    switch (command.toUpperCase()) {
                        case "START":
                            System.out.println("System initialized...");
                            writer.println("ACK: System initialized");
                            break;
                        case "SHUTDOWN":
                            System.out.println("System shutdown...");
                            writer.println("ACK: System shutdown");
                            running = false;
                            break;
                        default:
                            writer.println("ERROR: Unknown command");
                            break;
                    }
                } catch (SocketTimeoutException e) {
                    System.err.println("Timeout: No client connected within 5 seconds.");
                } catch (IOException e) {
                    System.err.println("Client Communication Error: " + e.getMessage());
                }
            }
        } catch (BindException e) {
            System.err.println("Error: Could not bind to port " + port + ". It might be in use.");
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}
