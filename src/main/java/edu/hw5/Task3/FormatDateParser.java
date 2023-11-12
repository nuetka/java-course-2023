package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class FormatDateParser extends AbstractDateParser {
    private final DateTimeFormatter formatter;

    public FormatDateParser(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public Optional<LocalDate> parse(String string) {
        try {
            return Optional.of(LocalDate.parse(string, formatter));
        } catch (DateTimeParseException e) {
            return next(string);
        }
    }
}
