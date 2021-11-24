package model.database.filemanager;

import java.util.Set;

public abstract class FileManagerTemplate<T> {
    protected String path;

    public FileManagerTemplate(String path) {
        setPath(path);
    }

    public abstract Set<T> loadFromFile();

    public abstract void saveToFile(Set<T> set);

    public void setPath(String path) {
        if (path == null || path.isEmpty()) throw new IllegalArgumentException("Path mag niet leeg zijn");
        this.path = path;
    }
}
