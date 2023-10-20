package edu.hw1;

public class Task2 {

    private static final int DECIMAL_BASE = 10;

    private Task2() {

    }

    public static int countDigits(int number) {
        int count = 0;
        if (number == 0) {
            return 1;
        }
        int tempNumber = number;
        while (tempNumber != 0) {
            tempNumber /= DECIMAL_BASE;
            count++;
        }
        return count;
    }
}
