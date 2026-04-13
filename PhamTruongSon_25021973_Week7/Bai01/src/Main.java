public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Task A", 2000);
        Task task2 = new Task("Task B", 5000);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();   


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("All tasks done.");
    }
}
