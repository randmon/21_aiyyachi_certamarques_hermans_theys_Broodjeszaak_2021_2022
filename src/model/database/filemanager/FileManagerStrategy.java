package model.database.filemanager;

import java.util.Map;

public interface FileManagerStrategy<T> {
    Map<String, T> load();
    void save(Map<String, T> items);
}
