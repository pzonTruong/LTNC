import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RestChatServer {
    private static final int PORT = 8080;
    private static final AtomicInteger clientCounter = new AtomicInteger(0);
    private static final List<Message> messages = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        server.createContext("/join", new JoinHandler());
        server.createContext("/messages", new MessageHandler());

        server.setExecutor(null); // creates a default executor
        System.out.println("REST Chat Server started on port " + PORT);
        server.start();
    }

    static class JoinHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                int clientId = clientCounter.incrementAndGet();
                String response = "{\"clientId\": " + clientId + "}";
                sendResponse(exchange, 200, response);
                System.out.println("Client " + clientId + " joined.");
            } else {
                sendResponse(exchange, 405, "Method Not Allowed");
            }
        }
    }

    static class MessageHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            if ("POST".equalsIgnoreCase(method)) {
                handlePostMessage(exchange);
            } else if ("GET".equalsIgnoreCase(method)) {
                handleGetMessages(exchange);
            } else {
                sendResponse(exchange, 405, "Method Not Allowed");
            }
        }

        private void handlePostMessage(HttpExchange exchange) throws IOException {
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String body = br.lines().collect(Collectors.joining());
            
            Map<String, String> params = parseQueryParams(body);
            String clientIdStr = params.get("clientId");
            String content = params.get("content");

            if (clientIdStr != null && content != null) {
                int clientId = Integer.parseInt(clientIdStr);
                Message msg = new Message(clientId, content);
                messages.add(msg);
                System.out.println("Received message from Client " + clientId + ": " + content);
                sendResponse(exchange, 200, "{\"status\": \"success\"}");
            } else {
                sendResponse(exchange, 400, "{\"error\": \"Missing clientId or content\"}");
            }
        }

        private void handleGetMessages(HttpExchange exchange) throws IOException {
            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < messages.size(); i++) {
                Message m = messages.get(i);
                json.append(String.format("{\"clientId\": %d, \"content\": \"%s\", \"timestamp\": \"%s\"}",
                        m.clientId, 
                        escapeJson(m.content), 
                        m.timestamp.format(DateTimeFormatter.ISO_LOCAL_TIME)));
                if (i < messages.size() - 1) {
                    json.append(",");
                }
            }
            json.append("]");
            sendResponse(exchange, 200, json.toString());
        }
    }

    private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, bytes.length);
        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }

    private static Map<String, String> parseQueryParams(String query) {
        Map<String, String> result = new HashMap<>();
        if (query == null || query.isEmpty()) return result;
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], URLDecoder.decode(entry[1], StandardCharsets.UTF_8));
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }

    private static String escapeJson(String text) {
        return text.replace("\"", "\\\"").replace("\n", "\\n");
    }

    static class Message {
        int clientId;
        String content;
        LocalDateTime timestamp;

        Message(int clientId, String content) {
            this.clientId = clientId;
            this.content = content;
            this.timestamp = LocalDateTime.now();
        }
    }
}
