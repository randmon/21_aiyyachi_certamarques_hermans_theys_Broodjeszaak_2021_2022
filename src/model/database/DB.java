package model.database;

import model.database.filemanager.FileManagerStrategy;

import java.util.Map;

public abstract class DB<T> {
    protected final FileManagerStrategy<T> fileManagerStrategy;
    protected final Map<String, T> items;

    protected DB(FileManagerStrategy<T> fileManager, Map<String, T> items) {
        this.fileManagerStrategy = fileManager;
        this.items = items;
        load();
    }

    public Map<String, T> getAll() {
        return items;
    }

    public void load() {
        items.putAll(fileManagerStrategy.load());
    }

    public void save() {
        fileManagerStrategy.save(items);
    }

    public abstract void setVoorraad(T item, int amount);
}
