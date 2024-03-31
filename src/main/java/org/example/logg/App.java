package org.example.logg;

public class App {
    public static void main(String[] args) {
        Logger log = Log.getInstance();
        log.info("test info");
        log.error("errr i");
        log.warning("test2");
    }
}
