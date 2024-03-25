package org.example.logg;

public class Console implements Appender {

    @Override
    public void saveLog() {
        System.out.println("console");
    }
}
