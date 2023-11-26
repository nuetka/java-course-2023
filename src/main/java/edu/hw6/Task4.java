package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Task4 {

    private Task4() {

    }

    public static void task4() throws IOException {

        // Задаём путь к файлу
        Path path = Paths.get("output.txt");

        // Используем try-with-resources для автоматического закрытия потоков
        try (
            // Создание потока вывода в файл
            OutputStream fileOutputStream = Files.newOutputStream(path);

            // Создание CheckedOutputStream с алгоритмом подсчёта контрольной суммы Adler32
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());

            // Создание BufferedOutputStream для оптимизации записи
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);

            // Создание OutputStreamWriter для перевода символов в байты с использованием UTF-8
            Writer writer = new OutputStreamWriter(bufferedOutputStream, "UTF-8");

            // Создание PrintWriter для удобной печати строк
            PrintWriter printWriter = new PrintWriter(writer);
        ) {
            // Запись строки
            printWriter.print("Programming is learned by writing programs. ― Brian Kernighan");
        }
    }
}
