package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {

    private Task6() {
    }

    public static boolean isSubsequence(String s, String t) {
        String pattern = ".*" + String.join(".*", s.split("")) + ".*";
        return Pattern.matches(pattern, t);
    }
}
