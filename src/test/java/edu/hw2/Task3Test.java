package edu.hw2;

import edu.hw2.task3.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import static org.assertj.core.api.Assertions.*;

public class Task3Test {
    private static final int MAX_ATTEMPTS = 5;



    @RepeatedTest(MAX_ATTEMPTS)
    void whenStableConnection_thenCommandAlwaysExecutesSuccessfully(RepetitionInfo repetitionInfo) {
        ConnectionManager manager =
            new DefaultConnectionManager(); // Допустим, DefaultConnectionManager обычно предоставляет StableConnection
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, MAX_ATTEMPTS);

        assertThatCode(() -> executor.tryExecute("ls"))
            .as("Attempt: " + repetitionInfo.getCurrentRepetition()) // Это добавлено для отображения текущей попытки
        //assertThatCode(() -> executor.tryExecute("ls"))
            .doesNotThrowAnyException();

    }


@RepeatedTest(MAX_ATTEMPTS)
void whenFaultyConnectionAndMaxAttemptsExceeded_thenConnectionExceptionIsThrown(RepetitionInfo repetitionInfo) {
    ConnectionManager manager = new FaultyConnectionManager();
    PopularCommandExecutor executor = new PopularCommandExecutor(manager, MAX_ATTEMPTS);

    assertThatThrownBy(() -> executor.tryExecute("ls"))
        .as("Attempt: " + repetitionInfo.getCurrentRepetition())  // Это добавлено для отображения текущей попытки
        .isInstanceOf(ConnectionException.class)
        .hasCauseInstanceOf(ConnectionException.class); // проверяем, что исключение содержит причину в виде ConnectionException
}
}

