package model.database;

import model.database.filemanager.FileManagerTemplate;

import java.util.Set;

public abstract class DB<T> {
    protected final FileManagerTemplate<T> fileManager;
    protected final Set<T> items;

    protected DB(FileManagerTemplate<T> fileManager, Set<T> items) {
        this.fileManager = fileManager;
        this.items = items;
        loadFromFile();
    }

    public Set<T> getAll() {
        return items;
    }

    public void loadFromFile() {
        items.addAll(fileManager.loadFromFile());
    }

    public void saveToFile() {
        fileManager.saveToFile(items);
    }
}
