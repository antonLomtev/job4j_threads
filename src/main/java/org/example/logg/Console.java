package org.example.logg;

import java.util.List;

public class Console implements Appender {

    @Override
    public void saveLog(String text, List<LevelLog> levelLogs) {
        for (LevelLog l : levelLogs) {
            System.out.println(l.getLevelLog() + " console " + text);
        }
    }
}
