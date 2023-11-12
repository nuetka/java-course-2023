package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {

    @ParameterizedTest
    @CsvSource({
        "100, true",
        "1001, true",
        "O01, false",

    })
    public void test1(String str, Boolean b) {
        assertThat(Task7.task1(str)).isEqualTo(b);

    }

    @ParameterizedTest
    @CsvSource({
        "1000001, true",
        "11, true",
        "001, false",

    })
    public void test2(String str, Boolean b) {
        assertThat(Task7.task2(str)).isEqualTo(b);

    }

    @ParameterizedTest
    @CsvSource({
        "1, true",
        "011, true",
        "01, true",
        "0111, false",
        "01010101011010, false",

    })
    public void test3(String str, Boolean b) {
        assertThat(Task7.task3(str)).isEqualTo(b);

    }
}
