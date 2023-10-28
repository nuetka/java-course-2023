package edu.project1;

import java.util.Arrays;

public class Session {
    private static final int MAX_ATTEMPTS = 5;
    private final String answer;
    private final char[] userAnswer;
    private int attempts;

    public Session(String answer) {

        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("В заданной строке обнаружены небуквенные символы.");
            }
        }

        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
    }

    public String getAnswer() {
        return answer;
    }

    public GuessResult guess(char guess) {
        if (answer.indexOf(guess) != -1) {
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == guess) {
                    userAnswer[i] = guess;
                }
            }

            if (new String(userAnswer).equals(answer)) {
                return new GuessResult.Win(userAnswer);
            } else {
                return new GuessResult.SuccessfulGuess(userAnswer);
            }

        } else {
            attempts++;

            if (attempts >= MAX_ATTEMPTS) {
                return new GuessResult.Defeat(userAnswer);
            } else {
                return new GuessResult.FailedGuess(userAnswer, attempts, MAX_ATTEMPTS);
            }
        }
    }
}
