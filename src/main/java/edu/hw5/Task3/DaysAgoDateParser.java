package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaysAgoDateParser extends AbstractDateParser {
    private final Pattern pattern = Pattern.compile("(\\d+) days? ago");

    @Override
    public Optional<LocalDate> parse(String string) {
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            long daysAgo = Long.parseLong(matcher.group(1));
            LocalDate dayAgoDate = LocalDate.now().minusDays(daysAgo);
            return Optional.of(dayAgoDate);
        }

        return next(string);
    }
}
