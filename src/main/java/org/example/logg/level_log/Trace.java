package org.example.logg.level_log;

public class Trace extends AbstractLevelLog {

    public Trace(String name) {
        super(name);
    }

    @Override
    public String getLevelLog() {
        return getName().equals("trace") ? "trace" : "";
    }
}
