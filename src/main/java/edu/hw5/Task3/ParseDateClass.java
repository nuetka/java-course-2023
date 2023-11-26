package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class ParseDateClass {

    private ParseDateClass() {
    }

    private static final DateParser PARSER_CHAIN;

    static {
        DateParser parser = new FormatDateParser("yyyy-MM-dd");
        DateParser nextParser = new FormatDateParser("d/M/yyyy");
        DateParser shortYearParser = new FormatDateParser("d/M/yy");
        DateParser wordParser = new WordDateParser();
        DateParser daysAgoParser = new DaysAgoDateParser();

        parser.setNext(nextParser);
        nextParser.setNext(shortYearParser);
        shortYearParser.setNext(wordParser);
        wordParser.setNext(daysAgoParser);

        PARSER_CHAIN = parser;
    }

    public static Optional<LocalDate> parseDate(String str) {
        return PARSER_CHAIN.parse(str);
    }
}
