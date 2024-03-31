package org.example.logg;


import java.util.List;

public interface ReadProperties<T> {

    List<T> readAppenders(String path);

    List<T> readLevelLog(String path);
}
