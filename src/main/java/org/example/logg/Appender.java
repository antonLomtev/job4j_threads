package org.example.logg;


import org.example.logg.level_log.LevelLog;

import java.util.List;

public interface Appender {
    void append(String text, LogLvl lvlLog);
}
