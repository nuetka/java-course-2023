package edu.hw5;

import edu.hw5.Task3.ParseDateClass;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

//    @ParameterizedTest
//    @CsvSource({
//        "2020-10-10, 2020-10-10",
//        "2/12/2020, 2020-12-02",
//        "2/12/20, 2020-12-02",
//        "today, 2023-11-12",
//        "1 day ago, 2023-11-11",
//    })
//    public void test(String dateInput, String expectedOutput) {
//        LocalDate expectedDate = LocalDate.parse(expectedOutput, DateTimeFormatter.ISO_DATE);
//        LocalDate actualDate = ParseDateClass.parseDate(dateInput).orElse(null);
//        assertThat(actualDate).isEqualTo(expectedDate);
//    }
}
