package org.example.logg;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File implements Appender {

    private String path;

    public File(String path) {
        this.path = path;
    }

    @Override
    public void append(String text, LogLvl lvlLog) {
        Path pathToFile = Paths.get(path);
        try {
            Files.createDirectories(pathToFile.getParent());
            if (Files.notExists(pathToFile)) {
                Files.createFile(pathToFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.write(String.format("[%s] %s\n", lvlLog.toString(), text));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}