package org.example.logg;

public class App {
    public static void main(String[] args) {
        Logger log = Log.getInstance();
        log.error("error");
        log.warning("warning");
    }
}
