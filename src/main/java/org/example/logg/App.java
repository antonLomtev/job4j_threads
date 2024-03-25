package org.example.logg;

public class App {
    public static void main(String[] args) {
        Appender appender = new Console();
        Logger log = Log.getInstance(appender);
        log.error("error");
        log.warning("warning");
    }
}
