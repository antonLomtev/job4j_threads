package org.example.logg;

public class File implements Appender {
    @Override
    public void saveLog(String text) {
        System.out.println("to file log " + text);
    }
}
