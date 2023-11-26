package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    private Task7() {

    }

    private static final Pattern PATTERN1 = Pattern.compile("^[01]{2}0.*$");

    public static boolean task1(String s) {
        Matcher matcher = PATTERN1.matcher(s);
        return matcher.matches();
    }

    private static final Pattern PATTERN2 = Pattern.compile("^(.).*\\1$");

    public static boolean task2(String s) {
        Matcher matcher = PATTERN2.matcher(s);
        return matcher.matches();
    }

    private static final Pattern PATTERN3 = Pattern.compile("^[01]{1,3}$");

    public static boolean task3(String s) {
        Matcher matcher = PATTERN3.matcher(s);
        return matcher.matches();
    }

}
