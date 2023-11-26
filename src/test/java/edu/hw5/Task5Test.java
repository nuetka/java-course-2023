package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

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
