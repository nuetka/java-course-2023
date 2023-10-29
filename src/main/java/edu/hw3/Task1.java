package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {

    private Task1() {

    }

    public static String atbash(String input) {
        List<Character> result = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char mirroredChar = (char) (Character.isUpperCase(c) ? 'Z' - (c - 'A') : 'z' - (c - 'a'));
                result.add(mirroredChar);
            } else {
                result.add(c);
            }
        }
        return result.stream()
            .map(Object::toString)
            .collect(Collectors.joining());
    }
}
