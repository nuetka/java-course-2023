package edu.hw7.Task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.java.Log;

@Log
public class MonteCarloPiMultithreaded {
    private MonteCarloPiMultithreaded() {

    }

    @SuppressWarnings({"uncommentedmain", "Magicnumber"})
    public static void main(String[] args) {
        int iterations = 100000000; // Количество итераций
        int threadCount = Runtime.getRuntime().availableProcessors(); // Количество потоков
        int iterationsPerThread = iterations / threadCount; // Количество итераций на каждый поток
        AtomicInteger totalCircleCount = new AtomicInteger(0); // Общее число точек, попавших в круг
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                int circleCount = 0; // Число точек, попавших в круг
                for (int j = 0; j < iterationsPerThread; j++) {
                    double x = Math.random(); // случайная координата x
                    double y = Math.random(); // случайная координата y

                    // Проверяем, попадает ли точка внутрь круга
                    if (x * x + y * y <= 1) {
                        circleCount++;
                    }
                }
                totalCircleCount.addAndGet(circleCount);
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
            // Ждем завершения всех потоков
        }
        // Вычисляем приближение числа Пи
        double pi = 4.0 * totalCircleCount.get() / iterations;
        log.info("Приближение числа Пи: " + pi);
    }
}
