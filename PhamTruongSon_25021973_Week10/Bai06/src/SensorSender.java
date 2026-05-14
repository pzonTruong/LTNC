import java.net.*;

public class SensorSender {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 6000;
        String data = "Temp: 28°C, Humidity: 65%";

        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buffer = data.getBytes();
            InetAddress address = InetAddress.getByName(host);
            
            DatagramPacket packet = new DatagramPacket(
                buffer, buffer.length, address, port
            );
            
            System.out.println("UDP Sender: Broadcasting weather data...");
            socket.send(packet);
            System.out.println("Sent: " + data);
            
        } catch (Exception e) {
            System.err.println("UDP Sender Error: " + e.getMessage());
        }
    }
}
