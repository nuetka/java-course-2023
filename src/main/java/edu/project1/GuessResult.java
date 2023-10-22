package edu.project1;

public abstract class GuessResult {
    protected char[] state;
    protected String message;

    public char[] getState() {
        return state;
    }


    public String getMessage() {
        return message;
    }

    public static class Defeat extends GuessResult {
        public Defeat(char[] state) {
            this.state = state;
            this.message = "You lost!";
        }
    }

    public static class Win extends GuessResult {
        public Win(char[] state) {
            this.state = state;
            this.message =  "You won!";
        }
    }

    public static class SuccessfulGuess extends GuessResult {
        public SuccessfulGuess(char[] state) {
            this.state = state;
            this.message = "Hit!";
        }
    }

    public static class FailedGuess extends GuessResult {
        public FailedGuess(char[] state, int attempts, int maxAttempts) {
            this.state = state;
            this.message = "Missed, mistake " + attempts + " out of " + maxAttempts + ".";
        }
    }
}
