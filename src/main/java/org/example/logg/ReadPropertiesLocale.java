package org.example.logg;

public class ReadPropertiesLocale implements  ReadProperties {
    @Override
    public Appender read(String path) {
        System.out.println("Читаем app.properties");
        Appender appender = null;
        if ("console".equals(path)) {
            appender = new Console();
        } else if ("file".equals(path)) {
            appender = new File();
        }
        return appender;
    }
}
