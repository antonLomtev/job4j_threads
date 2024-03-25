package org.example.logg;

public class File implements Appender {
    @Override
    public void saveLog() {
        System.out.println("to file log");
    }
}
