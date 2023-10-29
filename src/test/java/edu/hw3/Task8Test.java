package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {

    @Test
    public void testBackwardIterator() {
        List<Integer> list = List.of(1, 2, 3);
        int num_index = list.size() - 1;
        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);

        while (iterator.hasNext()) {
            assertThat(iterator.next()).isEqualTo(list.get(num_index));
            num_index--;
        }

    }
}
