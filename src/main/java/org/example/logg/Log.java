package org.example.logg;

import org.example.logg.level_log.Error;
import org.example.logg.level_log.Info;
import org.example.logg.level_log.LevelLog;
import org.example.logg.level_log.Warning;

import java.util.List;

public class Log implements Logger {

    private static List<Appender> appenders;
    private static List<LevelLog> levelLogs;
    private static final String PATH_TO_FILE = "src/main/resources/log.properties";
    public static Log getInstance() {
        ReadProperties readProperties = new ReadPropertiesLocale();
        appenders = readProperties.readAppenders(PATH_TO_FILE);
        levelLogs = readProperties.readLevelLog(PATH_TO_FILE);
        return new Log();
    }
    @Override
    public void log(String text, LevelLog lvlLog) {
        for (Appender a : appenders) {
            for (LevelLog l : levelLogs) {
                if (l.getLevelLog().equals(lvlLog.getLevelLog())) {
                    a.append(text, lvlLog);
                }
            }
        }
    }

    @Override
    public void error(String message) {
        log(message, new Error("error"));
    }

    @Override
    public void warning(String message) {
        log(message, new Warning("warning"));
    }

    @Override
    public void trace(String message) {

    }

    @Override
    public void debug(String message) {

    }

    @Override
    public void info(String message) {
        log(message, new Info("info"));
    }

    private void save(String text) {
    }
}
