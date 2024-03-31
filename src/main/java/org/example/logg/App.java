package org.example.logg;

public class App {
    public static void main(String[] args) {
        Logger log = Log.getInstance();
        log.info("test info");
        log.error("test1");
        log.warning("test2");
    }
}
