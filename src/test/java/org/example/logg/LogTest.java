package org.example.logg;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

class LogTest {
    @Test
    void whenSendMessageConsoleDebug() throws IOException {
        try (FileWriter writer = new FileWriter(Path.of("src/main/resources/log.properties").toFile())) {
            writer.write("appender=console" + System.lineSeparator() + "level=debug");
        }
        Logger logger = Log.getInstance();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        logger.debug("debug message");
        assertThat(out.toString()).isEqualTo("[DEBUG] debug message\n");
    }

    @Test
    void whenSendMessageToFileDebug() throws IOException {
        try (FileWriter writer = new FileWriter(Path.of("src/main/resources/log.properties").toFile())) {
            writer.write("appender=file" + System.lineSeparator() + "level=debug");
        }
        Logger logger = Log.getInstance();
        logger.debug("debug message to file");
        File file = Paths.get("logs/log.txt").toFile();
        assertThat(Files.readString(file.toPath())).contains("[DEBUG] debug message to file");
    }

    @Test
    void whenNotLvlLogThenLvlTrace() throws IOException {
        try (FileWriter writer = new FileWriter(Path.of("src/main/resources/log.properties").toFile())) {
            writer.write("appender=console");
        }
        Logger logger = Log.getInstance();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        logger.debug("debug message");
        logger.info("info message");
        logger.trace("trace message");
        assertThat(out.toString()).contains("[INFO] info message")
                .contains("[DEBUG] debug message")
                .contains("[TRACE] trace message");
    }
}