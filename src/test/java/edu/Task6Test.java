package edu;

import edu.hw1.Task6;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    void countSteps() {

        assertThat(Task6.countK(3524)).isEqualTo(3);
        assertThat(Task6.countK(6621)).isEqualTo(5);
        assertThat(Task6.countK(6554)).isEqualTo(4);
        assertThat(Task6.countK(1234)).isEqualTo(3);
        assertThat(Task6.countK(6174)).isEqualTo(0);
        assertThat(Task6.countK(352467)).isEqualTo(-1);
        assertThat(Task6.countK(0)).isEqualTo(-1);
    }

}
