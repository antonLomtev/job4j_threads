package org.example.logg;

import java.util.List;

public interface ReadProperties {
    List<Appender> readAppenders(String path);
    List<LevelLog> readLevelLog(String path);
}
