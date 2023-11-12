package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class ParseDateClass {

    private ParseDateClass() {
    }

    public static Optional<LocalDate> parseDate(String str) {
        DateParser parser = new FormatDateParser("yyyy-MM-dd");
        DateParser nextParser = new FormatDateParser("d/M/yyyy");
        DateParser shortYearParser = new FormatDateParser("d/M/yy");
        DateParser wordParser = new WordDateParser();
        DateParser daysAgoParser = new DaysAgoDateParser();

        parser.setNext(nextParser);
        nextParser.setNext(shortYearParser);
        shortYearParser.setNext(wordParser);
        wordParser.setNext(daysAgoParser);

        return parser.parse(str);
    }
}
