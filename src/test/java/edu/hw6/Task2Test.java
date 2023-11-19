package edu.hw6;

import edu.hw6.Task2.FileCloner;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {

    @Test
    public void testCloneFile() throws IOException {
        Path path = Paths.get("C:\\Users\\Sweety\\IdeaProjects\\java-course-2023\\src\\test\\java\\edu\\hw6\\data.txt");
        Path clonedPath = FileCloner.cloneFile(path);

        assertTrue(Files.exists(clonedPath.toAbsolutePath()));
        assertEquals(Files.size(path), Files.size(clonedPath));
    }

    @Test
    public void testGetNewPath() {
        Path path = Paths.get("C:\\Users\\Sweety\\IdeaProjects\\java-course-2023\\src\\test\\java\\edu\\hw6\\data.txt");
        Path newPath = FileCloner.getNewPath(path);

        assertEquals("C:\\Users\\Sweety\\IdeaProjects\\java-course-2023\\src\\test\\java\\edu\\hw6\\data — копия (1).txt", newPath.toString());
    }
}
