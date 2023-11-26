package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class WordDateParser extends AbstractDateParser {
    @Override
    public Optional<LocalDate> parse(String string) {
        switch (string) {
            case "today":
                return Optional.of(LocalDate.now());
            case "tomorrow":
                return Optional.of(LocalDate.now().plusDays(1));
            case "yesterday":
                return Optional.of(LocalDate.now().minusDays(1));
            default:
                return next(string);
        }
    }
}
