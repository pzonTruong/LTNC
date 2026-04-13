public class Main {
    public static void main(String[] args) {
        Worker workerTask = new Worker();
        Thread workerThread = new Thread(workerTask);

        // 1. Chạy luồng
        workerThread.start();

        try {
            // 2. Cho luồng chạy khoảng 1 giây
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. Yêu cầu dừng luồng
        System.out.println("Main thread requesting stop...");
        workerTask.stop();

        try {
            // 4. Đợi luồng kết thúc hoàn toàn
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}