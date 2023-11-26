package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private Task5() {
    }

    private static final Pattern PATTERN = Pattern.compile("[A-Z]\\d{3}[A-Z]{2}\\d{3}");

    public static Boolean number(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }
}
