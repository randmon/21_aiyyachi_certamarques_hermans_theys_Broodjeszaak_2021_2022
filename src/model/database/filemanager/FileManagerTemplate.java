package model.database.filemanager;

import java.util.TreeMap;

//Gebruikt template pattern
public abstract class FileManagerTemplate<T> {
    public abstract TreeMap<T, Integer> loadFromFile();
    public abstract void saveToFile(TreeMap<T, Integer> lijst);
}
