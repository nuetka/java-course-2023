package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    void testFreqDict1() {
        String[] inputArray = {"a", "bb", "a", "bb"};
        Map<String, Integer> expectedMap = Map.of("bb", 2, "a", 2);
        assertThat(Task3.freqDict(Arrays.asList(inputArray))).isEqualTo(expectedMap);
    }

    @Test
    void testFreqDict2() {
        String[] inputArray = {"this", "and", "that", "and"};
        Map<String, Integer> expectedMap = Map.of("that", 1, "and", 2, "this", 1);
        assertThat(Task3.freqDict(Arrays.asList(inputArray))).isEqualTo(expectedMap);
    }

    @Test
    void testFreqDict3() {
        String[] inputArray = {"код", "код", "код", "bug"};
        Map<String, Integer> expectedMap = Map.of("код", 3, "bug", 1);
        assertThat(Task3.freqDict(Arrays.asList(inputArray))).isEqualTo(expectedMap);
    }

    @Test
    void testFreqDict4() {
        Integer[] inputArray = {1, 1, 2, 2};
        Map<Integer, Integer> expectedMap = Map.of(1, 2, 2, 2);
        assertThat(Task3.freqDict(Arrays.asList(inputArray))).isEqualTo(expectedMap);
    }
}
