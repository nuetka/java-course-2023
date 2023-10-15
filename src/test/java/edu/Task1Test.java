package edu;

import edu.hw1.Task1;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @Test
    public void testValidTime() {
        assertThat(Task1.minutesToSeconds("01:00")).isEqualTo(60);
        assertThat(Task1.minutesToSeconds("13:56")).isEqualTo(836);
        assertThat(Task1.minutesToSeconds("999:59")).isEqualTo(59999);
    }

    @Test
    public void testInvalidTime() {
        assertThat(Task1.minutesToSeconds("10:60")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("12:61")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("abc:def")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("5")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("12:")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds(":44")).isEqualTo(-1);
    }

    @Test
    public void testEdgeCases() {
        assertThat(Task1.minutesToSeconds("0:00")).isEqualTo(0);
        assertThat(Task1.minutesToSeconds("0:59")).isEqualTo(59);
        assertThat(Task1.minutesToSeconds("0:01")).isEqualTo(1);
    }
}
