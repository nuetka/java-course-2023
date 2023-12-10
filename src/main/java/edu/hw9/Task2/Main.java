package edu.hw9.Task2;

import java.io.File;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        File rootDirectory = new File("path/to/your/root/directory");
        FilesystemProcessor processor = new FilesystemProcessor();

        List<File> directoriesWithMoreThan1000Files = processor.findDirectoriesWithMoreThanNFiles(rootDirectory, 1000);
        System.out.println("Directories with more than 1000 files: " + directoriesWithMoreThan1000Files);

        FilePredicate sizeAndExtensionPredicate = file ->
            file.length() > 1024 * 1024 && file.getName().endsWith(".txt");

        List<File> filesMatchingPredicate = processor.findFilesWithPredicate(rootDirectory, sizeAndExtensionPredicate);
        System.out.println("Files matching the predicate: " + filesMatchingPredicate);
    }
}
