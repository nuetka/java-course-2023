package edu.hw7;

import edu.hw7.Task1.Counter;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    public void test() {
        assertThat(Counter.run()).isEqualTo(5000);
    }
}
