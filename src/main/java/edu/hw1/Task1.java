package edu.hw1;

public class Task1 {
    private static final int SECONDS_PER_MINUTE = 60;

    private Task1() {

    }

    public static int minutesToSeconds(String time) {
        String[] parts = time.split(":");
        if (parts.length != 2) {
            return -1;
        }
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(parts[0]);
            seconds = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (seconds >= SECONDS_PER_MINUTE) {
            return -1;
        }
        return minutes * SECONDS_PER_MINUTE + seconds;
    }
}
