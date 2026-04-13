public class Task implements Runnable {
    private String name;
    private long durationMs;

    public Task(String name, long durationMs) {
        this.name = name;
        this.durationMs = durationMs;
    }

    @Override
    public void run() {
        System.out.println("Start " + name);
        try {
            // Mô phỏng thời gian thực hiện tác vụ
            Thread.sleep(durationMs);
        } catch (InterruptedException e) {
            System.err.println(name + " was interrupted.");
        }
        System.out.println("End " + name);
    }
}
