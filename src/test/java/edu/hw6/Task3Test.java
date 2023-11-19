package edu.hw6;

import edu.hw6.Task3.Filters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @TempDir
    static Path tempDir;

    @Test
    public void testLargerThan() throws Exception {
        Path largeFile = tempDir.resolve("largefile.txt");
        Files.write(largeFile, new byte[100_001]);

        Path smallFile = tempDir.resolve("smallfile.txt");
        Files.write(smallFile, new byte[100_000]);

        assertThat(Filters.largerThan(100_000).accept(largeFile)).isTrue();
        assertThat(Filters.largerThan(100_000).accept(smallFile)).isFalse();
    }

    @Test
    public void testGlobMatches() throws Exception {
        Path pngFile = tempDir.resolve("file.png");
        Files.createFile(pngFile);

        Path txtFile = tempDir.resolve("file.txt");
        Files.createFile(txtFile);

        assertThat(Filters.globMatches("*.png").accept(pngFile)).isTrue();
        assertThat(Filters.globMatches("*.png").accept(txtFile)).isFalse();
    }

    @Test
    public void testRegexContains() throws Exception {
        Path pathWithDash = tempDir.resolve("file-with-dash.txt");
        Files.createFile(pathWithDash);

        Path pathWithoutDash = tempDir.resolve("filewithoutdash.txt");
        Files.createFile(pathWithoutDash);

        assertThat(Filters.regexContains(".*[-]+.*").accept(pathWithDash)).isTrue();
        assertThat(Filters.regexContains(".*[-]+.*").accept(pathWithoutDash)).isFalse();
    }

    @Test
    public void testMagicNumber() throws Exception {
        Path fileWithMagicNumber = tempDir.resolve("magicfile.dat");
        Files.write(fileWithMagicNumber, new byte[]{ (byte)0x89, 'P', 'N', 'G' });

        Path fileWithoutMagicNumber = tempDir.resolve("normalfile.dat");
        Files.write(fileWithoutMagicNumber, new byte[]{ 'A', 'B', 'C' });

        assertThat(Filters.magicNumber((byte)0x89, (byte) 'P', (byte) 'N', (byte) 'G').accept(fileWithMagicNumber)).isTrue();
        assertThat(Filters.magicNumber((byte) 0x89, (byte) 'P', (byte) 'N', (byte) 'G').accept(fileWithoutMagicNumber)).isFalse();
    }
}

