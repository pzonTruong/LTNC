import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestChatClient {
    private static final String SERVER_URL = "http://localhost:8080";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static int clientId = -1;
    private static int lastSeenIndex = 0;

    public static void main(String[] args) {
        if (!join()) {
            System.err.println("Failed to join the chat room.");
            return;
        }

        System.out.println("Joined chat as Client ID: " + clientId);
        System.out.println("Type your messages below (type 'exit' to quit):");

        // Start polling thread
        Thread pollingThread = new Thread(RestChatClient::pollMessages);
        pollingThread.setDaemon(true);
        pollingThread.start();

        // Main input loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            if (!input.trim().isEmpty()) {
                sendMessage(input);
            }
        }
        System.out.println("Exiting chat...");
    }

    private static boolean join() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SERVER_URL + "/join"))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // Parse {"clientId": X} using regex to avoid external JSON lib
                Pattern pattern = Pattern.compile("\"clientId\":\\s*(\\d+)");
                Matcher matcher = pattern.matcher(response.body());
                if (matcher.find()) {
                    clientId = Integer.parseInt(matcher.group(1));
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error joining: " + e.getMessage());
        }
        return false;
    }

    private static void sendMessage(String content) {
        try {
            String form = "clientId=" + clientId + "&content=" + URLEncoder.encode(content, StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SERVER_URL + "/messages"))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(form))
                    .build();

            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }

    private static void pollMessages() {
        while (true) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(SERVER_URL + "/messages"))
                        .GET()
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    displayNewMessages(response.body());
                }
                Thread.sleep(2000); // Poll every 2 seconds
            } catch (InterruptedException e) {
                break;
            } catch (Exception e) {
                // System.err.println("Polling error: " + e.getMessage());
            }
        }
    }

    private static void displayNewMessages(String jsonArray) {
        // Simple manual parsing of JSON array of objects
        // [{"clientId": 1, "content": "hi", "timestamp": "..."}, ...]
        Pattern pattern = Pattern.compile("\\{\"clientId\":\\s*(\\d+),\\s*\"content\":\\s*\"(.*?)\",\\s*\"timestamp\":\\s*\"(.*?)\"\\}");
        Matcher matcher = pattern.matcher(jsonArray);
        
        int currentIndex = 0;
        while (matcher.find()) {
            if (currentIndex >= lastSeenIndex) {
                int senderId = Integer.parseInt(matcher.group(1));
                String content = matcher.group(2).replace("\\\"", "\"").replace("\\n", "\n");
                String time = matcher.group(3);
                
                if (senderId != clientId) {
                    System.out.printf("[%s] Client %d: %s%n", time, senderId, content);
                } else {
                    // System.out.printf("[%s] You: %s%n", time, content);
                }
                lastSeenIndex++;
            }
            currentIndex++;
        }
    }
}
