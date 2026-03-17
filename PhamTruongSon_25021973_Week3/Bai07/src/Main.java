
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] parts = line.split("\\s+");

        String type = parts[0];
        int noDays = Integer.parseInt(parts[1]);

        Room room = null;

        if (type.equalsIgnoreCase("S")) {
            room = new RegularRoom(500000, noDays);
        } else if (type.equalsIgnoreCase("V")) {
            room = new VIPRoom(2000000, noDays);
        }
        System.out.println(room.getFinalPrice());
        sc.close();
    }
}
