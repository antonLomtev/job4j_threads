package org.example.logg.level_log;

public abstract class AbstractLevelLog implements LevelLog {
    private String name;

    public AbstractLevelLog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
