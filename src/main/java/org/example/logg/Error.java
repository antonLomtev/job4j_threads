package org.example.logg;

public class Error implements LevelLog {
    private static final String NAME = "[error]";

    @Override
    public String getLevelLog() {
        return NAME;
    }
}
