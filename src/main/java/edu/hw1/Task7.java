package edu.hw1;

public class Task7 {

    private Task7() {

    }

    public static int rotateRight(int n, int shift) {
        String binaryString = Integer.toBinaryString(n);

        for (int i = 0; i < shift; i++) {
            char lastChar = binaryString.charAt(binaryString.length() - 1);
            binaryString = lastChar + binaryString.substring(0, binaryString.length() - 1);
        }

        return Integer.parseInt(binaryString, 2);

    }

    public static int rotateLeft(int n, int shift) {
        String binaryString = Integer.toBinaryString(n);

        for (int i = 0; i < shift; i++) {
            char firstChar = binaryString.charAt(0);
            binaryString = binaryString.substring(1) + firstChar;
        }

        return Integer.parseInt(binaryString, 2);
    }
}
