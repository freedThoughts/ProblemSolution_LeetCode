package arcicium;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] arg) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 10; i++) {
            executorService.submit(
                    () -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " executing");
                    }
            );
        }

        executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        executorService.shutdown();
    }
}
