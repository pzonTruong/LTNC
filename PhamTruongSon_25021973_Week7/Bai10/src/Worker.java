public class Worker implements Runnable {
    // volatile đảm bảo mọi luồng đều nhìn thấy giá trị mới nhất của running
    // ngay khi nó được thay đổi bởi luồng khác.
    private volatile boolean running = true;

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        System.out.println("Worker thread started.");
        
        while (running) {
            // In thông báo mô phỏng công việc
            System.out.println("Working...");
            
            try {
                // Tạm nghỉ một chút để không làm tràn console
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Worker interrupted.");
            }
        }
        
        System.out.println("Worker thread stopped safely.");
    }
}