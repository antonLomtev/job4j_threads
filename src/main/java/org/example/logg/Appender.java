package org.example.logg;

public interface Appender {
    void append(String text, LogLvl lvlLog);
}
