package model.database;

import model.database.filemanager.BroodjesFileManagerStrategyFactory;
import model.domain.Broodje;

import java.util.Comparator;
import java.util.TreeSet;

public class BroodjesDB extends DB<Broodje> {
    private static BroodjesDB instance;

    private BroodjesDB(String fileType) {
        super(
                BroodjesFileManagerStrategyFactory.getInstance().createBroodjesStrategy(fileType),
                new TreeSet<>(Comparator.comparing(Broodje::getNaam)));
    }

    //Singleton pattern
    public static BroodjesDB getInstance(String fileType) {
        if (instance == null) instance = new BroodjesDB(fileType);
        return instance;
    }
}
