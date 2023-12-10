package edu.hw9.Task2;

import java.io.File;
import java.util.List;
import lombok.extern.java.Log;

@Log
public class Main {

    private Main() {

    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        File rootDirectory = new File("path/to/your/root/directory");
        FilesystemProcessor processor = new FilesystemProcessor();

        List<File> directoriesWithMoreThan1000Files = processor.findDirectoriesWithMoreThanNFiles(rootDirectory, 1000);
        log.info("Directories with more than 1000 files: " + directoriesWithMoreThan1000Files);

        FilePredicate sizeAndExtensionPredicate = file ->
            file.length() > 1024 * 1024 && file.getName().endsWith(".txt");

        List<File> filesMatchingPredicate = processor.findFilesWithPredicate(rootDirectory, sizeAndExtensionPredicate);
        log.info("Files matching the predicate: " + filesMatchingPredicate);
    }
}
