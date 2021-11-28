package model.database;

import model.database.filemanager.BroodjesFileManager;
import model.domain.Broodje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class BroodjesDB extends DB<Broodje> {
    private static BroodjesDB instance;
    private List<Broodje> broodjesList = new ArrayList<>();

    private BroodjesDB() {
        super(new BroodjesFileManager(), new TreeSet<>(Comparator.comparing(Broodje::getNaam)));
    }

    //Singleton pattern
    public static BroodjesDB getInstance() {
        if (instance == null) instance = new BroodjesDB();
        return instance;
    }
}
