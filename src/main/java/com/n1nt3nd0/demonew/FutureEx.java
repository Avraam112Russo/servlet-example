package com.n1nt3nd0.demonew;

import java.util.concurrent.*;

public class FutureEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main thread start");
        Callable<Integer> runnable = () -> {
      System.out.println("async thread start");
            for (int i = 0; i < 10; i++){
                System.out.println(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
      System.out.println("async thread finish");
            return 666;
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(runnable);
//        executorService.shutdown();
        System.out.println("async thread result: "+future.get());
      System.out.println("main thread finish");

    }
}
