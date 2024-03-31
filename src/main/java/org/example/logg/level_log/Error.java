package org.example.logg.level_log;

public class Error extends AbstractLevelLog {

    public Error(String name) {
        super(name);
    }

    @Override
    public String getLevelLog() {
        return getName().equals("error") ? "error" : "";
    }
}
