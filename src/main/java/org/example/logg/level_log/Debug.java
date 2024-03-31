package org.example.logg.level_log;

public class Debug extends AbstractLevelLog {

    public Debug(String name) {
        super(name);
    }

    @Override
    public String getLevelLog() {
        return getName().equals("debug") ? "debug" : "";
    }
}
