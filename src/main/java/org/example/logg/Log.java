package org.example.logg;

import java.util.List;

public class Log implements Logger {

    private static List<Appender> appenders;
    private static List<LevelLog> levelLogs;
    private static final String PATH_TO_FILE = "log.properties";
    public static Log getInstance() {
        ReadProperties readProperties = new ReadPropertiesLocale();
        appenders = readProperties.readAppenders(PATH_TO_FILE);
        levelLogs = readProperties.readLevelLog(PATH_TO_FILE);
        return new Log();
    }
    @Override
    public void log(String text) {
        save(text);
    }
    private void save(String text) {
        for (Appender a : appenders) {
            a.saveLog(text, levelLogs);
        }
    }
}
