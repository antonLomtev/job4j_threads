package org.example.logg;

public class Console implements Appender {

    @Override
    public void saveLog(String text) {
        System.out.println("console " + text);
    }
}
