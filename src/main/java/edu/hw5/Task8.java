package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {

    private Task8() {
    }

    public static boolean task1(String s) {

        String pattern = "^(0|1){2}((0|1){2})*(0|1)$";
        return Pattern.matches(pattern, s);

    }

    public static boolean task2(String s) {

        String pattern = "^(0(0|1){2})+|(1(0|1){2})+(0|1)$";
        return Pattern.matches(pattern, s);

    }

    public static boolean task3(String s) {

        String pattern = "^(1*01*01*0)*1*$";
        return Pattern.matches(pattern, s);

    }

    public static boolean task4(String s) {

        String pattern = "^(?!11$)(?!111$).*";
        return Pattern.matches(pattern, s);

    }

    public static boolean task5(String s) {

        String pattern = "^(.?.1)*$";
        return Pattern.matches(pattern, s);

    }

    public static boolean task6(String s) {

        String pattern = "^(1*0){2,}1{0,1}$";
        return Pattern.matches(pattern, s);

    }

    public static boolean task7(String s) {

        String pattern = "^(0|10)*$";
        return Pattern.matches(pattern, s);

    }
}
