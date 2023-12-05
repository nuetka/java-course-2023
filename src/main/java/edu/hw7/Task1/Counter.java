package edu.hw7.Task1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.java.Log;

@Log
public class Counter {

    private Counter() {

    }

    private static final int NUM_THREADS = 5;
    private static final int ITERATIONS = 5000;
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    public static int run() {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        try {
            Future<?> future = executor.submit(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    COUNT.incrementAndGet();
                }
            });

            future.get();
        } catch (ExecutionException | InterruptedException e) {
            log.severe("Something's wrong here");
        } finally {
            executor.shutdown();
        }

        return COUNT.get();
    }
}



