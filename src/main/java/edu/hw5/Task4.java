package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    private Task4() {
    }

    private static final Pattern PATTERN = Pattern.compile(".*[~!@#$%^&*|].*");

    public static Boolean contains(String password) {
        Matcher matcher = PATTERN.matcher(password);
        return matcher.matches();
    }
}
