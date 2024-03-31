package org.example.logg;

import org.example.logg.level_log.*;
import org.example.logg.level_log.Error;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ReadPropertiesLocale implements  ReadProperties {
    @Override
    public List<Appender> readAppenders(String path) {
        List<Appender> appenders = new ArrayList<>();
        for (String s : rProp(path, "appender")) {
            if ("file".equals(s)) {
                appenders.add(new File("logs/log.txt"));
            } else if ("console".equals(s)) {
                appenders.add(new Console());
            }
        }
        return appenders;
    }

    @Override
    public List<LogLvl> readLevelLog(String path) {
        List<LogLvl> logs = new ArrayList<>();
        for (String s : rProp(path, "level")) {
            if ("error".equals(s)) {
                logs.add(LogLvl.ERROR);
            } else if ("warning".equals(s)) {
                logs.add(LogLvl.WARNING);
            } else if ("debug".equals(s)) {
                logs.add(LogLvl.DEBUG);
            } else if ("info".equals(s)) {
                logs.add(LogLvl.INFO);
            } else if ("trace".equals(s)) {
                logs.add(LogLvl.TRACE);
            }
        }
        return logs;
    }

    private List<String> rProp(String path, String name) {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream(path)) {
            properties.load(in);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        String[] propertySave = properties.getProperty(name).split(",");
        return Arrays.stream(propertySave).collect(Collectors.toList());
    }
}
