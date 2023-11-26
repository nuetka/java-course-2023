package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    public void testFileContentAndChecksum() throws IOException {
        // Задаем путь к ожидаемому файлу
        Path expectedPath = Paths.get("expected.txt");

        // Записываем ожидаемое содержимое в файл
        Files.write(expectedPath, "Programming is learned by writing programs. ― Brian Kernighan".getBytes());

        // Задаем путь к тестовому файлу
        Path outputPath = Paths.get("output.txt");

        // Вызываем код, который создает и записывает в файл строку
        Task4.task4();

        // Проверяем содержимое тестового файла
        assertThat(Files.readAllBytes(outputPath)).isEqualTo(Files.readAllBytes(expectedPath));

        // Удаляем созданные файлы
        Files.deleteIfExists(expectedPath);
        Files.deleteIfExists(outputPath);
    }
}
