package edu.hw2;

import edu.hw2.task1.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @Test
    public void testExpressionEvaluation() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var multi = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(multi, 2);
        var res = new Addition(exp, new Constant(1));

        assertThat(res.evaluate()).isEqualTo(37.0);

    }
}
