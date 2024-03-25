package org.example.logg;

public class Log implements Logger {

    Appender appender;

    public static Log getInstance(Appender appender) {

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
