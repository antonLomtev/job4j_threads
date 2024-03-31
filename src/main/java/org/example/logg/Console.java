package org.example.logg;

public class Console implements Appender {

    @Override
    public void append(String text, LogLvl lvlLog) {
            System.out.printf("[%s] %s\n", lvlLog.toString(), text);
    }
}
