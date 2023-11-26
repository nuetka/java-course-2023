package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    public void testComparator() {
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder()));
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();

    }
}
