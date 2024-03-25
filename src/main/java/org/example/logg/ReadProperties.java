package org.example.logg;

import java.util.List;

public interface ReadProperties {
    List<Appender> read(String path);
}
