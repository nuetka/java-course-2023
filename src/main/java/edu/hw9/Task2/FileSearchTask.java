package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FileSearchTask extends RecursiveTask<List<File>> {
    private final File directory;
    private final FilePredicate predicate;

    public FileSearchTask(File directory, FilePredicate predicate) {
        this.directory = directory;
        this.predicate = predicate;
    }

    @Override
    protected List<File> compute() {
        List<File> result = new ArrayList<>();
        List<FileSearchTask> subtasks = new ArrayList<>();

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    FileSearchTask subtask = new FileSearchTask(file, predicate);
                    subtask.fork();
                    subtasks.add(subtask);
                } else {
                    if (predicate.test(file)) {
                        result.add(file);
                    }
                }
            }
        }

        for (FileSearchTask subtask : subtasks) {
            result.addAll(subtask.join());
        }

        return result;
    }
}
