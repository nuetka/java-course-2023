package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class AbstractDateParser implements DateParser {
    private DateParser next;

    @Override
    public void setNext(DateParser parser) {
        this.next = parser;
    }

    protected Optional<LocalDate> next(String string) {
        if (next == null) {
            return Optional.empty();
        }
        return next.parse(string);
    }
}
