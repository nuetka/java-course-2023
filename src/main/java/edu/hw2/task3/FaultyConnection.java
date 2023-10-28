package edu.hw2.task3;

import java.util.Random;

public class FaultyConnection implements Connection {
    private static final int MAX_NUMBER = 100;
    //допустим что всегда выкидывается ошибка
    private static final int MAX_TRUE = 100;

    @Override
    public void execute(String command) {
        // Реализация выполнения команды для проблемного соединения
        // Иногда бросаем исключение ConnectionException
        if (shouldThrowException()) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() {
        // Реализация закрытия соединения для проблемного соединения
    }

    private boolean shouldThrowException() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER) < MAX_TRUE;

    }
}
