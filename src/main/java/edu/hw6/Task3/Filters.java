package edu.hw6.Task3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.PathMatcher;

public class Filters {

    private Filters() {

    }

    public static AbstractFilter regularFile() {
        return path -> Files.isRegularFile(path);
    }

    public static AbstractFilter readable() {
        return path -> Files.isReadable(path);
    }

    public static AbstractFilter largerThan(long size) {
        return path -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    public static AbstractFilter magicNumber(byte... magicNumbers) {
        return path -> {
            try {
                byte[] data = Files.readAllBytes(path);
                if (data.length < magicNumbers.length) {
                    return false;
                }

                for (int i = 0; i < magicNumbers.length; i++) {
                    if (data[i] != magicNumbers[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                throw new UncheckedIOException(e); // Or handle it in your preferred way
            }
        };
    }

    public static AbstractFilter globMatches(String globPattern) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + globPattern);
        return path -> matcher.matches(path.getFileName());
    }

    public static AbstractFilter regexContains(String regex) {
        return path -> path.getFileName().toString().matches(regex);
    }
}
