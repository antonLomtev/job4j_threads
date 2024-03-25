package org.example.logg;

public class Warning implements LevelLog {

    private static final String NAME = "[warning]";
    @Override
    public String getLevelLog() {
        return NAME;
    }
}
