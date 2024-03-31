package org.example.logg;

import org.example.logg.level_log.LevelLog;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class File implements Appender {
    private String path;

    public File(String path) {
        this.path = path;
    }

    @Override
    public void append(String text, LogLvl lvlLog) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.write(String.format("[%s] %s\n", lvlLog.toString(), text));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}