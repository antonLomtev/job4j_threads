package org.example.logg;

public class Log implements Logger {

    private static Appender appender;
    private static final String PATH_TO_FILE = "console";
    public static Log getInstance() {
        ReadProperties readProperties = new ReadPropertiesLocale();
        appender = readProperties.read(PATH_TO_FILE);
        return new Log();
    }
    @Override
    public void error(String text) {
        appender.saveLog(text);
    }

    @Override
    public void warning(String text) {
        appender.saveLog(text);
    }
}
