package org.example.logg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadPropertiesLocale implements  ReadProperties {
    @Override
    public List<Appender> readAppenders(String path) {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream(path)) {
            properties.load(in);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        List<Appender> appenders = new ArrayList<>();
        String[] appSave = properties.getProperty("appender").split(",");
        for (String s : appSave) {
            if ("file".equals(s)) {
                appenders.add(new File());
            } else if ("console".equals(s)) {
                appenders.add(new Console());
            }
        }
        return appenders;
    }

    @Override
    public List<LevelLog> readLevelLog(String path) {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream(path)) {
            properties.load(in);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        List<LevelLog> logs = new ArrayList<>();
        String[] logSave = properties.getProperty("level").split(",");
        for (String s : logSave) {
            if ("error".equals(s)) {
                logs.add(new Error());
            } else if ("warning".equals(s)) {
                logs.add(new Warning());
            }
        }
        return logs;
    }
}
