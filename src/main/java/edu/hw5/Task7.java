package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {

    private Task7() {

    }

    public static boolean task1(String s) {

        String pattern = "^[01]{2}0.*$";
        return Pattern.matches(pattern, s);

    }

    public static boolean task2(String s) {

        String pattern = "^(.).*\\1$";
        return Pattern.matches(pattern, s);

    }

    public static boolean task3(String s) {

        String pattern = "^[01]{1,3}$";
        return Pattern.matches(pattern, s);

    }
}
