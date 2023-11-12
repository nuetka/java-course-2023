package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                balance++;
            } else if (input.charAt(i) == ')') {
                balance--;
            }

            if (balance == 0) {
                clusters.add(input.substring(start, i + 1));
                start = i + 1;
            }
        }

        return clusters;
    }
}
