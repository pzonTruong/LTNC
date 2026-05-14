import java.net.*;

public class SensorReceiver {
    public static void main(String[] args) {
        int port = 6000;
        
        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("UDP Receiver: Waiting for weather data on port " + port + "...");
            
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                
                // Block until a packet is received
                socket.receive(packet);
                
                String receivedData = new String(packet.getData(), 0, packet.getLength());
                System.out.println("[Telemetry Received] " + receivedData);
                
                // If data contains SHUTDOWN or similar we could stop, but the prompt implies continuous monitoring
            }
        } catch (BindException e) {
            System.err.println("Error: UDP Port " + port + " is already in use.");
        } catch (Exception e) {
            System.err.println("UDP Receiver Error: " + e.getMessage());
        }
    }
}
