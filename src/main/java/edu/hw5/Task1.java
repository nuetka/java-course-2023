package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    private Task1() {
    }

    public static String clubAnalytics(String[] sessions) {
        final int MIN = 60;
        Duration totalDuration = Duration.ZERO;
        int sessionCount = 0;
        for (String session : sessions) {
            String[] parts = session.split(" - ");
            LocalDateTime startTime = parseDateTime(parts[0]);
            LocalDateTime endTime = parseDateTime(parts[1]);
            Duration sessionDuration = Duration.between(startTime, endTime);
            totalDuration = totalDuration.plus(sessionDuration);
            sessionCount++;
        }
        Duration averageDuration = totalDuration.dividedBy(sessionCount);
        return averageDuration.toHours() + "ч " + averageDuration.toMinutes() % MIN + "м";
    }

    private static LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

}


