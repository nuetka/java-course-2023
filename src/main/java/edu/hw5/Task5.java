package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {

    private Task5() {

    }

    public static Boolean number(String input) {
        String pattern = "[A-Z]\\d{3}[A-Z]{2}\\d{3}";
        return Pattern.matches(pattern, input);
    }
}
