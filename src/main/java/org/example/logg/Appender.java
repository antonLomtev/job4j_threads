package org.example.logg;


import java.util.List;

public interface Appender {
    void saveLog(String text, List<LevelLog> levelLogs);
}
