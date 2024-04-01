package org.example.logg;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ReadPropertiesLocale implements ReadProperties {
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
    public int readMinLevelLog(String path) {
        int minLvl = 0;
        if(!rProp(path, "level").get(0).isEmpty()) {
            String s = rProp(path, "level").get(0).toString().toUpperCase();
            LogLvl logLvl = LogLvl.valueOf(s);
            minLvl = logLvl.getLvl();
        }
        return minLvl;
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
