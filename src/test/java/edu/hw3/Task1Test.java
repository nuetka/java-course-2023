package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    public void testAtbashCipher() {
        String input1 = "Hello world!";
        String input2 =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";

        String expectedOutput1 = "Svool dliow!";
        String expectedOutput2 =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        assertThat(Task1.atbash(input1)).isEqualTo(expectedOutput1);
        assertThat(Task1.atbash(input2)).isEqualTo(expectedOutput2);
    }
}
