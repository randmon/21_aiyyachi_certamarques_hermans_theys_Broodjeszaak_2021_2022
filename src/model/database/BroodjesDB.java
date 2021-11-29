package model.database;

import model.database.filemanager.BroodjesFileManager;
import model.domain.Broodje;

import java.util.Comparator;
import java.util.TreeSet;

public class BroodjesDB extends DB<Broodje> {
    private static BroodjesDB instance;

    private BroodjesDB() {
        super(new BroodjesFileManager(), new TreeSet<>(Comparator.comparing(Broodje::getNaam)));
    }

    //Singleton pattern
    public static BroodjesDB getInstance() {
        if (instance == null) instance = new BroodjesDB();
        return instance;
    }
}
