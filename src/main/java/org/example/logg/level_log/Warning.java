package org.example.logg.level_log;

public class Warning extends AbstractLevelLog {

    public Warning(String name) {
        super(name);
    }

    @Override
    public String getLevelLog() {
        return getName().equals("warning") ? "warning" : "";
    }
}
