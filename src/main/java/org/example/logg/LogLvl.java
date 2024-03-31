package org.example.logg;

public enum LogLvl {
    ERROR("ERROR"),
    WARNING("WARNING"),
    INFO("INFO"),
    DEBUG("DEBUG"),
    TRACE("TRACE");

    private String lvlName;

    LogLvl(String lvlName) {
        this.lvlName = lvlName;
    }

    @Override
    public String toString() {
        return this.lvlName;
    }
}
