public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numThreads = 4;
        int incrementsPerThread = 10000;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    // có thể đổi sang increment() để xem kết quả tuyệt đối 40000
                    counter.incrementWithTryLock();
                }
            }, "Thread-" + i);
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final counter value: " + counter.getValue());
        System.out.println("Expected (if no tryLock fails): " + (numThreads * incrementsPerThread));
    }
}