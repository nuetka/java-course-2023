package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCloner {

    private FileCloner() {

    }

    public static Path cloneFile(Path path) throws IOException {
        Path newPath = getNewPath(path);
        Files.copy(path, newPath, StandardCopyOption.REPLACE_EXISTING);
        return newPath;
    }

    //CHECKSTYLE:OFF: MultipleStringLiterals
    public static Path getNewPath(Path path) {
        String fileName = path.getFileName().toString();
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        int i = 1;
        while (Files.exists(path.resolveSibling(baseName + " — копия (" + i + ")" + extension))) {
            i++;
        }
        return path.resolveSibling(baseName + " — копия (" + i + ")" + extension);
    }
    //CHECKSTYLE:ON: MultipleStringLiterals
}
