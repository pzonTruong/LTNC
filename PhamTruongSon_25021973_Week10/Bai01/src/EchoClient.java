import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    private String hostname;
    private int port;

    public EchoClient(String hostname, int port) {
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

            do {
                System.out.print("Enter text: ");
                text = scanner.nextLine();

                writer.println(text);

                String response = reader.readLine();
                System.out.println("Server response: " + response);

            } while (!text.equalsIgnoreCase("bye"));

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 5000;
        EchoClient client = new EchoClient(hostname, port);
        client.start();
    }
}
