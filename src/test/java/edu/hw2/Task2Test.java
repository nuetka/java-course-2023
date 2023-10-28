package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect.setWidth(20);
        rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(200);
    }

    @Test
    void squareArea() {
        Square square1 = new Square();
        square1.setSideLength(10);
        Assertions.assertThat(square1.area()).isEqualTo(100);

    }
}
