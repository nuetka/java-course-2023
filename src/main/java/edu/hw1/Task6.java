package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {

    public static int countK(int number) {
        if (number<=1000 | number>9999){
            return -1;
        }

        if (number == 6174) {
            return 0; // Базовый случай: если число равно 6174, возвращаем 0 (шагов не требуется).
        }

        // Преобразуем число в массив цифр
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Сортируем цифры по возрастанию и убыванию
        int ascNumber = getNumberFromDigits(digits, true);
        int descNumber = getNumberFromDigits(digits, false);

        // Вычисляем разность между числами и рекурсивно вызываем функцию для новой разности
        int diff = Math.abs(descNumber - ascNumber);
        return 1 + countK(diff); // К шагам добавляем 1 и рекурсивно вызываем функцию для новой разности.
    }

    private static int getNumberFromDigits(int[] digits, boolean ascending) {
        if (ascending) {
            // Сортировка по возрастанию
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3 - i; j++) {
                    if (digits[j] > digits[j + 1]) {
                        int temp = digits[j];
                        digits[j] = digits[j + 1];
                        digits[j + 1] = temp;
                    }
                }
            }
        } else {
            // Сортировка по убыванию
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3 - i; j++) {
                    if (digits[j] < digits[j + 1]) {
                        int temp = digits[j];
                        digits[j] = digits[j + 1];
                        digits[j + 1] = temp;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = result * 10 + digits[i];
        }
        return result;
    }
}
