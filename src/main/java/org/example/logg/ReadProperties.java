package org.example.logg;


import java.util.List;

public interface ReadProperties<T> {

    List<T> readAppenders(String path);

    int readMinLevelLog(String path);
}
