package edu.project1;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleHangman {

    private static final Logger LOGGER = Logger.getLogger(ConsoleHangman.class.getName());

    public void run(List<String> words) {
        Dictionary dictionary = new Dictionary(words);
        Session session = new Session(dictionary.randomWord());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            LOGGER.info("Guess a letter:");
            String input = scanner.nextLine();

            if (input.equals("STOP")) {
                break;
            }

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                LOGGER.info("Invalid input. Try again.");
                continue;
            }

            GuessResult result = session.guess(input.charAt(0));
            LOGGER.info(result.getMessage());
            LOGGER.info("The word: " + new String(result.getState()));

            if (result instanceof GuessResult.Win || result instanceof GuessResult.Defeat) {
                break;
            }
        }

        LOGGER.info("Hidden word:" + session.getAnswer());
        scanner.close();
    }
}
