package edu.hw1;

import java.util.logging.Logger;
import static edu.hw1.Task1.minutesToSeconds;
import static edu.hw1.Task2.countDigits;
import static edu.hw1.Task3.isNestable;
import static edu.hw1.Task4.fixString;

public final class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        sayHello();

    }

    public static void sayHello() {
        LOGGER.info("Привет, мир!");
    }

}


