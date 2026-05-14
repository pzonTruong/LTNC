import java.io.*;
import java.net.*;

public class EchoServer {
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                    InputStream input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);

                    String text;
                    while ((text = reader.readLine()) != null) {
                        System.out.println("Received: " + text);
                        writer.println(text);
                        if (text.equalsIgnoreCase("bye")) {
                            break;
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Server exception: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            System.out.println("Could not listen on port " + port);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 5000;
        EchoServer server = new EchoServer(port);
        server.start();
    }
}
