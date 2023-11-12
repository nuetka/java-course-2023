package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task1 {

    private Task1() {

    }

    public static String clubAnalytics(String[] sessions) {

        final int MIN = 60;

        Duration totalDuration = Duration.ZERO;
        int sessionCount = 0;

        for (String session : sessions) {
            String[] parts = session.split(" - ");

            String[] startDateParts = parts[0].split(", ")[0].split("-");
            String[] startTimeParts = parts[0].split(", ")[1].split(":");
            int startYear = Integer.parseInt(startDateParts[0]);
            int startMonth = Integer.parseInt(startDateParts[1]);
            int startDay = Integer.parseInt(startDateParts[2]);
            int startHour = Integer.parseInt(startTimeParts[0]);
            int startMinute = Integer.parseInt(startTimeParts[1]);

            String[] endDateParts = parts[1].split(", ")[0].split("-");
            String[] endTimeParts = parts[1].split(", ")[1].split(":");
            int endYear = Integer.parseInt(endDateParts[0]);
            int endMonth = Integer.parseInt(endDateParts[1]);
            int endDay = Integer.parseInt(endDateParts[2]);
            int endHour = Integer.parseInt(endTimeParts[0]);
            int endMinute = Integer.parseInt(endTimeParts[1]);

            LocalDateTime startTime = LocalDateTime.of(startYear, startMonth, startDay, startHour, startMinute);
            LocalDateTime endTime = LocalDateTime.of(endYear, endMonth, endDay, endHour, endMinute);

            Duration sessionDuration = Duration.between(startTime, endTime);

            totalDuration = totalDuration.plus(sessionDuration);
            sessionCount++;
        }

        Duration averageDuration = totalDuration.dividedBy(sessionCount);

        return averageDuration.toHours() + "ч " + averageDuration.toMinutes() % MIN + "м";
    }

}


