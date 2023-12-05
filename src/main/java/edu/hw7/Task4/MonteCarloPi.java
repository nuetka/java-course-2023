package edu.hw7.Task4;

import lombok.extern.java.Log;

@Log
public class MonteCarloPi {

    private MonteCarloPi() {

    }

    @SuppressWarnings({"uncommentedmain", "Magicnumber"})
    public static void main(String[] args) {
        int iterations = 100000000; // Количество итераций
        int circleCount = 0; // Число точек, попавших в круг
        for (int i = 0; i < iterations; i++) {
            double x = Math.random(); // случайная координата x
            double y = Math.random(); // случайная координата y
            // Проверяем, попадает ли точка внутрь круга
            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }
        // Вычисляем приближение числа Пи
        double pi = 4.0 * circleCount / iterations;
        log.info("Приближение числа Пи: " + pi);
    }
}
