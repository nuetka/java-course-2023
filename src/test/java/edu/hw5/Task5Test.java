package edu.hw5;

import edu.hw5.Task3.parseDateClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @ParameterizedTest
    @CsvSource({
        "A123BE777, true",
        "O777OO177, true",
        "123АВЕ777, false",
        "А123ВГ77, false",
        "А123ВЕ7777, false"

    })
    public void test(String str, Boolean b) {
        assertThat(Task5.number(str)).isEqualTo(b);

    }

}
