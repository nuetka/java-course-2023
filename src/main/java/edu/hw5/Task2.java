package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private static final int DD = 13;

    private Task2() {

    }

    public static List<LocalDate> findFriday13s(int year) {
        List<LocalDate> friday13s = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 1);

        while (date.getYear() == year) {
            if (date.getDayOfMonth() == DD && date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                friday13s.add(date);
            }
            date = date.plusDays(1);
        }

        return friday13s;
    }

    public static LocalDate findNextFriday13(LocalDate date) {
        LocalDate nextDate = date;

        while (true) {

            nextDate = nextDate.withDayOfMonth(DD);

            if (nextDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                return nextDate;
            }

            nextDate = nextDate.with(TemporalAdjusters.firstDayOfNextMonth());
        }
    }
}
