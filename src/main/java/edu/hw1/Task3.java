package edu.hw1;

import java.util.Arrays;

public class Task3 {
    private Task3() {

    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }
        int min1 = Arrays.stream(arr1).min().orElse(Integer.MAX_VALUE);
        int min2 = Arrays.stream(arr2).min().orElse(Integer.MAX_VALUE);
        int max1 = Arrays.stream(arr1).max().orElse(Integer.MIN_VALUE);
        int max2 = Arrays.stream(arr2).max().orElse(Integer.MIN_VALUE);

        return min1 > min2 && max1 < max2;
    }
}
