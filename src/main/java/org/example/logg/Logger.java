package org.example.logg;


public interface Logger {

    void log(String text, LogLvl lvlLog);

    void error(String message);

    void warning(String message);

    void trace(String message);

    void debug(String message);

    void info(String message);
}
