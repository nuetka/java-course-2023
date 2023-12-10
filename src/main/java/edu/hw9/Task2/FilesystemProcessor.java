package edu.hw9.Task2;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class FilesystemProcessor {
    private final ForkJoinPool forkJoinPool;

    public FilesystemProcessor() {
        this.forkJoinPool = new ForkJoinPool();
    }

    public List<File> findDirectoriesWithMoreThanNFiles(File rootDirectory, int n) {
        return forkJoinPool.invoke(new DirectorySearchTask(rootDirectory, n));
    }

    public List<File> findFilesWithPredicate(File rootDirectory, FilePredicate predicate) {
        return forkJoinPool.invoke(new FileSearchTask(rootDirectory, predicate));
    }
}
