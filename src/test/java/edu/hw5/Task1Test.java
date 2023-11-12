package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {


    @Test
    public void testTask1() {
        String[] sessions = {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        };

        assertThat(Task1.clubAnalytics(sessions)).isEqualTo("3ч 40м");
    }

}
