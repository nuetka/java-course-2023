package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    private Task8() {
    }

    private static final Pattern PATTERN1 = Pattern.compile("^(0|1){2}((0|1){2})*(0|1)$");

    public static boolean task1(String s) {
        Matcher matcher = PATTERN1.matcher(s);
        return matcher.matches();
    }

    private static final Pattern PATTERN2 = Pattern.compile("^(0(0|1){2})+|(1(0|1){2})+(0|1)$");

    public static boolean task2(String s) {
        Matcher matcher = PATTERN2.matcher(s);
        return matcher.matches();
    }

    private static final Pattern PATTERN3 = Pattern.compile("^(1*01*01*0)*1*$");

    public static boolean task3(String s) {
        Matcher matcher = PATTERN3.matcher(s);
        return matcher.matches();
    }

    private static final Pattern PATTERN4 = Pattern.compile("^(?!11$)(?!111$).*");

    public static boolean task4(String s) {
        Matcher matcher = PATTERN4.matcher(s);
        return matcher.matches();
    }

    private static final Pattern PATTERN5 = Pattern.compile("^(.?.1)*$");

    public static boolean task5(String s) {
        Matcher matcher = PATTERN5.matcher(s);
        return matcher.matches();
    }

    private static final Pattern PATTERN6 = Pattern.compile("^(1*0){2,}1{0,1}$");

    public static boolean task6(String s) {
        Matcher matcher = PATTERN6.matcher(s);
        return matcher.matches();
    }

    private static final Pattern PATTERN7 = Pattern.compile("^(0|10)*$");

    public static boolean task7(String s) {
        Matcher matcher = PATTERN7.matcher(s);
        return matcher.matches();
    }
}
