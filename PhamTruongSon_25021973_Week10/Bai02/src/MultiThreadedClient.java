import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultiThreadedClient {
    private String hostname;
    private int port;

    public MultiThreadedClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start() {
        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to the server on " + hostname + ":" + port);

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            Scanner scanner = new Scanner(System.in);
            String text;

            System.out.println("Type your messages (type 'bye' to exit):");
            do {
                System.out.print("> ");
                text = scanner.nextLine();

                writer.println(text);

                String response = reader.readLine();
                if (response != null) {
                    System.out.println(response);
                } else {
                    System.out.println("Server disconnected.");
                    break;
                }

            } while (!text.equalsIgnoreCase("bye"));

        } catch (UnknownHostException ex) {
            System.err.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 5000;
        MultiThreadedClient client = new MultiThreadedClient(hostname, port);
        client.start();
    }
}
