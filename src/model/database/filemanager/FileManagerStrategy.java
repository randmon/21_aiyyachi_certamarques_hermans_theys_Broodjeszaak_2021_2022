package model.database.filemanager;

import java.util.Set;

public interface FileManagerStrategy<T> {
    Set<T> load();
    void save(Set<T> items);
}
