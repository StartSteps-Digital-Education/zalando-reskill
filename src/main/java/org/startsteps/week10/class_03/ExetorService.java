package org.startsteps.week10.class_03;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExetorService {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(4);

        // Runnable task => Return void
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        // Callable task => Return Future => expect result
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Callable task returned";
        };

//        List<Callable<String>> tasks = new ArrayList<>();
//        tasks.add(callableTask);
//        tasks.add(callableTask);

        executorService.submit(runnableTask);


        Future<String> future = executorService.submit(callableTask);

        String result = null;
        try {
            result = future.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
