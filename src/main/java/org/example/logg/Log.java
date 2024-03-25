package org.example.logg;

import java.util.List;

public class Log implements Logger {

    private static List<Appender> appenders;
    private static final String PATH_TO_FILE = "console,file";
    public static Log getInstance() {
        ReadProperties readProperties = new ReadPropertiesLocale();
        appenders = readProperties.read(PATH_TO_FILE);
        return new Log();
    }
    @Override
    public void error(String text) {
        save(text);
    }

    @Override
    public void warning(String text) {
        save(text);
    }
    private void save(String text) {
        for (Appender a : appenders) {
            a.saveLog(text);
        }
    }
}
