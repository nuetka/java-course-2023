package edu.hw1;

import java.util.logging.Logger;

public final class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private Main() {
        throw new UnsupportedOperationException("Создание экземпляра утилитного класса не поддерживается.");
    }

    public static void main(String[] args) {

        sayHello();

    }

    public static void sayHello() {
        LOGGER.info("Привет, мир!");
    }

}


