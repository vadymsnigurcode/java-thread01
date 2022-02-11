package threadTaskScheduleRepeat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);

        long start = System.currentTimeMillis();
        long end = start + 30*1000;
        int frameDelayMs = 200;
        while (System.currentTimeMillis() < end) {
            System.out.print("->");
            Thread.sleep(frameDelayMs);
            System.out.print("\b");
        }
        executor.shutdownNow();
    }
}
