import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Robot> factoryList = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            int id = Integer.parseInt(parts[1]);
            String name = parts[2];

            if (type.equals("DR")) factoryList.add(new DroneRobot(id, name));
            else if (type.equals("FR")) factoryList.add(new FishRobot(id, name));
            else if (type.equals("AR")) factoryList.add(new AmphibiousRobot(id, name));
        }

        // Duyệt danh sách và kiểm tra kỹ năng
        System.out.println("---OUTPUT---");
        for (Robot r : factoryList) {
            r.performMainTask();

            // Downcasting an toàn với instanceof
            if (r instanceof Flyable) {
                ((Flyable) r).fly();
            }
            if (r instanceof Swimmable) {
                ((Swimmable) r).swim();
            }
            if (r instanceof GPS) {
                ((GPS) r).getCoordinates();
            }
            System.out.println(); // Ngắt dòng cho dễ nhìn
        }
        sc.close();
    }
}
