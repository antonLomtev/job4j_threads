package org.example.logg;

public enum LogLvl {
    ERROR(40, "ERROR"),
    WARNING(30, "WARNING"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private String lvlName;
    private int lvl;

    LogLvl(int lvl, String lvlName) {
        this.lvlName = lvlName;
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return this.lvlName;
    }
    public int getLvl() {
        return this.lvl;
    }
}
