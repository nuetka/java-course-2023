package edu.project1;

import java.util.List;

public class Main {

    private Main() {

    }

    public static void main(String[] args) {
        List<String> words = List.of("daisy");
        ConsoleHangman game = new ConsoleHangman();
        game.run(words);
    }

}
