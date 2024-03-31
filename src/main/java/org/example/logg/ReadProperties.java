package org.example.logg;

import org.example.logg.level_log.LevelLog;

import java.util.List;

public interface ReadProperties<T> {
    List<T> readAppenders(String path);
    List<T> readLevelLog(String path);
}
