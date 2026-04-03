
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Stack<Message> MessageHistory = new Stack<>();
        LinkedList<Customer> CustomerQueue = new LinkedList<>();

        Customer A = new Customer("id_1", "PSon");
        Customer B = new Customer("id_2", "CusNo2");

        CustomerQueue.offer(A);
        CustomerQueue.offer(B);

        System.out.println("--OUTPUT--");
        for (Customer x: CustomerQueue){
            Customer curr = x;
            processCustomer(curr, MessageHistory);
        }
        System.out.println("Khong con khach doi");
    }

    public static void sendMessage(String id, String content, Stack<Message> h) {
        h.push(new Message(id, content));
        System.out.println("Sent: " + content + " (ID: " + id + ")");
    }

    public static Message Undo(Stack<Message> h) {
        Message res = h.pop();
        return res;
    }

    public static Message ViewLast(Stack<Message> h) {
        Message res = h.peek();
        return res;
    }

    public static void processCustomer(Customer curr, Stack<Message> messageHistory) {
        // Customer current = ll.poll();

        if (curr == null) {
            System.out.println("Out of customers");
            return;
        }

        System.out.println("Now supporting: " + curr);
        messageHistory.clear();

        sendMessage("1", "Content 1", messageHistory);
        sendMessage("2", "Content 2", messageHistory);
        sendMessage("3", "Content 3", messageHistory);

        // xem lai cau vua chat (View Last)
        System.out.println("Last message: " + ViewLast(messageHistory));
        // xoa cau vua chat (Undo)
        System.out.println("Undo message: " + Undo(messageHistory));
        System.out.println("Done supporting " + curr);
    }
}
