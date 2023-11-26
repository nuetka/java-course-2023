package edu.hw7;

import edu.hw7.Task2.FactorialCalculator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    public void test() {
        assertThat(FactorialCalculator.run(5)).isEqualTo(120);
    }
}
