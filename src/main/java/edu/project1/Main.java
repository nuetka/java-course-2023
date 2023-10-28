package edu.project1;

import java.util.Arrays;
import java.util.List;

public class Main {

    private Main() {

    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("daisy", "gggg");
        ConsoleHangman game = new ConsoleHangman();
        game.run(words);
    }

}
