package org.example.logg;

import java.util.ArrayList;
import java.util.List;

public class ReadPropertiesLocale implements  ReadProperties {
    @Override
    public List<Appender> read(String path) {
        List<Appender> appenders = new ArrayList<>();
        System.out.println("Читаем app.properties");
        String[] appSave = path.split(",");
        for (String s : appSave) {
            if ("file".equals(s)) {
                appenders.add(new File());
            } else if ("console".equals(s)) {
                appenders.add(new Console());
            }
        }
        return appenders;
    }
}
