package model.database;

import model.database.filemanager.FileManagerStrategy;

import java.util.Set;

public abstract class DB<T> {
    protected final FileManagerStrategy<T> fileManagerStrategy;
    protected final Set<T> items;

    protected DB(FileManagerStrategy<T> fileManager, Set<T> items) {
        this.fileManagerStrategy = fileManager;
        this.items = items;
        load();
    }

    public Set<T> getAll() {
        return items;
    }

    public void load() {
        items.addAll(fileManagerStrategy.load());
    }

    public void save() {
        fileManagerStrategy.save(items);
    }
}
