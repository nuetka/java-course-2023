package edu.hw1;

public class Task2 {

    private Task2() {

    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int number) {
        int count = 0;
        if (number == 0) {
            return 1;
        }
        int tempNumber = number;
        while (tempNumber != 0) {
            tempNumber /= 10;
            count++;
        }
        return count;
    }
}
