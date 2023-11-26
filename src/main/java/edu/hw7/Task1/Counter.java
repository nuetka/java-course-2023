package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private static final int NUM_THREADS = 5;
    private static final int ITERATIONS = 1000;
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    public static int run() {
        Counter counter = new Counter();
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Logger.logException(e);
            }
        }
        return counter.getCount();
    }

    public static class Logger {
        public static void logException(Exception e) {

        }
    }
}



