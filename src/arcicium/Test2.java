package arcicium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test2 {
    public static void main(String[] arg) throws InterruptedException {

        MyExecutorService executorService = new MyExecutorService(2);
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

        Thread.sleep(10000);
        executorService.isShutDown = true;
        //Thread.sleep(10000);

    }




    static class MyExecutorService {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        List<Runnable> threads = new ArrayList<>();

        void submit(Runnable runnable) throws InterruptedException {
            queue.offer(runnable);
        }

        boolean isShutDown;

        MyExecutorService(int threadPoolCount){
            for (int i = 0; i < threadPoolCount; i++) {
                Runnable runnable = () -> {
                    while (!isShutDown) {
                        try {
                            Runnable run = queue.poll();
                            if (run != null)
                                run.run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                Thread thread = new Thread(runnable);
                thread.start();

                threads.add(thread);
            }
        }
    }
}
