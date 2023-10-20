package edu;

import edu.hw1.Task1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({
        "01:00, 60",
        "13:56, 836",
        "999:59, 59999"
    })
    public void testValidTime(String time, int expectedSeconds) {
        assertThat(Task1.minutesToSeconds(time)).isEqualTo(expectedSeconds);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10:60", "12:61", "abc:def", "5", "12:", ":44"})
    public void testInvalidTime(String time) {
        assertThat(Task1.minutesToSeconds(time)).isEqualTo(-1);
    }

    @ParameterizedTest
    @CsvSource({
        "00:00, 0",
        "0:59, 59",
        "0:01, 1"
    })
    public void testEdgeCases(String time, int expectedSeconds) {
        assertThat(Task1.minutesToSeconds(time)).isEqualTo(expectedSeconds);
    }

}
