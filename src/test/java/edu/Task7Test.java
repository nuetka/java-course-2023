package edu;

import edu.hw1.Task7;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    void testRight() {

        assertThat(Task7.rotateRight(8, 1)).isEqualTo(4);
        assertThat(Task7.rotateRight(1, 1)).isEqualTo(1);

    }

    @Test
    void testLeft() {
        assertThat(Task7.rotateLeft(16,1)).isEqualTo(1);
        assertThat(Task7.rotateLeft(17,2)).isEqualTo(6);


    }
}
