package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

public class DiskMap implements Map<String, String> {

    private static final Logger LOGGER = Logger.getLogger(DiskMap.class.getName());

    private final String filePath;
    private final Map<String, String> map;

    public DiskMap(String filePath) {
        this.filePath = filePath;
        this.map = new HashMap<>();
        loadFromFile();
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(":", 2);
                map.put(keyValue[0], keyValue[1]);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load data from file: ", e);
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to save data to file: ", e);
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Override
    public String put(String key, String value) {
        String oldValue = map.put(key, value);
        saveToFile();
        return oldValue;
    }

    @Override
    public String remove(Object key) {
        String oldValue = map.remove(key);
        saveToFile();
        return oldValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        map.putAll(m);
        saveToFile();
    }

    @Override
    public void clear() {
        map.clear();
        saveToFile();
    }

    @Override
    public @NotNull Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public @NotNull Collection<String> values() {
        return map.values();
    }

    @Override
    public @NotNull Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }
}
