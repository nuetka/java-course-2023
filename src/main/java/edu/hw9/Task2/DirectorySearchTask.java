package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DirectorySearchTask extends RecursiveTask<List<File>> {
    private final File directory;
    private final int threshold;

    public DirectorySearchTask(File directory, int threshold) {
        this.directory = directory;
        this.threshold = threshold;
    }

    @Override
    protected List<File> compute() {
        List<File> result = new ArrayList<>();
        List<DirectorySearchTask> subtasks = new ArrayList<>();

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    DirectorySearchTask subtask = new DirectorySearchTask(file, threshold);
                    subtask.fork();
                    subtasks.add(subtask);
                } else {
                    result.add(file);
                }
            }
        }

        for (DirectorySearchTask subtask : subtasks) {
            result.addAll(subtask.join());
        }

        if (result.size() > threshold) {
            result.add(directory);
        }

        return result;
    }
}
