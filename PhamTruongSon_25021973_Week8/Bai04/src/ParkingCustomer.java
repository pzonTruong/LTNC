
import java.util.*;

public class ParkingCustomer {
    private String name;
    private List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }

    public void addTicket(ParkingTicket t) {
        tickets.add(t);
    }

    public String receipt() {
        StringBuilder sb = new StringBuilder("Receipt for " + name + "\n");
        for (ParkingTicket t : tickets) {
            sb.append("\t").append(t.getPlate()).append("\t").append(t.getAmount()).append("\n");
        }
        sb.append("Total: ").append(getTotalAmount());
        return sb.toString();
    }

    private double getTotalAmount() {
        return tickets.stream().mapToDouble(ParkingTicket::getAmount).sum();
    }
}