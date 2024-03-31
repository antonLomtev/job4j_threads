package org.example.logg;

import org.example.logg.level_log.LevelLog;

import java.util.List;

public class Console implements Appender {

    @Override
    public void append(String text, LogLvl lvlLog) {
            System.out.printf("[%s] %s\n", lvlLog.toString(), text);
    }
}
