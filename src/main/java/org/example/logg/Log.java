package org.example.logg;


import java.util.List;

public class Log implements Logger {

    private static List<Appender> appenders;
    private static List<LogLvl> levelLogs;
    private static final String PATH_TO_FILE = "src/main/resources/log.properties";

    public static Log getInstance() {
        ReadProperties readProperties = new ReadPropertiesLocale();
        appenders = readProperties.readAppenders(PATH_TO_FILE);
        levelLogs = readProperties.readLevelLog(PATH_TO_FILE);
        return new Log();
    }

    @Override
    public void log(String text, LogLvl lvlLog) {
        for (Appender a : appenders) {
            for (LogLvl l : levelLogs) {
                if (l.toString().equals(lvlLog.toString())) {
                    a.append(text, lvlLog);
                }
            }
        }
    }

    @Override
    public void error(String message) {
        log(message, LogLvl.ERROR);
    }

    @Override
    public void warning(String message) {
        log(message, LogLvl.WARNING);
    }

    @Override
    public void trace(String message) {
        log(message, LogLvl.TRACE);
    }

    @Override
    public void debug(String message) {
        log(message, LogLvl.DEBUG);
    }

    @Override
    public void info(String message) {
        log(message, LogLvl.INFO);
    }
}
