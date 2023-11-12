package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @ParameterizedTest
    @CsvSource({
        "100, true",
        "0001, false",

    })
    public void test1(String str, Boolean b) {
        assertThat(Task8.task1(str)).isEqualTo(b);

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
        "0001111, true",
        "11000000, true",
        "10011, false",

    })
    public void test3(String str, Boolean b) {
        assertThat(Task8.task3(str)).isEqualTo(b);

    }

    @ParameterizedTest
    @CsvSource({
        "1000001, true",
        "11, false",
        "111, false",

    })
    public void test4(String str, Boolean b) {
        assertThat(Task8.task4(str)).isEqualTo(b);

    }

    @ParameterizedTest
    @CsvSource({
        "1010101, true",
        "10000000001, false",

    })
    public void test5(String str, Boolean b) {
        assertThat(Task8.task5(str)).isEqualTo(b);

    }

    @ParameterizedTest
    @CsvSource({
        "100000, true",
        "0000, true",
        "001111, false",

    })
    public void test6(String str, Boolean b) {
        assertThat(Task8.task6(str)).isEqualTo(b);

    }

    @ParameterizedTest
    @CsvSource({
        "1000001000, true",
        "011, false",

    })
    public void test7(String str, Boolean b) {
        assertThat(Task8.task7(str)).isEqualTo(b);

    }


}
