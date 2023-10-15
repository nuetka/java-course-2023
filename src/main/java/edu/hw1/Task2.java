package edu.hw1;

public class Task2 {
    public static int countDigits(int number) {
        int count = 0;
        if (number == 0) {
            return 1;
        }
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
