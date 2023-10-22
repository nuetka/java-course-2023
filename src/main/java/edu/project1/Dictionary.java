package edu.project1;

import java.util.List;
import java.util.Random;

public class Dictionary {
    private final List<String> words;

    Dictionary(List<String> words) {
        if (words.isEmpty()) {
            throw new IllegalArgumentException("Пустой список!");
        }
        this.words = words;
    }

    public String randomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
