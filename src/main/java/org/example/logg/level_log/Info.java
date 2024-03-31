package org.example.logg.level_log;

public class Info extends AbstractLevelLog {

    public Info(String name) {
        super(name);
    }

    @Override
    public String getLevelLog() {
        return getName().equals("info") ? "info": "";
    }
}
