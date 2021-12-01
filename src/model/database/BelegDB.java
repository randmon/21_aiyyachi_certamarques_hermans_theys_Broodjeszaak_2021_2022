package model.database;

import model.database.filemanager.BelegTXTFileManager;
import model.domain.Beleg;

import java.util.Comparator;
import java.util.TreeSet;

public class BelegDB extends DB<Beleg> {
    private static BelegDB instance;

    private BelegDB() {
        super(new BelegTXTFileManager(), new TreeSet<>(Comparator.comparing(Beleg::getNaam)));
    }

    //Singleton pattern
    public static BelegDB getInstance() {
        if(instance == null) instance = new BelegDB();
        return instance;
    }
}
