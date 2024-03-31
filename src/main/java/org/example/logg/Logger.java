package org.example.logg;

import org.example.logg.level_log.LevelLog;

public interface Logger {
    void log(String text, LevelLog lvlLog);
    void error(String message);
    void warning(String message);
    void trace(String message);
    void debug(String message);
    void info(String message);
}
