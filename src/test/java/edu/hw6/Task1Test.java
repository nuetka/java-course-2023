package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    private DiskMap diskMap;
    private static final String FILE_PATH = "C:\\Users\\Sweety\\IdeaProjects\\java-course-2023\\src\\test\\java\\edu\\hw6\\data.txt";

    @BeforeEach
    void setUp() {
        diskMap = new DiskMap(FILE_PATH);
    }

    @AfterEach
    void tearDown() {
        diskMap.clear();
    }

    @Test
    void put() {
        assertNull(diskMap.put("key1", "value1"));
        assertEquals("value1", diskMap.get("key1"));
    }

    @Test
    void remove() {
        diskMap.put("key1", "value1");
        assertEquals("value1", diskMap.remove("key1"));
        assertNull(diskMap.get("key1"));
    }

    @Test
    void putAll() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");

        diskMap.putAll(data);

        assertEquals("value1", diskMap.get("key1"));
        assertEquals("value2", diskMap.get("key2"));
    }

    @Test
    void clear() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        diskMap.clear();

        assertTrue(diskMap.isEmpty());
    }

    @Test
    void testDataPersistence() throws IOException {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        DiskMap diskMap2 = new DiskMap(FILE_PATH);

        assertEquals("value1", diskMap2.get("key1"));
        assertEquals("value2", diskMap2.get("key2"));
    }
}
